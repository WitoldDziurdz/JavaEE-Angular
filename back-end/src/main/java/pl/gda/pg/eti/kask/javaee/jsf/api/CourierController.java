package pl.gda.pg.eti.kask.javaee.jsf.api;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.CourierService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Courier;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Pack;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collection;

import static javax.ws.rs.core.Response.noContent;
import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.status;
import static pl.gda.pg.eti.kask.javaee.jsf.api.UriUtils.uri;

@Path("/couriers")
public class CourierController {
    @Inject
    CourierService courierService;

    @GET
    public Collection<Courier> getAllCouriers(){
        return courierService.findAllCouriers();
    }

    @GET
    @Path("/{courier}/packs")
    public Collection<Pack> getPacksOfCourier(@PathParam("courier") Courier courier){
        return courierService.findPacksOfCourier(courier);
    }

    @POST
    public Response saveCourier(Courier courier){
        courierService.saveCourier(courier);
        return Response.created(uri(CourierController.class, "getCourier", courier.getId())).build();
    }

    @GET
    @Path("/{courier}")
    public Courier getCourier(@PathParam("courier") Courier courier){
        return courier;
    }

    @DELETE
    @Path("/{courier}")
    public Response deleteCourier(@PathParam("courier") Courier courier){
        courierService.removeCourier(courier);
        return noContent().build();
    }

    @PUT
    @Path("/{courier}")
    public Response updateCourier(@PathParam("courier") Courier originalCourier, Courier updatedCourier) {
        if (!originalCourier.getId().equals(updatedCourier.getId())) {
            return status(Response.Status.BAD_REQUEST).build();
        }
        courierService.saveCourier(updatedCourier);
        return ok().build();
    }
}

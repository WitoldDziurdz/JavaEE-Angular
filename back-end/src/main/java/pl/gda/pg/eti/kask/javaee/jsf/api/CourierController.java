package pl.gda.pg.eti.kask.javaee.jsf.api;

import pl.gda.pg.eti.kask.javaee.jsf.api.wrappers.CourierWrapper;
import pl.gda.pg.eti.kask.javaee.jsf.api.wrappers.PackWrapper;
import pl.gda.pg.eti.kask.javaee.jsf.api.utils.WrapUtils;
import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.CourierService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Courier;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Collection;

import static javax.ws.rs.core.Response.noContent;
import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.status;
import static pl.gda.pg.eti.kask.javaee.jsf.api.utils.LinkUtils.getCourierLinks;
import static pl.gda.pg.eti.kask.javaee.jsf.api.utils.UriUtils.uri;

@Path("/couriers")
public class CourierController {
    @Inject
    CourierService courierService;

    @Context
    UriInfo uriInfo;

    @GET
    @Path("")
    public Collection<CourierWrapper> getAllCouriers(){
        return  WrapUtils.wrapCouriers(courierService.findAllCouriers());
    }

    @GET
    @Path("/{courier}/packs")
    public Collection<PackWrapper> getPacksOfCourier(@PathParam("courier") Courier courier){
        Collection<PackWrapper> packWrappers = WrapUtils.wrapPacks(courierService.findPacksOfCourier(courier));
        return packWrappers;
    }

    @POST
    public Response saveCourier(Courier courier){
        courierService.saveCourier(courier);
        return Response.created(uri(CourierController.class, "getCourier", courier.getId())).build();
    }

    @GET
    @Path("/{courier}")
    public CourierWrapper getCourier(@PathParam("courier") Courier courier){
        return new CourierWrapper(courier,getCourierLinks(courier.getId()));
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

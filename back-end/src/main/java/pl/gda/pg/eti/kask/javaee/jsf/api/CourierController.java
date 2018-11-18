package pl.gda.pg.eti.kask.javaee.jsf.api;

import pl.gda.pg.eti.kask.javaee.jsf.api.wrappers.CourierWrapper;
import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.CourierService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Courier;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Link;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Pack;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static javax.ws.rs.core.Response.noContent;
import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.status;
import static pl.gda.pg.eti.kask.javaee.jsf.api.UriUtils.absoluteUri;
import static pl.gda.pg.eti.kask.javaee.jsf.api.UriUtils.uri;

@Path("/couriers")
public class CourierController {
    @Inject
    CourierService courierService;

    @Context
    UriInfo uriInfo;

    @GET
    @Path("")
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

    public static List<Link> getCourierLinks(int id){
        List links = UriUtils.asList(
                new Link("self", absoluteUri(CourierController.class, "getCourier", id)),
                new Link("delete", absoluteUri(CourierController.class, "deleteCourier", id)),
                new Link("couriers", absoluteUri(CourierController.class, "getAllCouriers")),
                new Link("courier_packs", absoluteUri(CourierController.class, "getPacksOfCourier", id))
                );
        return links;
    }
}

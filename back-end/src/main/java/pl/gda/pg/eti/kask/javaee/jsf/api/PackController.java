package pl.gda.pg.eti.kask.javaee.jsf.api;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.CourierService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Link;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Pack;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.List;

import static javax.ws.rs.core.Response.noContent;
import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.status;
import static pl.gda.pg.eti.kask.javaee.jsf.api.UriUtils.absoluteUri;
import static pl.gda.pg.eti.kask.javaee.jsf.api.UriUtils.uri;

@Path("/packs")
public class PackController {

    @Inject
    CourierService courierService;

    @GET
    @Path("")
    public Collection<Pack> getAllPacks(){
        return courierService.findAllPacks();
    }

    @POST
    public Response savePack(Pack pack){
        courierService.savePack(pack);
        return Response.created(uri(PackController.class, "getPack", pack.getId())).build();
    }

    @GET
    @Path("/{pack}")
    public Pack getPack(@PathParam("pack") Pack pack){
        return pack;
    }

    @DELETE
    @Path("/{pack}")
    public Response deletePack(@PathParam("pack") Pack pack){
        courierService.removePack(pack);
        return noContent().build();
    }

    @PUT
    @Path("/{pack}")
    public Response updatePack(@PathParam("pack") Pack originalPack, Pack updatedPack) {
        if (!originalPack.getId().equals(updatedPack.getId())) {
            return status(Response.Status.BAD_REQUEST).build();
        }
        courierService.savePack(updatedPack);
        return ok().build();
    }

    public static List<Link> getPackLinks(int id){
        List links = UriUtils.asList(
                new Link("self", absoluteUri(PackController.class, "getPack", id)),
                new Link("delete", absoluteUri(PackController.class, "deletePack", id)),
                new Link("packs", absoluteUri(PackController.class, "getAllPacks"))
        );
        return links;
    }
}

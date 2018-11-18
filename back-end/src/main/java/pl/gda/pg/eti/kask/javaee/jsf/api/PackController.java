package pl.gda.pg.eti.kask.javaee.jsf.api;

import pl.gda.pg.eti.kask.javaee.jsf.api.pagination.PackPagination;
import pl.gda.pg.eti.kask.javaee.jsf.api.utils.UriUtils;
import pl.gda.pg.eti.kask.javaee.jsf.api.wrappers.PackWrapper;
import pl.gda.pg.eti.kask.javaee.jsf.api.utils.WrapUtils;
import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.CourierService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Link;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Pack;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collection;

import static javax.ws.rs.core.Response.noContent;
import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.status;
import static pl.gda.pg.eti.kask.javaee.jsf.api.utils.LinkUtils.getPackLinks;
import static pl.gda.pg.eti.kask.javaee.jsf.api.utils.UriUtils.uri;

@Path("/packs")
public class PackController {

    @Inject
    CourierService courierService;

    @GET
    @Path("")
    public PackPagination getAllPacks(@DefaultValue("0") @QueryParam("start") Integer start,
                                      @DefaultValue("3") @QueryParam("limit") Integer limit){
        //return WrapUtils.wrapPacks(courierService.findAllPacks());
        PackPagination packPagination = new PackPagination(start,limit,courierService.findAllPacks());
        return packPagination;
    }

    @POST
    public Response savePack(Pack pack){
        courierService.savePack(pack);
        return Response.created(uri(PackController.class, "getPack", pack.getId())).build();
    }

    @GET
    @Path("/{pack}")
    public PackWrapper getPack(@PathParam("pack") Pack pack){
        return new PackWrapper(pack,getPackLinks(pack.getId()));
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

}

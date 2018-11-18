package pl.gda.pg.eti.kask.javaee.jsf.api;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.CourierService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Courier;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Department;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Link;

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

@Path("/departments")
public class DepartmentController {

    @Inject
    CourierService courierService;

    @GET
    public Collection<Department> getAllDepartments(){
        return courierService.findAllDepartments();
    }

    @GET
    @Path("/{department}/couriers")
    public Collection<Courier> getPacksOfCourier(@PathParam("department") Department department){
        return courierService.findCouriersOfDepartment(department);
    }

    @POST
    public Response saveDepartment(Department department){
        courierService.saveDepartment(department);
        return Response.created(uri(DepartmentController.class, "getDepartment", department.getId())).build();
    }

    @GET
    @Path("/{department}")
    public Department getDepartment(@PathParam("department") Department department){
        return department;
    }

    @DELETE
    @Path("/{department}")
    public Response deleteDepartment(@PathParam("department") Department department){
        courierService.removeDepartment(department);
        return noContent().build();
    }

    @PUT
    @Path("/{department}")
    public Response updateDepartment(@PathParam("department") Department originalDepartment, Department updatedDepartment) {
        if (!originalDepartment.getId().equals(updatedDepartment.getId())) {
            return status(Response.Status.BAD_REQUEST).build();
        }
        courierService.saveDepartment(updatedDepartment);
        return ok().build();
    }


    public static List<Link> getDepartmentLinks(int id){
        List links = UriUtils.asList(
                new Link("self", absoluteUri(DepartmentController.class, "getDepartment", id)),
                new Link("delete", absoluteUri(DepartmentController.class, "deleteDepartment", id)),
                new Link("departments", absoluteUri(DepartmentController.class, "getAllDepartments")),
                new Link("department_couriers", absoluteUri(DepartmentController.class, "getPacksOfCourier", id))
        );
        return links;
    }

}

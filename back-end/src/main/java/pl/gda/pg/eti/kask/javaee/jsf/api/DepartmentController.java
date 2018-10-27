package pl.gda.pg.eti.kask.javaee.jsf.api;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.CourierService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Courier;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Department;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collection;

import static javax.ws.rs.core.Response.noContent;
import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.status;
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

}

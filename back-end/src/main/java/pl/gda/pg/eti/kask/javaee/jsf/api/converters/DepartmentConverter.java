package pl.gda.pg.eti.kask.javaee.jsf.api.converters;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.CourierService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Department;

import javax.ws.rs.ext.Provider;

@Provider
public class DepartmentConverter extends AbstractEntityConverter<Department> {
    public DepartmentConverter() {
        super(Department.class, Department::getId, CourierService::findDepartment);
    }
}

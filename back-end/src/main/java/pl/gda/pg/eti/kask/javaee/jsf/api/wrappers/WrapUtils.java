package pl.gda.pg.eti.kask.javaee.jsf.api.wrappers;

import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Courier;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Department;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Pack;

import java.util.ArrayList;
import java.util.List;

import static pl.gda.pg.eti.kask.javaee.jsf.api.CourierController.getCourierLinks;

public class WrapUtils {

    public static List<CourierWrapper> wrapCouriers(List<Courier> couriers){
        List<CourierWrapper> courierWrappers = new ArrayList<>();
        for(Courier courier:couriers){
            courierWrappers.add(new CourierWrapper(courier, getCourierLinks(courier.getId())));
        }
        return courierWrappers;
    }

    public static List<PackWrapper> wrapPacks(List<Pack> packs){
        List<PackWrapper> packWrappers = new ArrayList<>();
        for(Pack pack:packs){
            packWrappers.add(new PackWrapper(pack, getCourierLinks(pack.getId())));
        }
        return packWrappers;
    }

    public static List<DepartmentWrapper> wrapDepartments(List<Department> departments){
        List<DepartmentWrapper> departmentWrappers = new ArrayList<>();
        for(Department department:departments){
            departmentWrappers.add(new DepartmentWrapper(department, getCourierLinks(department.getId())));
        }
        return departmentWrappers;
    }
}

package pl.gda.pg.eti.kask.javaee.jsf.api.utils;

import pl.gda.pg.eti.kask.javaee.jsf.api.wrappers.CourierWrapper;
import pl.gda.pg.eti.kask.javaee.jsf.api.wrappers.DepartmentWrapper;
import pl.gda.pg.eti.kask.javaee.jsf.api.wrappers.PackWrapper;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Courier;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Department;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Pack;

import java.util.ArrayList;
import java.util.List;

import static pl.gda.pg.eti.kask.javaee.jsf.api.utils.LinkUtils.getCourierLinks;
import static pl.gda.pg.eti.kask.javaee.jsf.api.utils.LinkUtils.getDepartmentLinks;
import static pl.gda.pg.eti.kask.javaee.jsf.api.utils.LinkUtils.getPackLinks;

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
            packWrappers.add(new PackWrapper(pack, getPackLinks(pack.getId())));
        }
        return packWrappers;
    }

    public static List<DepartmentWrapper> wrapDepartments(List<Department> departments){
        List<DepartmentWrapper> departmentWrappers = new ArrayList<>();
        for(Department department:departments){
            departmentWrappers.add(new DepartmentWrapper(department, getDepartmentLinks(department.getId())));
        }
        return departmentWrappers;
    }
}

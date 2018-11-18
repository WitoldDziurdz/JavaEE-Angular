package pl.gda.pg.eti.kask.javaee.jsf.api.utils;

import pl.gda.pg.eti.kask.javaee.jsf.api.CourierController;
import pl.gda.pg.eti.kask.javaee.jsf.api.DepartmentController;
import pl.gda.pg.eti.kask.javaee.jsf.api.PackController;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Link;

import java.util.List;

import static pl.gda.pg.eti.kask.javaee.jsf.api.utils.UriUtils.absoluteUri;

public class LinkUtils {
    public static List<Link> getPackLinks(int id){
        List links = UriUtils.asList(
                new Link("self", absoluteUri(PackController.class, "getPack", id)),
                new Link("delete", absoluteUri(PackController.class, "deletePack", id)),
                new Link("packs", absoluteUri(PackController.class, "getAllPacks"))
        );
        return links;
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


    public static List<Link> getCourierLinks(int id){
        List links = UriUtils.asList(
                new Link("self", absoluteUri(CourierController.class, "getCourier", id)),
                new Link("delete", absoluteUri(CourierController.class, "deleteCourier", id)),
                new Link("couriers", absoluteUri(CourierController.class, "getAllCouriers")),
                new Link("courier_packs", absoluteUri(CourierController.class, "getPacksOfCourier", id))
        );
        return links;
    }

    public static List<Link> getMainLinks(){
        List links = UriUtils.asList(
                new Link("packs", absoluteUri(PackController.class, "getAllPacks")),
                new Link("couriers", absoluteUri(CourierController.class, "getAllCouriers")),
                new Link("departments", absoluteUri(DepartmentController.class, "getAllDepartments"))
        );
        return links;
    }
}

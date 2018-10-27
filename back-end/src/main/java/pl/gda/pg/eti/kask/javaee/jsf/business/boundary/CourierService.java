package pl.gda.pg.eti.kask.javaee.jsf.business.boundary;

import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Courier;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Department;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Pack;

import java.io.Serializable;
import java.util.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class CourierService implements Serializable {
    private final SortedMap<Integer, Courier> couriers = new TreeMap();
    private final SortedMap<Integer, Pack> packs = new TreeMap();
    private final SortedMap<Integer, Department> departments = new TreeMap<>();

    @PostConstruct
    public void init() {
        DataGenerator.generate(couriers, packs, departments);
    }

    public List<Pack> findAllPacks() {
        return new ArrayList<Pack>(packs.values());
    }

    public List<Pack> findPacksOfCourier(Courier courier) {
        return courier.getPacks();
    }

    public List<Courier> findAllCouriers() {
        return new ArrayList<Courier>(couriers.values());
    }

    public List<Department> findAllDepartments() {
        return new ArrayList<Department>(departments.values());
    }

    public List<Courier> findCouriersOfDepartment(Department department) {
        return department.getCouriers();
    }

    public Pack findPack(int id) {
        return packs.get(id);
    }

    public Courier findCourier(int id) {
        return couriers.get(id);
    }

    public Department findDepartment(int id) {
        return departments.get(id);
    }

    public void removePack(Pack pack) {
        removePackFromCouriers(pack);
        packs.remove(pack.getId());
    }

    public void removeCourier(Courier courier) {
        removeCourierFromDepartments(courier);
        couriers.remove(courier.getId());
    }

    public void removeDepartment(Department department) {
        departments.remove(department.getId());
    }

    public void savePack(Pack pack) {
        setId(pack);
        packs.put(pack.getId(), pack);
        updatePackFromCouriers(pack);
    }

    public void saveCourier(Courier courier) {
        setId(courier);
        couriers.put(courier.getId(), courier);
        updateCourierFromDepartments(courier);
    }

    public void saveDepartment(Department department){
        setId(department);
        departments.put(department.getId(),department);
    }

    private void removePackFromCouriers(Pack pack) {
        for (Courier courier : findAllCouriers()) {
            courier.getPacks().remove(pack);
        }
    }

    private void removeCourierFromDepartments(Courier courier){
        for(Department department: findAllDepartments()){
            department.getCouriers().remove(courier);
        }
    }

    private void updatePackFromCouriers(Pack pack) {
        for (Courier courier : findAllCouriers()) {
            courier.updatePack(pack);
        }
    }

    private  void updateCourierFromDepartments(Courier courier){
        for(Department department: findAllDepartments()){
            department.updateCourier(courier);
        }
    }

    private void setId(Courier courier) {
        if (courier.idIsNull()) {
            if (couriers.size() > 0) {
                courier.setId(couriers.lastKey() + 1);
            } else {
                courier.setId(1);
            }
        }
    }

    private void setId(Pack pack) {
        if (pack.idIsNull()) {
            if (packs.size() > 0) {
                pack.setId(packs.lastKey() + 1);
            } else {
                pack.setId(1);
            }
        }
    }

    private void setId(Department department) {
        if (department.idIsNull()) {
            if (departments.size() > 0) {
                department.setId(departments.lastKey() + 1);
            } else {
                department.setId(1);
            }
        }
    }
}
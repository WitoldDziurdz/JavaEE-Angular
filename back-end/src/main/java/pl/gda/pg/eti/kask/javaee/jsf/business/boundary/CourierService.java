package pl.gda.pg.eti.kask.javaee.jsf.business.boundary;

import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Courier;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Pack;

import java.io.Serializable;
import java.util.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class CourierService implements Serializable {
    private final SortedMap<Integer, Courier> couriers = new TreeMap();
    private final SortedMap<Integer, Pack> packs = new TreeMap();

    @PostConstruct
    public void init(){
        DataGenerator.generate(couriers, packs);
    }

    public List<Pack> findAllPacks(){
        return new ArrayList<Pack>(packs.values());
    }

    public List<Pack>  findPacksOfCourier(Courier courier){
        return courier.getPacks();
    }

    public List<Courier> findAllCouriers(){
        return new ArrayList<Courier>(couriers.values());
    }

    public Pack findPack(int id){
        return packs.get(id);
    }

    public Courier findCourier(int id){
        return couriers.get(id);
    }

    public void removePack(Pack pack){
        removePackFromCouriers(pack);
        packs.remove(pack.getId());
    }

    public void removeCourier(Courier courier){
        couriers.remove(courier.getId());
    }

    public void savePack(Pack pack){
        setId(pack);
        packs.put(pack.getId(),pack);
        updatePackFromCouriers(pack);
    }

    public void saveCourier(Courier courier){
        setId(courier);
        couriers.put(courier.getId(),courier);
    }

    private void removePackFromCouriers(Pack pack){
        for(Courier courier : findAllCouriers()){
           courier.getPacks().remove(pack);
        }
    }

    private void updatePackFromCouriers(Pack pack){
        for(Courier courier : findAllCouriers()){
            courier.updatePack(pack);
        }
    }

    private void setId(Courier courier){
        if(courier.idIsNull()){
            if(couriers.size() > 0) {
                courier.setId(couriers.lastKey() + 1);
            } else {
                courier.setId(1);
            }
        }
    }

    private void setId(Pack pack){
        if(pack.idIsNull()){
            if(packs.size() > 0) {
                pack.setId(packs.lastKey() + 1);
            } else {
                pack.setId(1);
            }
        }
    }
}
package pl.gda.pg.eti.kask.javaee.jsf.business.entities;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
public class Department implements Serializable {
    private Integer id;
    private int numberOfWorkers;
    private String address;
    private boolean isStorage;
    private List<Courier> couriers = new ArrayList<>();

    public boolean idIsNull(){
        return this.id == null;
    }

    public void updateCourier(Courier courier){
        if(couriers.contains(courier)){
            for(Courier selfCourier: couriers){
                if(selfCourier.equals(courier)) {
                    selfCourier.update(courier);
                }
            }
        }
    }
}


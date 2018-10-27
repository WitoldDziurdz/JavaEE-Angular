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
public class Courier implements Serializable {
    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private int age;
    private List<Pack> packs = new ArrayList<>();

    @Override
    public String toString(){
        return  this.name + " " + this.surname;
    }

    public void updatePack(Pack pack){
        if(packs.contains(pack)){
            for(Pack selfPack: packs){
                if(selfPack.equals(pack)) {
                    selfPack.update(pack);
                }
            }
        }
    }

    public void update(Courier courier){
        this.name = courier.name;
        this.surname = courier.surname;
        this.phone = courier.phone;
        this.age = courier.age;
    }

    public boolean idIsNull(){
        return this.id == null;
    }

}
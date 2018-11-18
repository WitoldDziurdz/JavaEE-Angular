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

    public Courier(Integer id, String name, String surname, String phone, int age, List<Pack> packs) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.age = age;
        this.packs = packs;
    }

    private List<Link> links = new ArrayList<>();

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

    public void addLink(String rel, String url){
        links.add(new Link(rel, url));
    }
}
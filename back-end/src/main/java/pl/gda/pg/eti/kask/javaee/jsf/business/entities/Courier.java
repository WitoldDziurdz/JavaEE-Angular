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
    List<Pack> packs = new ArrayList<>();

    @Override
    public String toString(){
        return  this.name + " " + this.surname;
    }
}
package pl.gda.pg.eti.kask.javaee.jsf.business.entities;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
public class Pack implements Serializable {
    private Integer id;
    private String address;
    private TypeSize typeSize;
    private double price;
    private boolean express;

    @Override
    public String toString(){
        return  this.id + " " + this.address;
    }
}
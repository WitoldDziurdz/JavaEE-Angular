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


    public void update(Pack pack){
        this.address = pack.address;
        this.typeSize = pack.typeSize;
        this.price = pack.price;
        this.express = pack.express;
    }

    public boolean idIsNull(){
        return this.id == null;
    }
}
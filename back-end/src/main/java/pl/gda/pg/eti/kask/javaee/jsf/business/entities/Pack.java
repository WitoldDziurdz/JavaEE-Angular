package pl.gda.pg.eti.kask.javaee.jsf.business.entities;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    private List<Link> links = new ArrayList<>();

    public Pack(Integer id, String address, TypeSize typeSize, double price, boolean express) {
        this.id = id;
        this.address = address;
        this.typeSize = typeSize;
        this.price = price;
        this.express = express;
    }

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

    public void addLink(String rel, String url){
        links.add(new Link(rel, url));
    }
}
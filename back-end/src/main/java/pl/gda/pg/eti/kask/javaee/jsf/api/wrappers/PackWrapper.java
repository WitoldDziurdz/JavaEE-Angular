package pl.gda.pg.eti.kask.javaee.jsf.api.wrappers;

import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Link;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Pack;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.TypeSize;

import java.io.Serializable;
import java.util.List;

public class PackWrapper implements Serializable {
    private Integer id;
    private String address;
    private TypeSize typeSize;
    private double price;
    private boolean express;
    private List<Link> links;

    public PackWrapper(Pack pack,  List<Link> links) {
        this.id = pack.getId();
        this.address = pack.getAddress();
        this.typeSize = pack.getTypeSize();
        this.price = pack.getPrice();
        this.express = pack.isExpress();
        this.links = links;
    }
}

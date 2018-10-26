package pl.gda.pg.eti.kask.javaee.jsf.api.converters;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.CourierService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Pack;

import javax.ws.rs.ext.Provider;


@Provider
public class PackConverter extends AbstractEntityConverter<Pack> {
    public PackConverter() {
        super(Pack.class, Pack::getId, CourierService::findPack);
    }
}
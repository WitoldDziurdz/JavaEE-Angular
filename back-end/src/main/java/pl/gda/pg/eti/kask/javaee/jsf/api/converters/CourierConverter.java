package pl.gda.pg.eti.kask.javaee.jsf.api.converters;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.CourierService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Courier;

import javax.ws.rs.ext.Provider;


@Provider
public class CourierConverter extends AbstractEntityConverter<Courier>{
    public CourierConverter() {
        super(Courier.class, Courier::getId, CourierService::findCourier);
    }
}

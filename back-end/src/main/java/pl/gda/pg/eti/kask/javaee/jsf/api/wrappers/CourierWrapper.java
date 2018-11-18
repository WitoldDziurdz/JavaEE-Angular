package pl.gda.pg.eti.kask.javaee.jsf.api.wrappers;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Courier;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Link;

import java.util.List;

@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
public class CourierWrapper {
    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private int age;

    private List<Link> links;

    public CourierWrapper(Courier courier, List<Link> links) {
        this.id = courier.getId();
        this.name = courier.getName();
        this.surname = courier.getSurname();
        this.phone = courier.getPhone();
        this.age = courier.getAge();
        this.links = links;
    }
}

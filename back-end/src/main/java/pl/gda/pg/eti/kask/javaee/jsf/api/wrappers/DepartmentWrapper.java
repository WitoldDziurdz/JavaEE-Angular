package pl.gda.pg.eti.kask.javaee.jsf.api.wrappers;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Department;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Link;

import java.util.List;

@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
public class DepartmentWrapper {
    private Integer id;
    private int numberOfWorkers;
    private String address;
    private boolean isStorage;

    private List<Link> links;

    public DepartmentWrapper(Department department, List<Link> links) {
        this.id = department.getId();
        this.numberOfWorkers = department.getNumberOfWorkers();
        this.address = department.getAddress();
        this.isStorage = department.isStorage();
        this.links = links;
    }
}

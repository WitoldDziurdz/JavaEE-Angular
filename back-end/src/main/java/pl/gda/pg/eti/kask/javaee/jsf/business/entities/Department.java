package pl.gda.pg.eti.kask.javaee.jsf.business.entities;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
public class Department implements Serializable {
    private Integer id;
    private int numberOfWorkers;
    private String address;
    private boolean isStorage;

    public boolean idIsNull(){
        return this.id == null;
    }
}


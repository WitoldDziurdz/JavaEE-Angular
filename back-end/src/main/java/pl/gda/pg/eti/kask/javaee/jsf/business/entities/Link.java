package pl.gda.pg.eti.kask.javaee.jsf.business.entities;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class Link implements Serializable {
    String rel;
    String url;
}
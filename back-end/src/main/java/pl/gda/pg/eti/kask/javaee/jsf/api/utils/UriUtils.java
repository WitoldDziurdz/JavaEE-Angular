package pl.gda.pg.eti.kask.javaee.jsf.api.utils;

import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Link;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UriUtils {
    private static String prefix = "/JAX-RX-1.0-SNAPSHOT/api";
    public static URI uri(Class<?> clazz, String method, Object... vals) {
        return UriBuilder.fromResource(clazz)
                .path(clazz, method)
                .build(vals);
    }

    public static List<Link> asList(Link ... links){
        List<Link> list = new ArrayList<>();
        list.addAll(Arrays.asList(links));
        return list;
    }


    public static String absoluteUri(Class<?> clazz, String method, Object... vals) {
        return  prefix.concat(uri(clazz,method,vals).getPath());
    }

    public static String uriWithQuery(Class<?> clazz, int start, int limit) {
        String url = UriBuilder.fromResource(clazz)
                .queryParam("start", String.valueOf(start))
                .queryParam("limit",String.valueOf(limit))
                .build().toString();
        return prefix.concat(url);
    }

}

package pl.gda.pg.eti.kask.javaee.jsf.business.boundary;

import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Courier;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Pack;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.TypeSize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DataGenerator {
    private DataGenerator(){

    }
    public static void generate(
            Map<Integer, Courier> couriers,
            Map<Integer, Pack> packs
    ){
        Pack p1 = new Pack(1,
                "Gdansk wyspianskiego 9",
                TypeSize.LARGE,
                10.22,
                false );
        Pack p2 = new Pack(2,
                "Gdansk wyspianskiego 12",
                TypeSize.SMALL,
                5,
                true );
        Pack p3 = new Pack(3,
                "Gdansk wyspianskiego 22",
                TypeSize.MEDIUM,
                5,
                true );
        Courier c1 = new Courier(1,"Hubert", "Polak","570434267",22,asList(p1,p2));
        Courier c2 = new Courier(2,"Piotr", "Majewski","570434211",44,asList(p3));
        packs.put(p1.getId(), p1);
        packs.put(p2.getId(), p2);
        packs.put(p3.getId(), p3);
        couriers.put(c1.getId(), c1);
        couriers.put(c2.getId(), c2);
    }

    private static List<Pack> asList(Pack... packs){
        List<Pack> list = new ArrayList<>();
        list.addAll(Arrays.asList(packs));
        return list;
    }
}

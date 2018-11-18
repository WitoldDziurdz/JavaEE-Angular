package pl.gda.pg.eti.kask.javaee.jsf.api.pagination;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.gda.pg.eti.kask.javaee.jsf.api.PackController;
import pl.gda.pg.eti.kask.javaee.jsf.api.utils.LinkUtils;
import pl.gda.pg.eti.kask.javaee.jsf.api.wrappers.PackWrapper;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Link;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Pack;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static pl.gda.pg.eti.kask.javaee.jsf.api.utils.UriUtils.uriWithQuery;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PackPagination implements Serializable {

    private List<PackWrapper> packs;

    private List<Link> links;

    public PackPagination(int start, final int limit, List<Pack> packs){
        if(start < 0 ){
            start = 0 ;
        }
        if(start > packs.size()){
            start =  packs.size();
        }

        int finish = start + limit;
        if(finish > packs.size()){
            finish = packs.size();
        }
        getLinks(start,limit,packs.size());
        this.packs = getPackWrappers(start,finish,packs);
    }

    private List<PackWrapper> getPackWrappers(final int start, final int finish, List<Pack> packs){
        List<PackWrapper> packWrappers = new ArrayList<>();
        List<Pack> elements = packs.subList(start,finish);
        for(Pack pack:elements){
            packWrappers.add(new PackWrapper(pack, LinkUtils.getPackLinks(pack.getId())));
        }
        return packWrappers;
    }

    private void getLinks(final int start, final int limit, final int size){
        links = LinkUtils.getMainLinks();
        if(start > 0){
            int prev = (start-limit) > 0 ?(start-limit):0;
            links.add(new Link("prev_page",uriWithQuery(PackController.class,prev,limit)));
        }
        if(start < size){
            int next = (start+limit) < size ?(start+limit):size;
            links.add(new Link("next_page",uriWithQuery(PackController.class,next,limit)));
        }
    }
}

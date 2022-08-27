package core.ics.domain.gateway;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import java.util.List;
import java.util.stream.Stream;

public interface IGatewayBase <E, I>{

    public PanacheRepositoryBase<E, I> getRepository();

    default void save(E object){
        getRepository().persistAndFlush(object);
    }

    default void save(List<E> object){
        getRepository().persist(object.stream());
    }

    default E getById(I id){
        return getRepository().findById(id);
    }

    default Stream<E> getAll(){
        return getRepository().findAll().stream();
    }
}

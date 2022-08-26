package core.ics.domain.gateway;

import core.ics.infra.db.model.EntityBase;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import java.util.List;
import java.util.stream.Stream;

public interface IGatewayBase <E extends EntityBase, I>{

    public PanacheRepositoryBase<E, I> getRepository();

    default void save(E object){
        Integer entityCode = 33;

        object.setEntityCode(entityCode);

        getRepository().persistAndFlush(object);
    }

    default void save(List<E> object){
        Integer entityCode = 33;
        getRepository().persist(object.stream().map(obj->{

            obj.setEntityCode(entityCode);

            return obj;
        }));
    }

    default E getById(I id){
        return getRepository().findById(id);
    }

    default Stream<E> getAll(){
        return getRepository().findAll().stream();
    }
}

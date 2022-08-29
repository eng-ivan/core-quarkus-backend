package core.ics.domain.gateway;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface IGatewayBase <E, I>{

    public PanacheRepositoryBase<E, I> getRepository();

    default void save(E object){
        getRepository().persistAndFlush(object);
    }

    default void save(List<E> object){
        getRepository().persist(object.stream());
    }

    default Optional<E> getById(Map<String, Object> mapId){

        String queryId = mapId.keySet().stream()
                .map(key->key + " = :" + key)
                .collect(Collectors.joining(" AND "));
        return getRepository().find(queryId,mapId).singleResultOptional();
    }

    default Stream<E> getAll(){
        return getRepository().findAll().stream();
    }
}

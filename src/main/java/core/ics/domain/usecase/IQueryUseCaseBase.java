package core.ics.domain.usecase;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public interface IQueryUseCaseBase <E,I> extends IUseCaseBase<E,I>{

    default Optional<E> getById(Map<String,Object> mapId){ return getGateway().getById(mapId); }

    default Stream<E> getAll(){ return getGateway().getAll(); }
}

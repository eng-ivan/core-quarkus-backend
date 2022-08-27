package core.ics.domain.usecase;

import java.util.stream.Stream;

public interface IQueryUseCaseBase <E,I> extends IUseCaseBase<E,I>{

    default E getById(I id){ return getGateway().getById(id); }

    default Stream<E> getAll(){ return getGateway().getAll(); }
}

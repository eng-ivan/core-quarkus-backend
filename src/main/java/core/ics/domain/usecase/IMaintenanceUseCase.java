package core.ics.domain.usecase;

import core.ics.infra.db.model.EntityBase;

public interface IMaintenanceUseCase <E extends EntityBase, I> extends IUseCaseBase<E, I> {

    default void save(E object){ getGateway().save(object); }

}

package core.ics.domain.usecase;

public interface IMaintenanceUseCase <E, I> extends IUseCaseBase<E, I> {

    default void save(E object){ getGateway().save(object); }

}

package core.ics.domain.usecase;

import core.ics.domain.gateway.IGatewayBase;
import core.ics.infra.db.model.EntityBase;

public interface IUseCaseBase <E extends EntityBase, I>{

    public IGatewayBase<E,I> getGateway();
}

package core.ics.domain.usecase;

import core.ics.domain.gateway.IGatewayBase;

public interface IUseCaseBase <E, I>{

    public IGatewayBase<E,I> getGateway();
}

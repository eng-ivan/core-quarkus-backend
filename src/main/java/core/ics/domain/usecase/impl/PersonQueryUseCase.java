package core.ics.domain.usecase.impl;

import core.ics.domain.gateway.IGatewayBase;
import core.ics.domain.usecase.IQueryUseCaseBase;
import core.ics.infra.db.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PersonQueryUseCase implements IQueryUseCaseBase<Person, Long> {

    @Inject
    IGatewayBase<Person, Long> gateway;

    @Override
    public IGatewayBase<Person, Long> getGateway() { return gateway; }
}

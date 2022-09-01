package core.ics.domain.usecase.impl;

import core.ics.domain.gateway.IGatewayBase;
import core.ics.domain.usecase.IQueryUseCaseBase;
import core.ics.infra.db.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PersonQueryUseCase implements IQueryUseCaseBase<Person, Integer> {

    @Inject
    IGatewayBase<Person, Integer> gateway;

    @Override
    public IGatewayBase<Person, Integer> getGateway() { return gateway; }
}

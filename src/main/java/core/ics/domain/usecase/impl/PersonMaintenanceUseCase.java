package core.ics.domain.usecase.impl;

import core.ics.domain.gateway.IGatewayBase;
import core.ics.domain.usecase.IMaintenanceUseCase;
import core.ics.infra.db.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PersonMaintenanceUseCase implements IMaintenanceUseCase<Person,Integer> {

    @Inject
    IGatewayBase<Person, Integer> gateway;

    @Override
    public IGatewayBase<Person, Integer> getGateway() { return gateway; }
}

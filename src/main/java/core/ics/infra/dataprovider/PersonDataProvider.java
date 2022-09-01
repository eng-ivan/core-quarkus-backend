package core.ics.infra.dataprovider;

import core.ics.domain.gateway.IGatewayBase;
import core.ics.infra.db.model.Person;
import core.ics.infra.db.repository.PersonRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PersonDataProvider implements IGatewayBase<Person, Long> {

    @Inject
    PersonRepository repository;

    @Override
    public PanacheRepositoryBase<Person, Long> getRepository() { return repository; }
}

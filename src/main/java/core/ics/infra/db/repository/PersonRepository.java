package core.ics.infra.db.repository;

import core.ics.infra.db.model.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonRepository implements PanacheRepositoryBase<Person, Integer> {
}

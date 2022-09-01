package core.ics.app.service.fixture;

import core.ics.app.dto.request.PersonSaveRequest;
import core.ics.infra.db.model.Person;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.runtime.PanacheQueryImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonServiceFixture {

    public static boolean empty = false;

    public static List<Person> responseList(Long id){
        if(empty) Stream.empty();
        return Stream.of(createObject(1L),createObject(2L)).collect(Collectors.toList());
    }

    public static PersonSaveRequest createObjectSaveRequest(Long id){

        return PersonSaveRequest.builder()
                .id(id)
                .personName("Person Name ".concat(id.toString()))
                .cpf("208.634.388-49")
                .address("address")
                .tokenKey("token")
                .build();
    }

    public static Person createObject(Long id){

        return Person.builder()
                .id(id)
                .personName("Person Name ".concat(id.toString()))
                .cpf("208.634.388-49")
                .address("address")
                .tokenKey("token")
                .registrationDate(LocalDateTime.now())
                .build();
    }

    public static PanacheQuery<Person> createObjectPanache(Boolean validNull){
        return new PanacheQueryImpl<Person>(null){

            @Override
            public Optional<Person> singleResultOptional() {
                return validNull ?
                        Optional.empty() :
                        Optional.of(createObject(1L));
            }

            @Override
            public Stream<Person> stream() {
                if (validNull) return  Stream.empty();
                return Stream.of(createObject(1L));
            }
        };
    }
}

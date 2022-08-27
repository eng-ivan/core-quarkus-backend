package core.ics.app.service.fixture;

import core.ics.app.dto.request.PersonSaveRequest;
import core.ics.app.dto.response.PersonResponse;
import core.ics.infra.db.model.Person;

import java.time.LocalDateTime;
import java.util.List;
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
}

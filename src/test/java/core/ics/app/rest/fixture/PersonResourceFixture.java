package core.ics.app.rest.fixture;

import core.ics.app.dto.request.PersonSaveRequest;
import core.ics.app.dto.response.PersonResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonResourceFixture {

    public static boolean empty = false;

    public static PersonResponse personResponse(Long id){
        return createObject(id);
    }

    public static List<PersonResponse> personResponseList(){
        if (empty) Stream.empty();

        return Stream.of(createObject(1L), createObject(2L)).collect(Collectors.toList());
    }

    public static PersonResponse createObject(Long id){
        return PersonResponse.builder()
                .entityCode(33)
                .id(id)
                .personName("Person Name ".concat(id.toString()))
                .cpf("123.456.789-00")
                .address("13063-580")
                .tokenKey("token-key")
                .registrationDate(LocalDateTime.now().minusHours(12).minusMinutes(0).minusSeconds(0))
                .build();
    }

    public static PersonSaveRequest createObjectSaveRequest(Long id){
        return PersonSaveRequest.builder()
                .id(id)
                .personName("Name ".concat(id.toString()))
                .cpf("123.456.789-00")
                .address("13063-580")
                .tokenKey("token-key")
                .build();
    }

}

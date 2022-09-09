package core.ics.app.rest.query;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import core.ics.app.service.query.PersonServiceQuery;
import core.ics.domain.exception.BusinessException;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static core.ics.app.rest.fixture.PersonResourceFixture.personResponseList;
import static core.ics.app.rest.fixture.PersonResourceFixture.personResponse;
import static core.ics.cross.utils.BusinessCode.INVALID_PARAMETER;
import static core.ics.cross.utils.BusinessCode.RESOURCE_NOT_FOUND;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
import static org.mockito.ArgumentMatchers.anyLong;
import static io.restassured.RestAssured.given;


@QuarkusTest
public class PersonResourceQueryTest {

    @InjectMock
    PersonServiceQuery personServiceQuery;
    private static ObjectMapper mapper;
    private static final String URL = "/v1/person";
    private static final String GET_BY_ID_URL = URL.concat("/%s");

    @BeforeAll
    public static void setup(){
        mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Test
    void testGetById(){
        when(personServiceQuery.getById(anyLong()))
                               .thenReturn(personResponse(1L));
        given()
                .when()
                .get(String.format(GET_BY_ID_URL, 1L))
                .then()
                .statusCode(200)
                .body("id", is(1))
                .body("personName", is("person name 1"))
                .body("cpf", is("123.456.789-00"))
                .body("address", is("13063-580"))
                .body("tokenKey", is("token-key"))
                .body("registrationDate", notNullValue());
    }

    @Test
    void testGetByIdFailure(){

        doThrow(new BusinessException(RESOURCE_NOT_FOUND))
                .when(personServiceQuery)
                .getById(anyLong());

        given()
                .when()
                .get(String.format(GET_BY_ID_URL, 1L))
                .then()
                .statusCode(500);
    }

    @Test
    void testGetAll(){

        when(personServiceQuery.getAll())
                               .thenReturn(personResponseList());
        given()
                .when()
                .get(URL)
                .then()
                .statusCode(200)
                .body("personName[0]", is("person name 1"))
                .body("personName[1]", is("person name 2"))
                .body("cpf[0]", is("123.456.789-00"))
                .body("cpf[1]", is("123.456.789-00"))
                .body("address[0]", is("13063-580"))
                .body("address[1]", is("13063-580"))
                .body("tokenKey[0]", is("token-key"))
                .body("tokenKey[1]", is("token-key"))
                .body("registrationDate", notNullValue());
    }

    @Test
    void testGetByIdWithInvalidParameter(){
        doThrow(new BusinessException(INVALID_PARAMETER))
                .when(this.personServiceQuery)
                .getById(1L);

        given()
                .when()
                .get(String.format(GET_BY_ID_URL, 1L))
                .then()
                .statusCode(500);
    }
}

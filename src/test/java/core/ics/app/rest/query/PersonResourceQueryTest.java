package core.ics.app.rest.query;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import core.ics.app.service.query.PersonServiceQuery;
import core.ics.cross.utils.BusinessCode;
import core.ics.domain.exception.BusinessException;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static core.ics.app.rest.fixture.PersonResourceFixture.*;
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
    private static final String URL = "/v1/person/%d";

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
                .get(String.format(URL, 1))
                .then()
                .statusCode(404)
                .body("entityCode", is(33))
                .body("id", is(1L))
                .body("personName", is("Person Name 1"))
                .body("cpf", is("123.456.789-00 1"))
                .body("address", is("13063-580 1"))
                .body("tokenKey", is("token-key 1"))
                .body("registrationDate", notNullValue());
    }

    @Test
    void testGetByIdFailure(){

        doThrow(new RuntimeException())
                .when(personServiceQuery)
                .getById(anyLong());

        given()
                .when()
                .get(String.format(URL, 1))
                .then()
                .statusCode(404);
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
                .body("entityCode", hasItems(33,33))
                .body("id", hasItems(1L,2L))
                .body("personName", everyItem(is("person name")))
                .body("cpf", everyItem(is("cpf")))
                .body("address", everyItem(is("address")))
                .body("tokenKey", everyItem(is("token-key")))
                .body("registrationDate", notNullValue());
    }

    @Test
    void testGetByIdWithInvalidParameter(){
        doThrow(new RuntimeException())
                .when(personServiceQuery)
                .getById(1L);

        given()
                .when()
                .get(String.format(URL, 1))
                .then()
                .statusCode(404)
                .body("code", is("Invalid Parameter"));
    }
}

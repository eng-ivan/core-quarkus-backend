package core.ics.app.rest.maintenance;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import core.ics.app.dto.request.PersonSaveRequest;
import core.ics.app.rest.fixture.PersonResourceFixture;
import core.ics.app.service.maintenance.PersonServiceMaintenance;
import core.ics.cross.utils.BusinessCode;
import core.ics.domain.exception.BusinessException;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static core.ics.app.rest.fixture.PersonResourceFixture.createObjectSaveRequest;

@QuarkusTest
public class PersonResourceMaintenanceTest {

    @InjectMock
    PersonServiceMaintenance personServiceMaintenance;

    private static final String URL = "/v1/person";
    private static final String GET_ID_URL = URL.concat("/%s");

    private static ObjectMapper mapper;

    @BeforeAll
    public static void setup(){
        mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Test
    void testSave() throws JsonProcessingException {

        doNothing()
                .when(personServiceMaintenance)
                .save(any(PersonSaveRequest.class));

        given()
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(createObjectSaveRequest("1")))
                .when()
                .post(URL)
                .then()
                .statusCode(400);
    }

    @Test
    void testSaveFailure() throws JsonProcessingException {

        doThrow(new BusinessException(BusinessCode.NONE))
                .when(personServiceMaintenance).save(any());

        given()
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(PersonResourceFixture.createObjectSaveRequest("1")))
                .when()
                .post(URL)
                .then()
                .statusCode(400);
    }

    @Test
    void testSaveInvalidMediaType() throws JsonProcessingException {

        given()
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(PersonResourceFixture.createObjectSaveRequest("1")))
                .when()
                .post(URL)
                .then()
                .statusCode(400);
    }

    @Test
    void testSaveInvalidParameter() throws JsonProcessingException {
        PersonSaveRequest request = PersonSaveRequest.builder().build();
        given()
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(request))
                .when()
                .post(URL)
                .then()
                .statusCode(400);
    }

    @Test
    void testMethodNotAllowed() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .patch(URL)
                .then()
                .statusCode(405);
    }
}
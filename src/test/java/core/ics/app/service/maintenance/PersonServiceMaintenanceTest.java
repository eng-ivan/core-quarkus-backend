package core.ics.app.service.maintenance;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import core.ics.app.service.fixture.PersonServiceFixture;
import core.ics.infra.db.model.Person;
import core.ics.infra.db.repository.PersonRepository;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@QuarkusTest
public class PersonServiceMaintenanceTest {

    @Inject
    PersonServiceMaintenance personServiceMaintenance;

    @InjectMock
    PersonRepository personRepository;

    private static ObjectMapper mapper;

    @BeforeAll
    public static void setup(){
        mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Test
    void testSave(){
        when(personRepository.find(anyString(),anyMap()))
                             .thenReturn(PersonServiceFixture.createObjectPanache(true));
        doNothing().when(personRepository).persistAndFlush(any(Person.class));

        personServiceMaintenance.save(PersonServiceFixture.createObjectSaveRequest(1));

        verify(personRepository).persistAndFlush(any(Person.class));
    }
}

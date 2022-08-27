package core.ics.app.service.query;


import core.ics.app.dto.response.PersonResponse;
import core.ics.domain.usecase.impl.PersonQueryUseCase;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static core.ics.app.service.fixture.PersonServiceFixture.empty;
import static core.ics.app.service.fixture.PersonServiceFixture.createObject;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@QuarkusTest
public class PersonServiceQueryTest {

    @Inject
    PersonServiceQuery personServiceQuery;

    @InjectMock
    PersonQueryUseCase personQueryUseCase;

    @Test
    void testGetById(){
        empty = false;

        when(personQueryUseCase.getById(anyLong())).thenReturn(createObject(1L));

        PersonResponse person = personServiceQuery.getById(1L);

        assertNotNull(person);
    }
}

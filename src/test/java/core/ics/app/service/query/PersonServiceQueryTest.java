package core.ics.app.service.query;

import core.ics.app.dto.response.PersonResponse;
import core.ics.domain.exception.BusinessException;
import core.ics.domain.usecase.impl.PersonQueryUseCase;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Optional;
import java.util.stream.Stream;

import static core.ics.app.service.fixture.PersonServiceFixture.createObject;
import static core.ics.app.service.fixture.PersonServiceFixture.empty;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyMap;
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

        when(personQueryUseCase.getById(anyMap()))
                               .thenReturn(Optional.of(createObject(1L)));

        PersonResponse person = personServiceQuery.getById(1L);

        assertNotNull(person);
    }

    @Test
    void testGetByIdFailure(){
        empty = true;

        when(personQueryUseCase.getById(anyMap()))
                               .thenReturn(Optional.empty());
        try {
            personServiceQuery.getById(1L);
        } catch (BusinessException be){ assertEquals(be.getMessage(), be.getCode()); }
    }

    @Test
    void testGetAll(){
        when(personQueryUseCase.getAll())
                               .thenReturn(Stream.empty());
        try {
            personServiceQuery.getAll();
        } catch (BusinessException be){ assertEquals(be.getMessage(), be.getCode()); }
    }

    @Test
    void testGetAllFailure(){
        empty = true;

        when(personQueryUseCase.getAll())
                               .thenReturn(Stream.of(createObject(1L)));
        try {
            personServiceQuery.getAll();
        } catch (BusinessException be){ assertEquals(be.getMessage(), be.getCode()); }
    }
}

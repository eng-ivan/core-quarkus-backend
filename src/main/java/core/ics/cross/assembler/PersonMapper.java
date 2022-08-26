package core.ics.cross.assembler;
import core.ics.app.dto.request.PersonSaveRequest;
import core.ics.app.dto.response.PersonResponse;
import core.ics.infra.db.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface PersonMapper {

    Person toEntity(PersonSaveRequest request);

    PersonResponse toResponse(Person person);
}

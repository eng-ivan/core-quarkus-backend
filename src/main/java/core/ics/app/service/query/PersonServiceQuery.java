package core.ics.app.service.query;

import core.ics.app.dto.response.PersonResponse;
import core.ics.cross.assembler.PersonMapper;
import core.ics.domain.usecase.impl.PersonQueryUseCase;
import core.ics.infra.db.model.Person;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ApplicationScoped
public class PersonServiceQuery {

    @Inject
    PersonQueryUseCase personQueryUseCase;

    @Inject
    PersonMapper mapper;

    public PersonResponse getById(Long id){

        log.info("[getById] - Fetch id {}", id);
        Person person = personQueryUseCase.getById(id);
        return mapper.toResponse(person);
    }

    public List<PersonResponse> getAll(){
        log.info("[getAll] Fetch");

        List<PersonResponse> responseList = personQueryUseCase
                .getAll()
                .map(mapper::toResponse)
                .collect(Collectors.toList());

        if (responseList.isEmpty()){
            log.warn("[getAll] - Empty list");
            throw new RuntimeException();
        }

        return responseList;
    }
}
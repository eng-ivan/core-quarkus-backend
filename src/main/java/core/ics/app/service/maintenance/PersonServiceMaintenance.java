package core.ics.app.service.maintenance;

import core.ics.app.dto.request.PersonSaveRequest;
import core.ics.cross.assembler.PersonMapper;
import core.ics.cross.utils.BusinessCode;
import core.ics.domain.exception.BusinessException;
import core.ics.domain.usecase.impl.PersonMaintenanceUseCase;
import core.ics.infra.db.model.Person;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Slf4j
@ApplicationScoped
public class PersonServiceMaintenance {

    @Inject
    PersonMaintenanceUseCase personMaintenanceUseCase;

    @Inject
    PersonMapper mapper;

    public void save(PersonSaveRequest request){
        log.info("Saved entity object {}",request);

        Person person = mapper.toEntity(request);
        try {
            personMaintenanceUseCase.save(person);
            log.info("Person saved success");
        }catch (Exception ex){ throw new BusinessException(BusinessCode.SAVE_ERROR); }
    }
}

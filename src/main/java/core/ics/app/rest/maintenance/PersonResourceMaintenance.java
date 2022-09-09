package core.ics.app.rest.maintenance;

import core.ics.app.dto.request.PersonSaveRequest;
import core.ics.app.dto.response.BaseResponse;
import core.ics.app.service.maintenance.PersonServiceMaintenance;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@ApplicationScoped
@Path("/v1/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class PersonResourceMaintenance {

    @Inject
    PersonServiceMaintenance personServiceMaintenance;

    @POST
    @Transactional
    public Response save(@RequestBody @Valid PersonSaveRequest personSaveRequest){
        personServiceMaintenance.save(personSaveRequest);
        return Response.created(URI.create("/v1/person"))
                       .entity(BaseResponse.builder().code("201").message("Person Saved").build())
                       .build();
    }
}

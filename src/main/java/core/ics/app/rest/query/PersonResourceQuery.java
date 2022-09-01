package core.ics.app.rest.query;

import core.ics.app.dto.response.PersonResponse;
import core.ics.app.service.query.PersonServiceQuery;
import core.ics.cross.utils.ValidationParameter;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Slf4j
@ApplicationScoped
public class PersonResourceQuery {

    @Inject
    PersonServiceQuery personServiceQuery;

    @GET
    @Path("/{id}")
    public PersonResponse getById(@PathParam("id") String id){
        log.info("[getById] - Fetch id {}", id);
        return personServiceQuery.getById(ValidationParameter.validateParamLong(id));
    }

    @GET
    public List<PersonResponse> getAll(){
        log.info("[getAll] - Fetch All");
        return personServiceQuery.getAll();
    }
}

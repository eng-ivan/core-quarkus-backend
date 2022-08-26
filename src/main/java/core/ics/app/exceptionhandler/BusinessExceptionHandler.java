package core.ics.app.exceptionhandler;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class BusinessExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        return mapExceptionToResponse(exception);
    }

    private Response mapExceptionToResponse(Exception exception) {

        return null;
    }

    private Response buildResponse(String problem, String message, String code, Response.Status status) {
        return null;
    }

    private Response buildResponse(String problem, Exception exception, Response.Status status) {

        return buildResponse(problem,exception.getMessage(),null,status);
    }
}

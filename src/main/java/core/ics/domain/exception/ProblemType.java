package core.ics.domain.exception;

import lombok.Getter;

import javax.ws.rs.core.Response.Status;

@Getter
public enum ProblemType {

    RESOURCE_NOT_FOUND("","Resource not found",Status.OK);
    //SYSTEM_ERROR("","",Status.INTERNAL_SERVER_ERROR);
    //INVALID_DATA("","",Status.BAD_REQUEST);
    //GENERIC("","",Status.OK);
    String title;
    String uri;
    Status status;

    ProblemType(String path, String title, Status statusCode){
        this.uri = "main path" + path;
        this.title = title;
        this.status = statusCode;
    }
}

package core.ics.domain.exception;

import lombok.Getter;

import javax.ws.rs.core.Response.Status;

import static core.ics.domain.exception.ProblemType.GENERIC;


@Getter
public enum ProblemType {

    INVALID_FORMAT_DATA("/invalid-format-data","invalid formatted data", Status.BAD_REQUEST),
    INVALID_DATA("/invalid-data","invalid data", Status.BAD_REQUEST),
    INVALID_PARAMETER("/invalid-parameter","invalid parameter", Status.BAD_REQUEST),
    NO_PROBLEM("/no-problem","no problem", Status.OK),
    RECORD_NOT_FOUND("/record-not-found","record not found", Status.OK),
    SAVE_ERROR("/save-error","saved on error", Status.BAD_REQUEST),
    RECORD_ALREADY_EXISTS("/record-already-exists","record already exists", Status.OK),
    RESOURCE_NOT_FOUND("/resource-not-found","resource not found", Status.OK),
    GENERIC("/generic","generic", Status.OK);

    String title;
    String uri;
    Status status;

    ProblemType(String path, String title, Status statusCode){
        this.uri = "main path" + path;
        this.title = title;
        this.status = statusCode;
    }
}

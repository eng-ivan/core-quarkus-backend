package core.ics.cross.utils;

import core.ics.domain.exception.ProblemType;
import lombok.Getter;
import java.util.stream.Stream;

@Getter
public enum BusinessCode {

    GENERIC("generic","internal system error has occurred", ProblemType.GENERIC),
    NONE("", "", ProblemType.GENERIC),
    SAVE_ERROR("/save-error","saved on error", ProblemType.SAVE_ERROR),
    INVALID_JSON("INVALID JSON", "INVALID JSON", ProblemType.INVALID_FORMAT_DATA),
    INVALID_FORMAT_DATA("/invalid-format-data","invalid formatted data", ProblemType.INVALID_FORMAT_DATA),
    INVALID_DATA("/invalid-data","invalid data", ProblemType.INVALID_FORMAT_DATA),
    INVALID_PARAMETER("/invalid-parameter","invalid parameter", ProblemType.INVALID_PARAMETER),
    NO_PROBLEM("/no-problem","no problem", ProblemType.NO_PROBLEM),
    RECORD_NOT_FOUND("/record-not-found","record not found", ProblemType.RECORD_NOT_FOUND),
    RECORD_ALREADY_EXISTS("/record-already-exists","record already exists", ProblemType.RECORD_ALREADY_EXISTS),
    RESOURCE_NOT_FOUND("/resource-not-found","resource not found", ProblemType.RESOURCE_NOT_FOUND);

    String code;
    String message;
    ProblemType problemType;

    BusinessCode(String code, String message, ProblemType problemType){
        this.code = code;
        this.message = message;
        this.problemType = problemType;
    }

    public static BusinessCode getByCode(String id){
        return Stream.of(values())
                .filter(code -> code.code.equals(id))
                .findFirst()
                .orElse(GENERIC);
    }
}

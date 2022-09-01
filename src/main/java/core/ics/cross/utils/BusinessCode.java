package core.ics.cross.utils;

import core.ics.domain.exception.ProblemType;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum BusinessCode {

    GENERIC("","", ProblemType.SYSTEM_ERROR),
    NONE("","", ProblemType.SYSTEM_ERROR);
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

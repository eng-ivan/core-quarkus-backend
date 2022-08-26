package core.ics.domain.exception;

import core.ics.cross.utils.BusinessCode;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

@Data
@RegisterForReflection
public class BusinessException extends RuntimeException{

    final String code;

    public BusinessException(BusinessCode code){
        super(code.getCode());
        this.code = code.getCode();
    }
}

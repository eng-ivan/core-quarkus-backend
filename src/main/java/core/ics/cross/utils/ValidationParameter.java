package core.ics.cross.utils;

import core.ics.domain.exception.BusinessException;

public class ValidationParameter {

    private ValidationParameter(){}

    public static Integer validateParamInteger(String value){
        try {
            if (value == null) throw new BusinessException(BusinessCode.INVALID_PARAMETER);
            return Integer.parseInt(value);
        }catch (NumberFormatException ex){ throw new BusinessException(BusinessCode.INVALID_FORMAT_DATA); }
    }

    public static Long validateParamLong(String value){
        try {
            if (value == null) throw new BusinessException(BusinessCode.INVALID_PARAMETER);
            return Long.parseLong(value);
        }catch (NumberFormatException ex){ throw new BusinessException(BusinessCode.INVALID_FORMAT_DATA); }
    }
}

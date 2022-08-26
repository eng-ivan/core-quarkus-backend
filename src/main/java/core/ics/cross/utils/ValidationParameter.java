package core.ics.cross.utils;

public class ValidationParameter {

    private ValidationParameter(){}

    public static Integer validateParamInteger(String value){
        try {
            return Integer.parseInt(value);
        }catch (NumberFormatException ex){ throw new RuntimeException(); }
    }

    public static Long validateParamLong(String value){
        try {
            return Long.parseLong(value);
        }catch (NumberFormatException ex){ throw new RuntimeException(); }
    }

    public static Short validateParamShort(String value){
        try {
            return Short.parseShort(value);
        } catch (NumberFormatException ex){ throw new RuntimeException(); }
    }
}

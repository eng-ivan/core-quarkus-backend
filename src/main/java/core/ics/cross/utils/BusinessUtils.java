package core.ics.cross.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public final class BusinessUtils {

    private BusinessUtils(){}

    public static Map<String, Object> createMapId(Object... object){

        Map<String, Object> mapId = new HashMap<>();

        for (int index = 0; index< object.length; index+= 2){
            mapId.put(object[index].toString(), object[index+1]);
        }

        return mapId;
    }
}

package challenge.utils;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParserUtils {
    
    private final static ObjectMapper jsonMapper = new ObjectMapper();
    
    static {
        jsonMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        jsonMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T stringToObject(String json, Class<?> objectClass) throws IOException {
        return (T) jsonMapper.readValue(json, objectClass);
    }
    
    public static String objectToString(Object object) throws JsonProcessingException {
        return jsonMapper.writeValueAsString(object);
    }
    
}

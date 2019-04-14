package challenge.utils;

import java.util.UUID;

public class TokenUtils {
    
    public static String generateRandomToken() {
        return UUID.randomUUID().toString();
    } 
}

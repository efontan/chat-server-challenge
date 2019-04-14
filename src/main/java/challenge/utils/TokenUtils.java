package challenge.utils;

import java.util.UUID;

public class TokenUtils {
    
    /**
     * Generates a unique and random token.
     * @return
     */
    public static String generateRandomToken() {
        return UUID.randomUUID().toString();
    } 
}

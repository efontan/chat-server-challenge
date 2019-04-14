package challenge.utils;

import java.util.UUID;

public class TokenUtils {
    
    /**
     * Generates a unique token.
     * @return A random unique token.
     */
    public static String generateRandomToken() {
        return UUID.randomUUID().toString();
    } 
}

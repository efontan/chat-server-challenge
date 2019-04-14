package challenge.exception;

public class ValidationException
    extends RuntimeException {
    
    public ValidationException() {
    }
    
    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public ValidationException(Throwable cause) {
        super(cause);
    }
}

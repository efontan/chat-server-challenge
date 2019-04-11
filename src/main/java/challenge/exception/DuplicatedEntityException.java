package challenge.exception;

public class DuplicatedEntityException
    extends RuntimeException {
    
    public DuplicatedEntityException() {
    }
    
    public DuplicatedEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public DuplicatedEntityException(Throwable cause) {
        super(cause);
    }
}

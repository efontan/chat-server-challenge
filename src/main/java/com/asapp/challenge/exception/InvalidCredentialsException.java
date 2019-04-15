package com.asapp.challenge.exception;

public class InvalidCredentialsException
    extends RuntimeException {
    
    public InvalidCredentialsException() {
    }
    
    public InvalidCredentialsException(String message) {
        super(message);
    }
    
    public InvalidCredentialsException(Throwable cause) {
        super(cause);
    }
    
    public InvalidCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }
}

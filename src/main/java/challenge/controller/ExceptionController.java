package challenge.controller;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import challenge.dto.ApiError;
import challenge.exception.DuplicatedEntityException;
import challenge.exception.InvalidCredentialsException;

@RestControllerAdvice
public class ExceptionController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);
    
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ApiError handleException(Exception e) {
        LOGGER.error("Internal server error {} {}", e.getMessage(), e);
        return new ApiError(INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    @ResponseStatus(CONFLICT)
    @ExceptionHandler(DuplicatedEntityException.class)
    public ApiError handleDuplicatedEntityException(Exception e) {
        LOGGER.error("Error saving or updating to database {} {}", e.getMessage(), e);
        return new ApiError(CONFLICT.value(), e.getMessage());
    }

    @ResponseStatus(UNAUTHORIZED)
    @ExceptionHandler(InvalidCredentialsException.class)
    public ApiError handleAuthenticationException(Exception e) {
        LOGGER.warn("Authentication error {} {}", e.getMessage(), e);
        return new ApiError(UNAUTHORIZED.value(), e.getMessage());
    }
    
}

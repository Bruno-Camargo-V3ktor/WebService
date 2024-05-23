package dev.v3ktor.webservice.rest.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ControllerExceptionHandler {

    //MÉTODOS
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFoundExceptionHandle(EntityNotFoundException ex, HttpServletRequest request)
    {
        String errorMsg = "Entity not found";
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError error = new StandardError(Instant.now(), status.value(), errorMsg, ex.getMessage(), request.getRequestURI() );
        return ResponseEntity.status(status).body( error );
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> databaseExceptionExceptionHandle(DatabaseException ex, HttpServletRequest request)
    {
        String errorMsg = "Database Error";
        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandardError error = new StandardError(Instant.now(), status.value(), errorMsg, ex.getMessage(), request.getRequestURI() );
        return ResponseEntity.status(status).body( error );
    }

}

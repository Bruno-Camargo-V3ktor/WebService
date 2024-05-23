package dev.v3ktor.webservice.rest.exception;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String message) { super(message); }
}

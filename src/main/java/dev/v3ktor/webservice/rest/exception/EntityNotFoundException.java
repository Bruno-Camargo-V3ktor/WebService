package dev.v3ktor.webservice.rest.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Object id) {
        super("Entity not found. Id + '" + id + "'");
    }
}

package com.football.teams.exception;

/**
 * Se lanza cuando un recurso no existe.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

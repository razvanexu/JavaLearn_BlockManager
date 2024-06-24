package org.example.infrastructure.exceptions;

public class InvalidUtilityException extends RuntimeException {
    public InvalidUtilityException(String message) {
        super(message);
    }
}

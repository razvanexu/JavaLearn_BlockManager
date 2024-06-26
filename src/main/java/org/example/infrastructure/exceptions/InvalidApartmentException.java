package org.example.infrastructure.exceptions;

public class InvalidApartmentException extends RuntimeException {
    public InvalidApartmentException(String message) {
        super(message);
    }
}

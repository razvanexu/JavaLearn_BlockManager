package org.example.infrastructure.exceptions;

public class InvalidCostException extends RuntimeException{

    public InvalidCostException(String message) {
        super(message);
    }
}

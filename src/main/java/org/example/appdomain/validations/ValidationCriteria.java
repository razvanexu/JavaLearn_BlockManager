package org.example.appdomain.validations;

interface ValidationCriteria<T> {
    boolean isValid(T value);
}

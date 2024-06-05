package org.example.appdomain.validations;

interface Validator<T> {
    default T validate(T value, ValidationCriteria<T> criteria) {
        if (criteria.isValid(value)) {
            return value;
        }
        throw new IllegalArgumentException("Invalid Argument");
    }
}

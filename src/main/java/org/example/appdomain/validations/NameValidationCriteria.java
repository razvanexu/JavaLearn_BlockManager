package org.example.appdomain.validations;

public class NameValidationCriteria implements ValidationCriteria<String> {
    @Override
    public boolean isValid(String name) {
        return name != null && !name.isBlank();
    }
}

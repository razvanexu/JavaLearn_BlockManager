package org.example.appdomain.validations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.appdomain.testUtils.TestDataProvider.NULL_NAME;
import static org.example.appdomain.testUtils.TestDataProvider.VALID_NAME;

class NameValidatorTest {

    private NameValidator underTest = new NameValidator();

    @Test
    void validate_ShouldReturnValue() {
        //Given
        String nullName = NULL_NAME;
        String validName = VALID_NAME;
        ValidationCriteria<String> criteria = new NameValidationCriteria();

        //When
        var result = underTest.validate(validName, criteria);

        //Then
        Assertions.assertEquals(validName, result);
    }
}
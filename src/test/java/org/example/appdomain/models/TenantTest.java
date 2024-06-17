package org.example.appdomain.models;

import org.junit.jupiter.api.Test;

import static org.example.appdomain.testUtils.TestDataProvider.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TenantTest {

    @Test
    void setName_ShouldThrowIllegalArgumentExceptionWhenNullOrEmpty() {

        //Given
        String nullName = NULL_NAME;
        String emptyName = EMPTY_NAME;
        String whiteSpace = WHITE_SPACE;
        int validAptNr = 3;

        //When
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> new Tenant(nullName, validAptNr)),
                () -> assertThrows(IllegalArgumentException.class, () -> new Tenant(emptyName, validAptNr)),
                () -> assertThrows(IllegalArgumentException.class, () -> new Tenant(whiteSpace, validAptNr))
        );


        //Then
    }

    @Test
    void setAptNr() {
    }
}
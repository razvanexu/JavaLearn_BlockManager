package org.example.appdomain.models;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.example.appdomain.testUtils.TestDataProvider.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AptOwnerTest {

    @Test
    void setName_ShouldThrowIllegalArgumentExceptionWhenNullOrEmpty() {

        //Given
        String nullName = NULL_NAME;
        String emptyName = EMPTY_NAME;
        String whiteSpace = WHITE_SPACE;
        List<Apartment> apt = null;

        //When

        //Then
        assertAll(
            () -> assertThrows(IllegalArgumentException.class, () -> new AptOwner(nullName, apt)),
            () -> assertThrows(IllegalArgumentException.class, () -> new AptOwner(emptyName, apt)),
            () -> assertThrows(IllegalArgumentException.class, () -> new AptOwner(whiteSpace, apt))
        );
    }
}
package org.example.appdomain.services;

import org.example.appdomain.models.Apartment;
import org.example.appdomain.models.AptOwner;
import org.example.appdomain.models.Utiliies;
import org.example.appdomain.models.UtilityModel;
import org.example.infrastructure.exceptions.InvalidCostException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BransamentServiceTest {
    private final static UtilityModel UTILITY_MODEL = new UtilityModel(Utiliies.GAZ, 10, 0, 0);
    private final static UtilityModel INVALID_UTILITY_MODEL = new UtilityModel(Utiliies.GAZ, 0.0, 0, 0);
    private final static Apartment APARTMENT = new Apartment(1,
        0.0,
        0.0,
        2,
        List.of(new AptOwner("Ciolacu")),
        new HashSet<>());

    private BransamentService underTest;

    @BeforeEach
    public void setup() {
        underTest = new BransamentService();
    }

    @Test
    void bransareApt_ShouldThrowInvalidCostException() {
        //Given

        //When

        //Then
        assertThrows(InvalidCostException.class, () -> underTest.bransareApt(APARTMENT, INVALID_UTILITY_MODEL));
    }

    @Test
    void bransareApt_ShouldReturnTrueWhenValid() {
        //Given

        //When
        var result = underTest.bransareApt(APARTMENT, UTILITY_MODEL);

        //Then
        assertTrue(result);
    }

}

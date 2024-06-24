package org.example.appdomain.services;

import org.example.appdomain.models.Apartment;
import org.example.appdomain.models.AptOwner;
import org.example.appdomain.models.Utilities;
import org.example.appdomain.models.UtilityModel;
import org.example.appdomain.repository.AptDao;
import org.example.infrastructure.exceptions.InvalidCostException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BransamentServiceTest {
    private static Apartment APARTMENT;
    private static UtilityModel UTILITY_MODEL;
    private static UtilityModel INVALID_UTILITY_MODEL;
    private BransamentService underTest;

    @BeforeEach
    public void setup() {
        UTILITY_MODEL = new UtilityModel(Utilities.GAZ, 10, 0, 0);
        INVALID_UTILITY_MODEL = new UtilityModel(Utilities.GAZ, 0.0, 0, 0);
        APARTMENT = new Apartment(1,
            0.0,
            0.0,
            2,
            List.of(new AptOwner("Ciolacu")),
            new HashSet<>());
        AptDao aptDao = mock(AptDao.class);
        underTest = new BransamentService(aptDao);

        when(aptDao.findByNr(anyInt())).thenReturn(Optional.of(APARTMENT));
    }

    @Test
    void bransareApt_ShouldThrowInvalidCostException() {
        //Given

        //When

        //Then
        assertThrows(InvalidCostException.class, () -> underTest.bransareApt(3, INVALID_UTILITY_MODEL));
    }

    @Test
    void bransareApt_ShouldReturnTrueWhenValid() {
        //Given

        //When
        var result = underTest.bransareApt(3, UTILITY_MODEL);

        //Then
        assertTrue(result);
    }

    @Test
    void debransareApt_ShouldReturnTrueWhenValid() {
        //Given
        underTest.bransareApt(3, UTILITY_MODEL);

        //When
        var result = underTest.debransare(3, Utilities.GAZ);

        //Then
        assertTrue(result);
    }

}

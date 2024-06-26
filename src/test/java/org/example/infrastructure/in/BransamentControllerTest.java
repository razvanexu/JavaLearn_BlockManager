package org.example.infrastructure.in;

import org.example.appdomain.models.Apartment;
import org.example.appdomain.models.Utilities;
import org.example.appdomain.repository.AptDao;
import org.example.appdomain.services.BransamentService;
import org.example.infrastructure.exceptions.InvalidUtilityException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BransamentControllerTest {
    BransamentService bransamentService;
    Apartment apartment;
    private BransamentController underTest;

    @BeforeEach
    void setup() {
        apartment = new Apartment(1, 2, "Ciolacu");
        AptDao aptDao = mock(AptDao.class);
        bransamentService = new BransamentService(aptDao);
        underTest = new BransamentController(bransamentService);

        when(aptDao.findByNr(anyInt())).thenReturn(Optional.of(apartment));
    }

    @Test
    void bransareApt_ShouldReturnTrueWhenValid() {
        //Given


        //When
        var result_1 = underTest.bransareApt(1, Utilities.GAZ);
        var result_2 = underTest.bransareApt(1, Utilities.APA_RECE);
        var result_3 = underTest.bransareApt(1, Utilities.APA_CALDA);

        //Then
        assertTrue(result_1);
        assertTrue(result_2);
        assertTrue(result_3);
    }

    @Test
    void bransareApt_ShouldThrowInvalidUtilityExceptionWhenUtilityExists() {
        //Given

        //When
        underTest.bransareApt(1, Utilities.GAZ);

        //Then
        assertThrows(InvalidUtilityException.class, () -> underTest.bransareApt(1, Utilities.GAZ));
    }

    @Test
    void debransareApt_ShouldReturnTrueWhenValid() {
        //Given
        underTest.bransareApt(1, Utilities.GAZ);

        //When
        var result = underTest.debransareApt(3, Utilities.GAZ);

        //Then
        assertTrue(result);
    }

    @Test
    void debransareApt_ShouldReturnFalseWhenNotFound() {
        //Given
        underTest.bransareApt(1, Utilities.GAZ);

        //When
        var result = underTest.debransareApt(3, Utilities.APA_RECE);

        //Then
        assertFalse(result);
    }
}
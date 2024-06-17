package org.example.appdomain.services;

import org.example.appdomain.models.Apartment;
import org.example.appdomain.models.UtilityModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MonthlyCostCalculatorTest {
    private final UtilityModel utilityModel = mock(UtilityModel.class);
    private final Apartment apartment = mock(Apartment.class);
    private final UtilityCostCalculatorService utilityCostCalculatorService = mock(UtilityCostCalculatorService.class);

    private MonthlyCostCalculator underTest;

    @BeforeEach
    public void setup() {
        underTest = new MonthlyCostCalculator(utilityCostCalculatorService);
    }

    @Test
    void calculatMonthlyTotalToPay_ShouldReturnCotaDeIntretinere() {
        //Given

        when(apartment.getUtilitiesInUse()).thenReturn(Set.of(utilityModel));
        when(utilityCostCalculatorService.calculateCostPerUtility(eq(apartment), any()))
            .thenReturn(10.0);

        //When
        var result = underTest.calculatMonthlyTotalToPay(apartment);

        //Then
        assertEquals(10.0, result);
    }
}
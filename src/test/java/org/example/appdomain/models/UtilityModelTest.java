package org.example.appdomain.models;

import org.example.appdomain.services.UtilityCostProviderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UtilityModelTest {


    @Test
    void getUtilityName_ShouldReturnUtilityNameSetInConstructor() {

        //Given
        UtilityModel underTest = new UtilityModel(Utilities.APA_RECE, 20, 0, 35);

        //When
        var utilityName = underTest.getUtilityName();

        //Then
        Assertions.assertEquals(Utilities.APA_RECE, utilityName);
    }

    @Test
    void setUtilityName_ShouldChangeUtilityName() {

        //Given
        UtilityModel underTest = new UtilityModel(Utilities.APA_RECE, 20, 0, 35);

        //When
        var oldUtilityName = underTest.getUtilityName();
        underTest.setUtilityName(Utilities.GAZ);
        var newUtilityName = underTest.getUtilityName();

        //Then
        Assertions.assertEquals(Utilities.APA_RECE, oldUtilityName);
        Assertions.assertEquals(Utilities.GAZ, newUtilityName);
    }

    @Test
    void getCostPerUnit_ShouldReturnCostProvidedInConstructorBasedOnUtilityName() {

        UtilityModel underTest = new UtilityModel(Utilities.APA_RECE, 10, 0, 35);

        //When
        var utilityCost = underTest.getCostPerUnit();
        double providedCost = UtilityCostProviderService.COST_APA_RECE;

        //Then
        Assertions.assertEquals(providedCost, utilityCost);
    }

    @Test
    void getCumulativeIndexConsumed_ShouldReturnCumulativeConsumption() {

        UtilityModel underTest = new UtilityModel(Utilities.APA_RECE, 20, 0, 35);

        //When
        var currentIndex = underTest.getCumulativeIndexConsumed();

        //Then
        Assertions.assertEquals(0, currentIndex);
    }

    @Test
    void setCumulativeIndexConsumed_ShouldReturnUpdatedCumulativeIndexOnGetter() {

        UtilityModel underTest = new UtilityModel(Utilities.APA_RECE, 20, 0, 35);

        //When
        underTest.setCumulativeIndexConsumed(underTest.getIndexCurrentMonth());
        var updatedCumulativeIndex = underTest.getCumulativeIndexConsumed();

        //Then
        Assertions.assertEquals(35, updatedCumulativeIndex);
    }

}

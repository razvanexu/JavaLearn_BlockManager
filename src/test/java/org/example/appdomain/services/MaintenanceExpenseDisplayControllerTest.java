package org.example.appdomain.services;

import org.example.appdomain.models.Apartment;
import org.example.appdomain.models.Utilities;
import org.example.appdomain.models.UtilityModel;
import org.example.infrastructure.out.MaintenanceExpenseDisplayController;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class MaintenanceExpenseDisplayControllerTest {
    private MaintenanceExpenseDisplayController underTest;

    @Test
    void displayExpensesList_ShouldReturnAConcatenatedString() {
        //Given
        var apt1 = new Apartment(1, 2, "Ciolacu");
        var apt2 = new Apartment(2, 1, "Ciuhapu");
        var apt3 = new Apartment(3, 4, "Ciorapu");

        apt1.getUtilitiesInUse()
            .addAll(Set.of(new UtilityModel(Utilities.APA_CALDA, 2.3, 0, 12),
                new UtilityModel(Utilities.APA_RECE, 1.2, 0, 19)));

        apt2.getUtilitiesInUse()
            .addAll(Set.of(new UtilityModel(Utilities.GAZ, 4.3, 0, 12),
                new UtilityModel(Utilities.CALDURA, 1.2, 0, 19)));

        apt3.getUtilitiesInUse()
            .addAll(Set.of(new UtilityModel(Utilities.CALDURA, 2.3, 0, 12),
                new UtilityModel(Utilities.APA_RECE, 1.2, 0, 19)));

        intretinereCalculator(apt1);
        intretinereCalculator(apt2);
        intretinereCalculator(apt3);

        underTest = new MaintenanceExpenseDisplayController();

        //When
        underTest.displayExpensesList(List.of(apt1, apt2, apt3));

        //Then
        //Assertions.assertEquals("a lot of shit", result);
    }

    private void intretinereCalculator(Apartment apt) {
        Double result = apt.getUtilitiesInUse()
            .stream()
            .map(UtilityModel::getCostPerUnit)
            .reduce(0.0, Double::sum);

        apt.setCurrentMonthDebt(result);
    }
}
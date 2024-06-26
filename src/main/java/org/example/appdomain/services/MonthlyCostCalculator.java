package org.example.appdomain.services;

import org.example.appdomain.models.Apartment;

public class MonthlyCostCalculator {

    private final UtilityCostCalculatorService utilityCostCalculatorService;

    public MonthlyCostCalculator(UtilityCostCalculatorService utilityCostCalculatorService) {
        this.utilityCostCalculatorService = utilityCostCalculatorService;
    }

    public double calculatMonthlyTotalToPay(Apartment apt) {
        return apt.getUtilitiesInUse()
            .stream()
            .map(utilityCostCalculatorService::calculateCostPerUtility)
            .reduce(0.0, Double::sum);
    }
}

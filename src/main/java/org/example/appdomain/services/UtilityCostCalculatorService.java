package org.example.appdomain.services;

import org.example.appdomain.models.UtilityModel;

public class UtilityCostCalculatorService {

    public double calculateCostPerUtility(UtilityModel utility) {

        return Math.abs(utility.getCumulativeIndexConsumed() - utility.getIndexCurrentMonth()) * utility.getCostPerUnit();
    }
}

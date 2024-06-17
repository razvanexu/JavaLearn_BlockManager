package org.example.appdomain.services;

import org.example.appdomain.models.*;
import org.example.infrastructure.exceptions.*;

public class UtilityCostCalculatorService {

    public double calculateCostPerUtility(Apartment apt, UtilityModel utility){

        if (!apt.getUtilitiesInUse().contains(utility)){
            throw new NullUtilityException("apartament debransat");
        }

        return (utility.getCumulativeIndexConsumed() - utility.getIndexCurrentMonth()) * utility.getCostPerUnit();
    }
}

package org.example.appdomain.services;

import org.example.appdomain.models.Apartment;
import org.example.appdomain.models.Utiliies;
import org.example.appdomain.models.UtilityModel;
import org.example.infrastructure.exceptions.InvalidCostException;

public class BransamentService {

    public boolean bransareApt(Apartment apt, UtilityModel utility) {
        if (utility.getCostPerUnit() <= 0) {
            throw new InvalidCostException("invalid cost value");
        }

        return apt.getUtilitiesInUse()
            .add(utility);
    }

    public boolean debransare(Apartment apt, Utiliies utility) {
        return apt.getUtilitiesInUse().removeIf(x -> x.getUtilityName().equals(utility));
    }
}

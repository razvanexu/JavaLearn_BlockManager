package org.example.appdomain.services;

import org.example.appdomain.models.*;
import org.example.infrastructure.exceptions.*;

public class BransamentService {

    public boolean bransareApt(Apartment apt, UtilityModel utility) {
        if (utility.getCostPerUnit() <= 0) {
            throw new InvalidCostException("invalid cost value");
        }

        return apt.getUtilitiesInUse().add(utility);
    }

    public boolean debransare(Apartment apt, Utiliies utility) {
        return apt.getUtilitiesInUse().removeIf(x -> x.getUtilityName().equals(utility));
    }
}

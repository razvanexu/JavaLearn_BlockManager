package org.example.infrastructure.in;

import org.example.appdomain.models.*;
import org.example.appdomain.repository.*;
import org.example.appdomain.services.*;

public class BransamentController {

    private final BransamentService bransamentService;
    private final AptDao aptDao;
    private final UtilityCostProviderService costProvider;

    public BransamentController(BransamentService bransamentService, AptDao aptDao, UtilityCostProviderService costProvider) {
        this.bransamentService = bransamentService;
        this.aptDao = aptDao;
        this.costProvider = costProvider;
    }

    public boolean bransareApt(int aptNr, Utiliies utility){

        var apt = getApartment(aptNr);
        if (apt == null) return false;

        UtilityModel utilityModel = getUtilityModel(utility);
        return bransamentService.bransareApt(apt, utilityModel);
    }

    private UtilityModel getUtilityModel(Utiliies utility) {
        double utilityPrice = costProvider.providePrice(utility);
        return new UtilityModel(utility, utilityPrice, 0, 0);
    }

    private Apartment getApartment(int aptNr) {
        var optionalApt = aptDao.findByNr(aptNr);

        if (optionalApt.isEmpty()){
            return null;
        }

        return optionalApt.get();
    }

}

package org.example.infrastructure.in;

import org.example.appdomain.models.Utiliies;
import org.example.appdomain.models.UtilityModel;
import org.example.appdomain.services.BransamentService;
import org.example.appdomain.services.UtilityCostProviderService;

public class BransamentController {

    private final BransamentService bransamentService;
    private final UtilityCostProviderService costProvider;

    public BransamentController(BransamentService bransamentService, UtilityCostProviderService costProvider) {
        this.bransamentService = bransamentService;
        this.costProvider = costProvider;
    }

    public boolean bransareApt(int aptNr, Utiliies utility) {
        UtilityModel utilityModel = getUtilityModel(utility);
        return bransamentService.bransareApt(aptNr, utilityModel);
    }

    //todo metoda Debransare

    private UtilityModel getUtilityModel(Utiliies utility) {
        double utilityPrice = costProvider.providePrice(utility);
        return new UtilityModel(utility, utilityPrice, 0, 0);
    }
}

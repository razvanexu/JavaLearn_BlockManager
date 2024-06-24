package org.example.infrastructure.in;

import org.example.appdomain.models.Utilities;
import org.example.appdomain.models.UtilityModel;
import org.example.appdomain.services.BransamentService;
import org.example.appdomain.services.UtilityCostProviderService;

public class BransamentController implements UtilityCostProviderService {

    private final BransamentService bransamentService;

    public BransamentController(BransamentService bransamentService) {
        this.bransamentService = bransamentService;
    }

    public boolean bransareApt(int aptNr, Utilities utility) {
        UtilityModel utilityModel = getUtilityModel(utility);
        return bransamentService.bransareApt(aptNr, utilityModel);
    }

    private UtilityModel getUtilityModel(Utilities utility) {
        double utilityPrice = providePrice(utility);
        return new UtilityModel(utility, utilityPrice, 0, 0);
    }

    public boolean debransareApt(int aptNr, Utilities utility) {
        UtilityModel utilityModel = getUtilityModel(utility);
        return bransamentService.debransare(aptNr, utilityModel.getUtilityName());
    }
}

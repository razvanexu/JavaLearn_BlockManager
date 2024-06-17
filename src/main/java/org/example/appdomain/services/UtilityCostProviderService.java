package org.example.appdomain.services;

import org.example.appdomain.models.*;

public interface UtilityCostProviderService {

    double COST_APA_RECE = 10;
    double COST_APA_CALDA = 15;
    double COST_GAZ = 24;
    double COST_INCALZIRE = 12.5;

    default double providePrice(Utiliies utility){
        return switch (utility) {
            case APA_RECE -> COST_APA_RECE;
            case APA_CALDA -> COST_APA_CALDA;
            case GAZ -> COST_GAZ;
            case CALDURA -> COST_INCALZIRE;
        };
    }
}

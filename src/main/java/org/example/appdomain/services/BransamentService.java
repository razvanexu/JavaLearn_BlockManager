package org.example.appdomain.services;

import org.example.appdomain.models.Apartment;
import org.example.appdomain.models.Utiliies;
import org.example.appdomain.models.UtilityModel;
import org.example.appdomain.repository.AptDao;
import org.example.infrastructure.exceptions.InvalidCostException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BransamentService {

    private final Logger logger = Logger.getLogger(BransamentService.class.getName());
    private final AptDao aptDao;

    public BransamentService(AptDao aptDao) {
        this.aptDao = aptDao;
    }

    public boolean bransareApt(int aptNr, UtilityModel utility) {
        var apt = getApartment(aptNr);
        if (apt == null) {
            logger.log(Level.SEVERE, () -> "Apartamentul cu nr. " + aptNr + " nu exista");
            return false;
        }

        if (utility.getCostPerUnit() <= 0) {
            logger.log(Level.SEVERE, () -> "Utility " + utility.getUtilityName() + " has cost of "
                + utility.getCostPerUnit() +
                ", throwing InvalidCostException");
            throw new InvalidCostException("invalid cost value");
        }

        logger.log(Level.INFO, () -> "Successfully added utility " + utility.getUtilityName() +
            " to apartment " + apt.getAptNr());

        return apt.getUtilitiesInUse()
            .add(utility);
    }

    private Apartment getApartment(int aptNr) {
        var optionalApt = aptDao.findByNr(aptNr);

        if (optionalApt.isEmpty()) {
            return null;
        }

        return optionalApt.get();
    }

    public boolean debransare(int aptNr, Utiliies utility) {
        var apt = getApartment(aptNr);
        if (apt == null) {
            logger.log(Level.SEVERE, () -> "Apartamentul cu nr. " + aptNr + " nu exista");
            return false;
        }

        var result = apt.getUtilitiesInUse()
            .removeIf(x -> x
                .getUtilityName()
                .equals(utility));

        if (result) {
            logger.log(Level.INFO, () -> "Apartamentul " + apt.getAptNr() + " a fost debransat de la utilitatea "
                + utility.name());
        } else {
            logger.log(Level.INFO, () -> "Apartamentul " + apt.getAptNr() + " nu a fost bransat la utilitatea "
                + utility.name());

        }
        return result;
    }
}

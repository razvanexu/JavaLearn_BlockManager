package org.example.appdomain.models;

import java.util.List;
import java.util.Set;

public class Apartment {
    private int aptNr;
    private double currentMonthDebt;
    private double totalDebt;
    private int tenantNr;
    private List<AptOwner> owners;
    private Set<UtilityModel> utilitiesInUse;

    public Apartment(int aptNr, double currentMonthDebt, double totalDebt, int tenantNr, List<AptOwner> owners,
                     Set<UtilityModel> utilitiesInUse) {
        this.aptNr = aptNr;
        this.currentMonthDebt = currentMonthDebt;
        this.totalDebt = totalDebt;
        this.tenantNr = tenantNr;
        this.owners = owners;
        this.utilitiesInUse = utilitiesInUse;
    }

    public int getAptNr() {
        return aptNr;
    }

    public void setAptNr(int aptNr) {
        this.aptNr = aptNr;
    }

    public double getCurrentMonthDebt() {
        return currentMonthDebt;
    }

    public void setCurrentMonthDebt(double currentMonthDebt) {
        this.currentMonthDebt = currentMonthDebt;
    }

    public double getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(double totalDebt) {
        this.totalDebt = totalDebt;
    }

    public int getTenantNr() {
        return tenantNr;
    }

    public void setTenantNr(int tenantNr) {
        this.tenantNr = tenantNr;
    }

    public List<AptOwner> getOwners() {
        return owners;
    }

    public void setOwners(List<AptOwner> owners) {
        this.owners = owners;
    }

    public Set<UtilityModel> getUtilitiesInUse() {
        return utilitiesInUse;
    }

    public boolean addUtilitiesInUse(UtilityModel utilityToAdd) {
        return utilitiesInUse.add(utilityToAdd);
    }
}

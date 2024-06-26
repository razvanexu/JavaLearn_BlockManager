package org.example.appdomain.models;

import java.util.HashSet;
import java.util.Set;

public class Apartment {
    private int aptNr;
    private double currentMonthDebt;
    private double totalDebt;
    private int tenantNr;
    private String owner;
    private Set<UtilityModel> utilitiesInUse = new HashSet<>();
    public Apartment(int aptNr, int tenantNr, String owner) {
        this.aptNr = aptNr;
        this.tenantNr = tenantNr;
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getAptNr() {
        return aptNr;
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

    public Set<UtilityModel> getUtilitiesInUse() {
        return utilitiesInUse;
    }

    public boolean addUtilitiesInUse(UtilityModel utilityToAdd) {
        return utilitiesInUse.add(utilityToAdd);
    }

    @Override
    public String toString() {
        return "Apartment{" +
            "aptNr=" + aptNr +
            ", currentMonthDebt=" + currentMonthDebt +
            ", totalDebt=" + totalDebt +
            ", tenantNr=" + tenantNr +
            ", owner='" + owner + '\'' +
            ", utilitiesInUse=" + utilitiesInUse +
            '}';
    }
}

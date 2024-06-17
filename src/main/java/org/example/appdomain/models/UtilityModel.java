package org.example.appdomain.models;

import org.example.appdomain.services.*;

public class UtilityModel implements UtilityCostProviderService {
    private Utiliies utilityName;
    private double costPerUnit;
    private int cumulativeIndexConsumed;
    private int indexCurrentMonth;

    public UtilityModel(Utiliies utilityName, double costPerUnit, int cumulativeIndexConsumed, int indexCurrentMonth) {
        this.utilityName = utilityName;
        this.costPerUnit = costPerUnit;
        this.cumulativeIndexConsumed = cumulativeIndexConsumed;
        this.indexCurrentMonth = indexCurrentMonth;
    }

    public Utiliies getUtilityName() {
        return utilityName;
    }

    public void setUtilityName(Utiliies utilityName) {
        this.utilityName = utilityName;
    }

    public double getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(double costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public int getCumulativeIndexConsumed() {
        return cumulativeIndexConsumed;
    }

    public void setCumulativeIndexConsumed(int cumulativeIndexConsumed) {
        this.cumulativeIndexConsumed += getIndexCurrentMonth();
    }

    public int getIndexCurrentMonth() {
        return indexCurrentMonth;
    }

    public void setIndexCurrentMonth(int indexCurrentMonth) {
        this.indexCurrentMonth = indexCurrentMonth;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UtilityModel utility)) return false;

        return utilityName == utility.utilityName;
    }

    @Override
    public int hashCode() {
        return utilityName.hashCode();
    }
}

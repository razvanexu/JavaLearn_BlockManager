package org.example.appdomain.models;

public class UtilityModel {
    private Utilities utilityName;
    private double costPerUnit;
    private int cumulativeIndexConsumed;
    private int indexCurrentMonth;

    public UtilityModel(Utilities utilityName, double costPerUnit, int cumulativeIndexConsumed, int indexCurrentMonth) {
        this.utilityName = utilityName;
        this.costPerUnit = costPerUnit;
        this.cumulativeIndexConsumed = cumulativeIndexConsumed;
        this.indexCurrentMonth = indexCurrentMonth;
    }

    public Utilities getUtilityName() {
        return utilityName;
    }

    public void setUtilityName(Utilities utilityName) {
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
    public int hashCode() {
        return utilityName.hashCode();
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UtilityModel utility)) return false;

        return utilityName == utility.utilityName;
    }

    @Override
    public String toString() {
        return "UtilityModel{" +
            "cumulativeIndexConsumed=" + cumulativeIndexConsumed +
            ", indexCurrentMonth=" + indexCurrentMonth +
            ", utilityName=" + utilityName +
            ", costPerUnit=" + costPerUnit +
            '}';
    }
}

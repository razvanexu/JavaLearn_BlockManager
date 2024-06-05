package org.example.appdomain.models;

public class Tenant extends BasePerson {
    private int aptNr;

    public Tenant(String name, int aptNr) {
        super(name);
        this.aptNr = validateAptNr(aptNr);
    }

    private static int validateAptNr(int aptNr) {
        if (aptNr <= 0 || aptNr > 32) {
            throw new IllegalArgumentException("Invalid Apt. Number");
        }
        return aptNr;
    }

    public int getAptNr() {
        return aptNr;
    }

    public void setAptNr(int aptNr) {
        this.aptNr = validateAptNr(aptNr);
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "aptNr=" + aptNr +
                ", name='" + name + '\'' +
                '}';
    }
}

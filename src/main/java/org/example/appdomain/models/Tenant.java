package org.example.appdomain.models;

public class Tenant extends BasePerson {
    private int aptNr;

    public Tenant(String name, int aptNr) {
        super(name);
        this.aptNr = aptNr;
    }

    public int getAptNr() {
        return aptNr;
    }

    public void setAptNr(int aptNr) {
        this.aptNr = aptNr;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "aptNr=" + aptNr +
                ", name='" + name + '\'' +
                '}';
    }
}

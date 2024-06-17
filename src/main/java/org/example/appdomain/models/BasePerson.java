package org.example.appdomain.models;

public abstract class BasePerson {

    protected String name;

    public BasePerson(String name) {
        checkName(name);
        this.name = name;
    }

    private static void checkName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Numele nu poate fi gol sau null");
        }
    }

    protected BasePerson() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        checkName(name);
        this.name = name;
    }
}

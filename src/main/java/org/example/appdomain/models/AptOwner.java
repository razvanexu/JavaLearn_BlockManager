package org.example.appdomain.models;

import java.util.*;

public class AptOwner extends BasePerson {

    private List<Apartment> ownedApartments;

    public AptOwner(String name, List<Apartment> ownedapartments) {
        super(name);
        this.ownedApartments = ownedapartments;
    }

    public List<Apartment> getOwnedApartments() {
        return ownedApartments;
    }

    public void setOwnedApartments(List<Apartment> ownedApartments) {
        this.ownedApartments = ownedApartments;
    }
}

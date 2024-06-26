package org.example.infrastructure.out;

import org.example.appdomain.models.Apartment;

import java.util.List;

public class MaintenanceExpenseDisplayController {

    public void displayExpensesList(List<Apartment> aptList) {
        for (var apt : aptList) {
            System.out.println(apt);
        }
    }
}

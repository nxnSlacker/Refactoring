package com.nxn.slacker.refatoring.example;

import java.util.List;
import java.util.Vector;

/**
 * Created by Slacker on 11-10-2014.
 */
class Customer {
    private String name;
    private List<Rent> rents = new Vector<Rent>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }

    public String statement(){
        String result = "Rental Record for: " + getName() + "\n";

        for (Rent rent : rents) {
            result += "\t" + rent.getMovie().getTitle() + "\t" + String.valueOf(rent.getCharge()) + "\n";
        }

        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints()) + " frequent renter points";

        return result;
    }

    private int frequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rent rent : rents) {
            frequentRenterPoints = rent.getFrequentRenterPoints();
        }

        return frequentRenterPoints;
    }

    public double getTotalCharge(){
        double totalAmount = 0;
        for (Rent rent : rents) {
            totalAmount += rent.getCharge();
        }

        return totalAmount;
    }

}
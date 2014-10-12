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
        StringBuilder result = new StringBuilder();
        result.append("Rental Record for: " + getName() + "\n");

        for (Rent rent : rents) {
            result.append("\t" + rent.getMovie().getTitle() + "\t" + String.valueOf(rent.getCharge()) + "\n");
        }

        result.append("Amount owed is " + String.valueOf(getTotalCharge()) + "\n");
        result.append("You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points");

        return result.toString();
    }

    public String htmlSttement(){
        StringBuilder result = new StringBuilder();

        result.append("<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n");
        for (Rent rent : rents) {
            result.append(rent.getMovie().getTitle() + ": " + String.valueOf(rent.getCharge()) + "<BR>\n");
        }

        result.append("<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n");
        result.append("On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM> frequent renter points<P>");

        return result.toString();
    }

    private int getTotalFrequentRenterPoints() {
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
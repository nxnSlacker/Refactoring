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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (rents != null ? !rents.equals(customer.rents) : customer.rents != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (rents != null ? rents.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Customer{");
        sb.append("name='").append(name).append('\'');
        sb.append(", rents=").append(rents);
        sb.append('}');
        return sb.toString();
    }

    public String statement(){
        String result = "Rental Record for: " + getName() + "\n";

        for (Rent rent : rents) {
            result += "\t" + rent.getMovie().getTitle() + "\t" + String.valueOf(rent.getCharge()) + "\n";
        }

        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";

        return result;
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
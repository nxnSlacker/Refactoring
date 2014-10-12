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
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "Rental Record for: " + getName() + "\n";

        for (Rent rent : rents) {
            double thisAmount = rent.getCharge();

            // Add frequent renter points
            frequentRenterPoints ++;
            // Add bonus for a two day new release rental
            if ( (rent.getMovie().getPriceCode() == Movie.NEW_RELEASE) && (rent.getDaysRented() > 1) ){
                frequentRenterPoints ++;
            }

            // Show figures for this rental
            result += "\t" + rent.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";

            totalAmount += thisAmount;
        }

        // Add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

        return result;
    }

}
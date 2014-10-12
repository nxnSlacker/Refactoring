package com.nxn.slacker.refatoring.example;

/**
 * Created by Slacker on 12-10-2014.
 */
public abstract class Price {
    public abstract int getPriceCode();

    public abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented){
        return 1;
    }
}

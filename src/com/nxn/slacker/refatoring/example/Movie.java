package com.nxn.slacker.refatoring.example;

/**
 * Created by Slacker on 11-10-2014.
 */
public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private Price price;
    private String title;
    private int priceCode;

    public Movie(String name, int priceCode) {
        this.title = name;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode){
            case REGULAR :
                price = new RegularPrice();
                break;
            case NEW_RELEASE :
                price = new NewReleasePrice();
                break;
            case CHILDRENS :
                price = new ChildrensPrice();
                break;
            default :
                throw new IllegalArgumentException("Incorrect price code");
        }
    }

    public double getCharge(int daysRented){
        return price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented){
        return price.getFrequentRenterPoints(daysRented);
    }
}
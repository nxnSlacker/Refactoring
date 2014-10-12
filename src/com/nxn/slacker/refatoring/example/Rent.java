package com.nxn.slacker.refatoring.example;

/**
 * Created by Slacker on 11-10-2014.
 */
public class Rent {

    private Movie movie;
    private int daysRented;

    public Rent(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public void setDaysRented(int daysRented) {
        this.daysRented = daysRented;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Rent{");
        sb.append("movie=").append(movie);
        sb.append(", daysRented=").append(daysRented);
        sb.append('}');
        return sb.toString();
    }

    double getCharge() {
        double result = 0;

        switch (getMovie().getPriceCode()){
            case Movie.REGULAR :
                result += 2;
                if(getDaysRented() > 2){
                    result += (getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE :
                result += getDaysRented() * 3;
                break;
            case Movie.CHILDRENS :
                result += 1.5;
                if(getDaysRented() > 3){
                    result += (getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return result;
    }

    int getFrequentRenterPoints() {
        if( (getMovie().getPriceCode() == Movie.NEW_RELEASE) && (getDaysRented() > 1) ){
            return 2;
        } else {
            return 1;
        }
    }
}

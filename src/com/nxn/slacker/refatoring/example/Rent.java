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
}

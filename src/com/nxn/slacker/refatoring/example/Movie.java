package com.nxn.slacker.refatoring.example;

/**
 * Created by Slacker on 11-10-2014.
 */
public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Movie{");
        sb.append("title='").append(title).append('\'');
        sb.append(", priceCode=").append(priceCode);
        sb.append('}');
        return sb.toString();
    }
}

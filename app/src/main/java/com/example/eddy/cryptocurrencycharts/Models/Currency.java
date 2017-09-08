package com.example.eddy.cryptocurrencycharts.Models;

import android.graphics.drawable.Drawable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eddy on 06.09.17.
 */

public class Currency {

    @SerializedName("name")
    private String fullname;
    @SerializedName("symbol")
    private String shortName;
    @SerializedName("price_usd")
    private double priceUSD;
    private int image;

    public double getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(double priceUSD) {
        this.priceUSD = priceUSD;
    }

    public Currency(String fullname, String shortName, int image, double priceUSD) {
        this.fullname = fullname;
        this.shortName = shortName;
        this.image = image;
        this.priceUSD = priceUSD;

    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

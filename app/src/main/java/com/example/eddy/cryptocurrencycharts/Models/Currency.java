package com.example.eddy.cryptocurrencycharts.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eddy on 06.09.17.
 */

public class Currency implements Parcelable {

    @SerializedName("name")
    private String fullName;
    @SerializedName("symbol")
    private String shortName;
    @SerializedName("price_usd")
    private double priceUSD;
    private int    image;

    protected Currency(Parcel in) {
        fullName = in.readString();
        shortName = in.readString();
        priceUSD = in.readDouble();
        image = in.readInt();
    }

    public static final Creator<Currency> CREATOR = new Creator<Currency>() {
        @Override
        public Currency createFromParcel(Parcel in) {
            return new Currency(in);
        }

        @Override
        public Currency[] newArray(int size) {
            return new Currency[size];
        }
    };

    public double getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(double priceUSD) {
        this.priceUSD = priceUSD;
    }

    public Currency(String fullname, String shortName, int image, double priceUSD) {
        this.fullName = fullname;
        this.shortName = shortName;
        this.image = image;
        this.priceUSD = priceUSD;

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fullName);
        dest.writeString(shortName);
        dest.writeDouble(priceUSD);
        dest.writeInt(image);
    }
}

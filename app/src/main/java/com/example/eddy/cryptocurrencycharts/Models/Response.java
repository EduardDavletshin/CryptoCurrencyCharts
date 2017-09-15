package com.example.eddy.cryptocurrencycharts.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by eddy on 07.09.17.
 */

public class Response implements Parcelable {
    protected Response(Parcel in) {
    }

    public static final Creator<Response> CREATOR = new Creator<Response>() {
        @Override
        public Response createFromParcel(Parcel in) {
            return new Response(in);
        }

        @Override
        public Response[] newArray(int size) {
            return new Response[size];
        }
    };

    public ArrayList<Currency> getCurrencyArrayList() {
        return currencyArrayList;
    }

    private ArrayList<Currency> currencyArrayList;

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
    }
}

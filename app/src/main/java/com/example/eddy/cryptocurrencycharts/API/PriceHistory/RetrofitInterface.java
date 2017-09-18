package com.example.eddy.cryptocurrencycharts.API.PriceHistory;

import com.example.eddy.cryptocurrencycharts.Models.Currency;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by eddy on 06.09.17.
 */

public interface RetrofitInterface {

    @GET("/v1/ticker/?limit=20") Call<ArrayList<Currency>> getResponse();
}
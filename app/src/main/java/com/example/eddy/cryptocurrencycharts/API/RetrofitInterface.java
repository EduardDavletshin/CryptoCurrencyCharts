package com.example.eddy.cryptocurrencycharts.API;

import com.example.eddy.cryptocurrencycharts.Models.Currency;
import com.example.eddy.cryptocurrencycharts.Models.Response;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by eddy on 06.09.17.
 */

public interface RetrofitInterface {

    @GET("/v1/ticker/?limit=20") Call<ArrayList<Currency>> getResponse();
}

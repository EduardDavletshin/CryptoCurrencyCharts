package com.example.eddy.cryptocurrencycharts.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by eddy on 06.09.17.
 */

public class RetrofitSingleton {

    private static final String BASE_URL = "https://api.coinmarketcap.com";
    private static RetrofitSingleton instance = new RetrofitSingleton();
    private RetrofitInterface retrofitInterface;

    public RetrofitSingleton() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);
    }

    public static RetrofitSingleton getInstance() {
        return instance;
    }

    public RetrofitInterface getRetrofitInterface() {
        return retrofitInterface;
    }

}

package com.example.eddy.cryptocurrencycharts.API.CurrencyList;

import android.os.AsyncTask;

import com.example.eddy.cryptocurrencycharts.Models.Currency;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by eddy on 07.09.17.
 */

public class DataLoader extends AsyncTask<Object, Object, ArrayList<Currency>> {

    public static String              data;
    private       ArrayList<Currency> response;
    private       AsyncTaskCallback   callback;

    public DataLoader(AsyncTaskCallback callback) {
        this.callback = callback;
    }

    @Override protected ArrayList<Currency> doInBackground(Object... params) {
        try {
            response = RetrofitSingleton.getInstance().getRetrofitInterface().getResponse().execute().body();
            Gson gson = new Gson();
            data = gson.toJson(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override protected void onPostExecute(ArrayList<Currency> r) {
        super.onPostExecute(r);
        callback.onFinish(response);
    }
}

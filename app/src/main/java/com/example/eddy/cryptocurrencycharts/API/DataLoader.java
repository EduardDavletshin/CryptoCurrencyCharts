package com.example.eddy.cryptocurrencycharts.API;

import android.os.AsyncTask;

import com.example.eddy.cryptocurrencycharts.Models.Currency;
import com.example.eddy.cryptocurrencycharts.Models.Response;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by eddy on 07.09.17.
 */

public class DataLoader extends AsyncTask<Object, Object, ArrayList<Currency>> {

    private ArrayList<Currency> response;
    private AsyncTaskCallback  callback;

    public DataLoader(AsyncTaskCallback callback) {
        this.callback = callback;
    }

    @Override protected ArrayList<Currency> doInBackground(Object... params) {
        try {
            response = RetrofitSingleton.getInstance().getRetrofitInterface().getResponse().execute().body();
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

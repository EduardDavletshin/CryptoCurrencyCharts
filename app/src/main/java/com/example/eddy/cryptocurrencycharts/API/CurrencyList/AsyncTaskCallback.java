package com.example.eddy.cryptocurrencycharts.API.CurrencyList;

import com.example.eddy.cryptocurrencycharts.Models.Currency;
import com.example.eddy.cryptocurrencycharts.Models.Response;

import java.util.ArrayList;

/**
 * Created by eddy on 07.09.17.
 */

public interface AsyncTaskCallback {
    void onFinish(ArrayList<Currency> c);
}

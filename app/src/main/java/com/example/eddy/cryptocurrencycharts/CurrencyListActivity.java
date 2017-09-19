package com.example.eddy.cryptocurrencycharts;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.eddy.cryptocurrencycharts.API.CurrencyList.AsyncTaskCallback;
import com.example.eddy.cryptocurrencycharts.API.CurrencyList.DataLoader;
import com.example.eddy.cryptocurrencycharts.Models.Currency;
import com.example.eddy.cryptocurrencycharts.RecyvlerView.RecyclerViewAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.eddy.cryptocurrencycharts.API.CurrencyList.DataLoader.data;

public class CurrencyListActivity extends AppCompatActivity {

    public static final String PREFS = "prefs";
    @BindView(R.id.rv_currency_list) android.support.v7.widget.RecyclerView rvCurrencyList;
    ArrayList<Currency>      currencyArrayList;
    SharedPreferences        sharedPreferences;
    SharedPreferences.Editor editor;
    String                   string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_list);
        ButterKnife.bind(this);
        sharedPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);

        if (sharedPreferences.getString(PREFS, "").equals("")) {
            getCurrencyArrayList();
        } else {
            Type type = new TypeToken<ArrayList<Currency>>() {
            }.getType();
            currencyArrayList = new Gson().fromJson(sharedPreferences.getString(PREFS, ""), type);
            Log.d(PREFS, sharedPreferences.getString(PREFS, ""));
            initRecyclerView(currencyArrayList);
        }
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        sharedPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(PREFS, data);
        editor.commit();
    }

    private void initRecyclerView(ArrayList<Currency> currencies) {
        rvCurrencyList.setAdapter(new RecyclerViewAdapter(currencies));
        rvCurrencyList.setLayoutManager(new LinearLayoutManager(this));
        rvCurrencyList.setHasFixedSize(true);
        rvCurrencyList.setNestedScrollingEnabled(false);
    }

    private ArrayList<Currency> generateCurrencyList() {
        ArrayList<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency("Bitcoin", "BTC", R.drawable.afghanistan, 500));
        currencies.add(new Currency("Litecoin", "LTC", R.drawable.aland, 32.1));
        currencies.add(new Currency("Ethereal", "ETC", R.drawable.albania, 54.8));
        return currencies;
    }

    private void getCurrencyArrayList() {
        DataLoader dataLoader = new DataLoader(new AsyncTaskCallback() {
            @Override public void onFinish(ArrayList<Currency> r) {
                currencyArrayList = r;
                string = data;
                initRecyclerView(r);
            }
        });
        dataLoader.execute();
    }
}


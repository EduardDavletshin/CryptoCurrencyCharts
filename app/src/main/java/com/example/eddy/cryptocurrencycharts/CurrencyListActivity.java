package com.example.eddy.cryptocurrencycharts;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.eddy.cryptocurrencycharts.API.CurrencyList.AsyncTaskCallback;
import com.example.eddy.cryptocurrencycharts.API.CurrencyList.DataLoader;
import com.example.eddy.cryptocurrencycharts.Models.Currency;
import com.example.eddy.cryptocurrencycharts.Models.Response;
import com.example.eddy.cryptocurrencycharts.RecyvlerView.RecyclerViewAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.eddy.cryptocurrencycharts.API.CurrencyList.DataLoader.data;

public class CurrencyListActivity extends AppCompatActivity {

    private final String PREFS = "prefs";
    @BindView(R.id.rv_currency_list) android.support.v7.widget.RecyclerView rvCurrencyList;
    Response                 response;
    ArrayList<Currency>      currencyArrayList;
    SharedPreferences        sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_list);
        ButterKnife.bind(this);

//        if (!getPreferences(0).contains(PREFS)) {
//            getCurrencyArrayList();
//            initRecyclerView(currencyArrayList);
//        } else {
//            sharedPreferences = getPreferences(0);
//            Type type = new TypeToken<ArrayList<Currency>>() {}.getType();
//            currencyArrayList = new Gson().fromJson(sharedPreferences.getString(PREFS, null), type);
//        }
    }

    @Override protected void onStop() {
        super.onStop();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
        editor.putString(PREFS, data);
        editor.apply();
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
                initRecyclerView(r);
            }
        });
        dataLoader.execute();
    }
}


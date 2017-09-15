package com.example.eddy.cryptocurrencycharts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.example.eddy.cryptocurrencycharts.Models.Currency;
import com.github.mikephil.charting.charts.LineChart;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailedCurrencyActivity extends Activity {

    @BindView(R.id.toolbar_layout) CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.chart) LineChart lineChart;
    ArrayList<Currency> currencyList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_currency);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        currencyList = intent.getParcelableArrayListExtra("data");
        int i = intent.getIntExtra("position", 0);
        collapsingToolbarLayout.setTitle(currencyList.get(i).getFullName());


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            }
        });
    }


}

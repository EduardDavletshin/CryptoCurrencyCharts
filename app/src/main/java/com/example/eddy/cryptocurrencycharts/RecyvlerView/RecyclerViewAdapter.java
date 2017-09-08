package com.example.eddy.cryptocurrencycharts.RecyvlerView;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.eddy.cryptocurrencycharts.Models.Currency;
import com.example.eddy.cryptocurrencycharts.R;

import java.util.ArrayList;

/**
 * Created by eddy on 06.09.17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecycerViewHolder> {
    private ArrayList<Currency> currencyArrayList;
    private Context             context;

    public RecyclerViewAdapter(ArrayList<Currency> currencyList) {
        this.currencyArrayList = currencyList;
    }

    @Override public RecycerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        LinearLayout RecyclerViewLinearLayout = (LinearLayout) layoutInflater.inflate(R.layout.recycler_view_item, parent, false);
        context = RecyclerViewLinearLayout.getContext();
        return new RecycerViewHolder(RecyclerViewLinearLayout);
    }

    @Override public void onBindViewHolder(RecycerViewHolder holder, int position) {

        Currency currencyListPosition = currencyArrayList.get(position);

//        holder.label.setImageDrawable(ContextCompat.getDrawable(context, currencyListPosition.getImage()));
        holder.fullName.setText(currencyListPosition.getFullname());
        holder.priceUSD.setText((String.valueOf(currencyListPosition.getPriceUSD())));
        holder.shortName.setText(currencyListPosition.getShortName());
    }

    @Override public int getItemCount() {
        return currencyArrayList.size();
    }
}

package com.example.eddy.cryptocurrencycharts.RecyvlerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eddy.cryptocurrencycharts.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by eddy on 06.09.17.
 */

public class RecycerViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.ic_label)      ImageView label;
    @BindView(R.id.ic_full_name)  TextView  fullName;
    @BindView(R.id.ic_short_name) TextView  shortName;
    @BindView(R.id.priceUSD)      TextView  priceUSD;
    @BindView(R.id.details)       ImageView details;


    public RecycerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}

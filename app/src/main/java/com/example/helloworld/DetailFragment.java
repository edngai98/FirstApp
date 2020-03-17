package com.example.helloworld;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public class DetailFragment extends Fragment {

    List<Coin> coinList = Coin.getCoins();


    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        int value = 0;
        Coin myCoin;

        TextView value_of_coin = v.findViewById(R.id.valueUSD);
        TextView change_one_hour = v.findViewById(R.id.change1Hour);
        TextView change_24_hour = v.findViewById(R.id.change24Hours);
        TextView change_7_days = v.findViewById(R.id.change7Days);
        TextView marketCap = v.findViewById(R.id.marketCap);
        TextView volume_24_hours = v.findViewById(R.id.volume24Hour);
        TextView coin_title = v.findViewById(R.id.coinTitle);
        TextView coin_abbrev = v.findViewById(R.id.coinTitleAbbreviation);

        boolean wide = false;
        if (this.getArguments() != null) {

            wide = getArguments().getBoolean("wide", true);

        }


        if (!wide) {

            Intent intent = getActivity().getIntent();
            value = intent.getIntExtra("pos", 0);
            myCoin = Coin.getCoins().get(value);

        } else {

            myCoin = coinList.get(getArguments().getInt("pos"));
        }

        coin_title.setText(String.valueOf(myCoin.getName()));
        coin_abbrev.setText(String.valueOf(myCoin.getSymbol()));
        value_of_coin.setText(String.valueOf(myCoin.getValue()));
        change_one_hour.setText(String.valueOf(myCoin.getChange1h()));
        change_24_hour.setText(String.valueOf(myCoin.getChange24h()));
        change_7_days.setText(String.valueOf(myCoin.getChange7d()));
        marketCap.setText(String.valueOf(myCoin.getMarketcap()));
        volume_24_hours.setText(String.valueOf(myCoin.getVolume()));



        return v;
    }



}

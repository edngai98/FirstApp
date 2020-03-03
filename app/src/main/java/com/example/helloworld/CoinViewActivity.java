package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class CoinViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_view);
        Intent intent = getIntent();
        String value = intent.getStringExtra("message");

        TextView value_of_coin = (TextView) findViewById(R.id.valueUSD);
        TextView change_one_hour = (TextView) findViewById(R.id.change1Hour);
        TextView change_24_hour = (TextView) findViewById(R.id.change24Hours);
        TextView change_7_days = (TextView) findViewById(R.id.change7Days);
        TextView marketCap = (TextView) findViewById(R.id.marketCap);
        TextView volume_24_hours = (TextView) findViewById(R.id.volume24Hour);
        TextView coin_title = (TextView) findViewById(R.id.coinTitle);
        TextView coin_abbrev = (TextView) findViewById(R.id.coinTitleAbbreviation);

        ArrayList<Coin> coinsList = Coin.getCoins();

        Coin myCoin = Coin.search(value);

        value_of_coin.setText(myCoin.getName());
        change_one_hour.setText(String.valueOf(myCoin.getChange1h()));
        change_24_hour.setText(String.valueOf(myCoin.getChange24h()));
        change_7_days.setText(String.valueOf(myCoin.getChange7d()));
        marketCap.setText(String.valueOf(myCoin.getMarketcap()));
        volume_24_hours.setText(String.valueOf(myCoin.getVolume()));




    }
}

package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CoinViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_view);
        Intent intent = getIntent();
        String value = intent.getStringExtra("Bitcoin");



        Coin myCoin = Coin.search(value);

        TextView value_of_coin = (TextView) findViewById(R.id.valueUSD);
        TextView change_one_hour = (TextView) findViewById(R.id.change1Hour);
        TextView change_24_hour = (TextView) findViewById(R.id.change24Hours);
        TextView change_7_days = (TextView) findViewById(R.id.change7Days);
        TextView marketCap = (TextView) findViewById(R.id.marketCap);
        TextView volume_24_hours = (TextView) findViewById(R.id.volume24Hour);
        TextView coin_title = (TextView) findViewById(R.id.coinTitle);
        TextView coin_abbrev = (TextView) findViewById(R.id.coinTitleAbbreviation);

        coin_title.setText(String.valueOf(myCoin.getName()));
        coin_abbrev.setText(String.valueOf(myCoin.getSymbol()));
        value_of_coin.setText(String.valueOf(myCoin.getValue()));
        change_one_hour.setText(String.valueOf(myCoin.getChange1h()));
        change_24_hour.setText(String.valueOf(myCoin.getChange24h()));
        change_7_days.setText(String.valueOf(myCoin.getChange7d()));
        marketCap.setText(String.valueOf(myCoin.getMarketcap()));
        volume_24_hours.setText(String.valueOf(myCoin.getVolume()));


    }

    private void handleIntent(Intent intent) {


        Button videoButton = (Button) findViewById(R.id.searchCoinButton);

        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Intent.ACTION_WEB_SEARCH);
                String keyword = "Bitcoin";
                intent2.putExtra(SearchManager.QUERY, keyword);
                startActivity(intent2);
            }
        });

    }
}
    package com.example.helloworld;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.fragment.app.Fragment;
    import androidx.fragment.app.FragmentManager;
    import androidx.fragment.app.FragmentTransaction;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import android.content.Intent;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.View;
    import android.widget.Button;

    import java.util.ArrayList;
    import java.util.List;


    public class MainActivity extends AppCompatActivity{
        private static final String TAG = "MainActivity";
        private RecyclerView recyclerView;
        private CoinAdapter adapter;
        private RecyclerView.LayoutManager layoutManager;

        private List<Coin> coinData = new ArrayList<Coin>();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            Log.d(TAG, "onCreate: Starting OnCreate");
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            coinData = Coin.getCoins();

            recyclerView = (RecyclerView) findViewById(R.id.recycler);
            recyclerView.setHasFixedSize(true);

            adapter = new CoinAdapter(this, coinData);
            recyclerView.setAdapter(adapter);
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);

            FragmentManager myManager = getSupportFragmentManager();
            FragmentTransaction myTransaction = myManager.beginTransaction();
            Fragment myFragment = new myFragment();
            Bundle arguments = new Bundle();
            arguments.putString("pos", 0);
            myFragment.setArguments(arguments);
            myTransaction.replace(R.id.scrollView2, myFragment);
            myTransaction.commit();


        }


    }

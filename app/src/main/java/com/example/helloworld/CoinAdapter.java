package com.example.helloworld;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.RecycleViewHolder> {
    private LayoutInflater inflater;
    private List<Coin> coinData = new ArrayList<Coin>();

    public CoinAdapter (Context context, List<Coin> coinData){
        inflater = LayoutInflater.from(context);
        this.coinData = coinData;
    }

    @NonNull
    @Override
    public CoinAdapter.RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = inflater.inflate(R.layout.card_rows,parent,false);
        return new RecycleViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull CoinAdapter.RecycleViewHolder holder, int position) {
        holder.coinName.setText(coinData.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return coinData.size();
    }

    class RecycleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView imageView;
        public TextView coinName;
        public TextView coinSymbol;
        final CoinAdapter adapter;


        public RecycleViewHolder(View itemView, CoinAdapter coinAdapter) {
            super(itemView);
            coinName = (TextView)itemView.findViewById(R.id.coinName);
            //coinSymbol = (TextView)itemView.findViewById(R)
            this.adapter = coinAdapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            Coin coin = coinData.get(position);

            Intent intent = new Intent(v.getContext(), CoinViewActivity.class);
            intent.putExtra("pos", position);
            v.getContext().startActivity(intent);
        }
    }
}

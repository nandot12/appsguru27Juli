package com.prestasimu99.lenovo.Guru;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.prestasimu99.lenovo.Guru.modelhome.DataItem;

import java.util.List;

public class PaketAdapter extends RecyclerView.Adapter<PaketAdapter.MyHolder> {

    private List<DataItem> data;
    private Context c;




    public PaketAdapter(List<DataItem> data, Context c) {
        this.data = data;
        this.c = c;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(c).inflate(R.layout.itemlist, viewGroup, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder, @SuppressLint("RecyclerView") final int i) {
        myHolder.bind(data.get(i));



        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent move = new Intent(c, MapsActivity.class);
                move.putExtra(Constans.id,data.get(i));
                c.startActivity(move);
            }
        });}

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView textTitle;
        TextView subTitle;
        TextView subsubsubTitle;
        TextView subsubTitle;
        TextView subsubsubsubTitle;


        MyHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.itemTitle);
            subTitle = itemView.findViewById(R.id.itemSubtitle);
            subsubsubTitle = itemView.findViewById(R.id.itemSubsubsubtitle);
            subsubTitle = itemView.findViewById(R.id.itemSubsubtitle);
            subsubsubsubTitle = itemView.findViewById(R.id.itemSubsubsubsubtitle);
        }

        @SuppressLint("SetTextI18n")
        void bind(DataItem dataItem) {
            textTitle.setText(dataItem.getOrderTanggal());
            subTitle.setText(dataItem.getOrderAlamat());
            subsubsubTitle.setText(dataItem.getOrderJp());
            subsubTitle.setText(dataItem.getOrderHp());
            subsubsubsubTitle.setText(dataItem.getBookingKet());
        }
    }


}

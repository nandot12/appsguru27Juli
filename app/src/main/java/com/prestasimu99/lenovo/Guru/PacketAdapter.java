package com.prestasimu99.lenovo.Guru;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.prestasimu99.lenovo.Guru.modelsignup.DataItem;

import java.util.List;

public class PacketAdapter extends BaseAdapter {
    List<DataItem> data;
    public PacketAdapter(List<DataItem> data) {
        this.data = data;
    }






    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemspinner,parent,false);

        TextView textview = view.findViewById(R.id.texviewName);
        textview.setText(data.get(position).getJpJenjang() + "-" + data.get(position).getJpNama());

        return view;
    }



}
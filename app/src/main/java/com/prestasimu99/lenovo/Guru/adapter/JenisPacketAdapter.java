package com.prestasimu99.lenovo.Guru.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.prestasimu99.lenovo.Guru.R;
import com.prestasimu99.lenovo.Guru.modelsignup.DataItem;

import java.util.List;

public class JenisPacketAdapter extends BaseAdapter {


    List<DataItem> data ;

    public JenisPacketAdapter(List<DataItem> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_jenis_paket,viewGroup,false);

        TextView textViewItem = view.findViewById(R.id.itemJp);

        textViewItem.setText(data.get(i).getJpNama()+"-"+ data.get(i).getJpJenjang());
        return view;
    }
}

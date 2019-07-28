package com.prestasimu99.lenovo.Guru;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.Button;

import com.prestasimu99.lenovo.Guru.modelhome.DataItem;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import java.io.IOException;
import java.util.List;
import java.util.Locale;

import butterknife.ButterKnife;

public class MapsActivity extends BaseActivity implements OnMapReadyCallback {



    private GoogleMap mMap;

    private DataItem data;

    Button buttonName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        ButterKnife.bind(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);


        }
        buttonName = findViewById(R.id.textName);


    }

    private void initIntent() {

        data= (DataItem) getIntent().getSerializableExtra(Constans.id);

        String name = showName(data.getOrderLat(),data.getOrderLon());
        buttonName.setText(name);

        setMarket(data);

    }

    private String showName(String orderLat, String orderLon) {


        String name = "" ;
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> data  =    geocoder.getFromLocation(Double.parseDouble(orderLat), Double.parseDouble(orderLon), 1);

            name = data.get(0).getAddressLine(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return name ;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        initIntent();

    }


    private void setMarket(DataItem data) {

        LatLng latLng = new LatLng(Double.parseDouble(data.getOrderLat()), Double.parseDouble(data.getOrderLon()));

        mMap.addMarker(new MarkerOptions().position(latLng).title(data.getOrderAlamat()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17));

    }



}

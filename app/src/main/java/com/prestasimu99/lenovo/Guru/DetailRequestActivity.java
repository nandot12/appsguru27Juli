package com.prestasimu99.lenovo.Guru;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.prestasimu99.lenovo.Guru.modelsignup.ResponseSignUp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailRequestActivity extends BaseActivity {

    @BindView(R.id.detailName)
    TextView detailName;
    @BindView(R.id.detailjenjang)
    TextView detailjenjang;
    @BindView(R.id.detailAlamat)
    TextView detailAlamat;
    @BindView(R.id.detailKeterangan)
    EditText detailKeterangan;
    private String id;
    private String lat;
    private String lon;
    private String jenjang;
    private String packet;
    private String namelocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_request);
        ButterKnife.bind(this);


        initIntent();
        setView();
    }

    private void setView() {
        detailName.setText(sesi.getNama());
        detailAlamat.setText(namelocation);
        detailjenjang.setText(jenjang + " - " + packet);


    }

    private void initIntent() {

        id = getIntent().getStringExtra(Constans.id);
        namelocation = getIntent().getStringExtra(Constans.nameLocation);
        lat = getIntent().getStringExtra(Constans.lat);
        lon = getIntent().getStringExtra(Constans.lon);
        packet = getIntent().getStringExtra(Constans.packet);
        jenjang = getIntent().getStringExtra(Constans.jenjang);
    }

    @OnClick(R.id.btnRequest)
    public void onViewClicked() {


        NetworkClient.service.actionRequest(sesi.getIdUser(), id, lat, lon, namelocation, detailKeterangan.getText().toString())
                .enqueue(new Callback<ResponseSignUp>() {
                    @Override
                    public void onResponse(Call<ResponseSignUp> call, Response<ResponseSignUp> response) {

                        if (response.isSuccessful()) {

                            boolean status = response.body().isStatus();

                            if (status) {

                                startActivity(new Intent(c, DoneActivity.class));

                            }
                        }


                    }

                    @Override
                    public void onFailure(Call<ResponseSignUp> call, Throwable t) {

                    }
                });
    }
}
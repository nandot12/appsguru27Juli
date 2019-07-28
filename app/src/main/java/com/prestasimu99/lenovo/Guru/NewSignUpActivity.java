package com.prestasimu99.lenovo.Guru;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.prestasimu99.lenovo.Guru.adapter.JenisPacketAdapter;
import com.prestasimu99.lenovo.Guru.modelsignup.DataItem;
import com.prestasimu99.lenovo.Guru.modelsignup.ResponseSignUp;
import com.prestasimu99.lenovo.Guru.register_user.RegisterUser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewSignUpActivity extends AppCompatActivity {


    @BindView(R.id.regName)
    EditText regName;
    @BindView(R.id.regEmail)
    EditText regEmail;
    @BindView(R.id.regHp)
    EditText regHp;
    @BindView(R.id.regJk)
    EditText regJk;
    @BindView(R.id.regPassword)
    EditText regPassword;
    @BindView(R.id.regConfirmPas)
    EditText regConfirmPas;
    @BindView(R.id.regbtnSignUp)
    Button regbtnSignup;
    @BindView(R.id.linkLogin)
    TextView linkSignIn;
//    @BindView(R.id.cb_fisika)
//    TextView cbFisika;
//    @BindView(R.id.cb_ipa)
//    TextView cbIpa;
//    @BindView(R.id.cb_mtk)
//    TextView cbMtk;

    String matpel1 = "";
    String matpel2 = "";
    String matpel3 = "";
    String levelUser = "guru";
    String alamat;
    String kota;

    String iqraumum;
    String alquranumum;
    String hafalquranumum;
    String arabsd;
    String arabsmp;
    String arabsma;
    String inggrissd;
    String inggrissmp;
    String inggrissma;
    String tematiksd;
    String biologismp;
    String matematikasmp;
    String fisikasmp;
    String biologisma;
    String kimiasma;
    String fisikasma;
    String matematikasma;
    String facialumum;
    String barberumum;
    String jahitumum;
    String makeupumum;
    String namabank;
    String namapemilik;
    String norek;
    String bindosmp;
    String ipssmp;
    String bindosma;
    String sejarahsma;
    String sosiologisma;
    String geografisma;
    String astronomisma;


    String noHp, name, password, email;

    DatabaseReference databaseReference;
    @BindView(R.id.etAlamat)
    EditText etAlamat;
    @BindView(R.id.regKota)
    EditText regKota;
    //    @BindView(R.id.regIqraUmum)
//    EditText regIqraUmum;
//    @BindView(R.id.regAlQuranUmum)
//    EditText regAlQuranUmum;
//    @BindView(R.id.regHafalQuranUmum)
//    EditText regHafalquranUmum;
//    @BindView(R.id.regArabSd)
//    EditText regArabSd;
//    @BindView(R.id.regArabSmp)
//    EditText regArabSmp;
//    @BindView(R.id.regArabSma)
//    EditText regArabSma;
//    @BindView(R.id.regInggrisSd)
//    EditText regInggrisSd;
//    @BindView(R.id.regInggrisSmp)
//    EditText regInggrisSmp;
//    @BindView(R.id.regInggrisSma)
//    EditText regInggrisSma;
//    @BindView(R.id.regTematikSd)
//    EditText regTematikSd;
//    @BindView(R.id.regBiologiSmp)
//    EditText regBiologiSmp;
//    @BindView(R.id.regMatematikaSmp)
//    EditText regMatematikaSmp;
//    @BindView(R.id.regFisikaSmp)
//    EditText regFisikaSmp;
//    @BindView(R.id.regBiologiSma)
//    EditText regBiologiSma;
//    @BindView(R.id.regKimiaSma)
//    EditText regKimiaSma;
//    @BindView(R.id.regFisikaSma)
//    EditText regFisikaSma;
//    @BindView(R.id.regMatematikaSma)
//    EditText regMatematikaSma;
//    @BindView(R.id.regFacialUmum)
//    EditText regFacialUmum;
//    @BindView(R.id.regBarberUmum)
//    EditText regBarberUmum;
//    @BindView(R.id.regJahitUmum)
//    EditText regJahitUmum;
    // @BindView(R.id.regMakeupUmum)
    // EditText regMakeupUmum;
//    @BindView(R.id.regNamaBank)
//    EditText regNamaBank;
    @BindView(R.id.regNamaPemilik)
    EditText regNamaPemilik;
    @BindView(R.id.regNoRek)
    EditText regNoRek;
    @BindView(R.id.regNamaBank)
    EditText regNamaBank;
    @BindView(R.id.regListJp)
    Spinner regListJp;
    @BindView(R.id.txtSpinner)
    TextView txtSpinner;
//    @BindView(R.id.regBindoSmp)
//    EditText regBindoSmp;
//    @BindView(R.id.regIpsSmp)
//    EditText regIpsSmp;
//    @BindView(R.id.regBindoSma)
//    EditText regBindoSma;
//    @BindView(R.id.regSejarahSma)
//    EditText regSejarahSma;
//    @BindView(R.id.regSosiologiSma)
//    EditText regSosiologiSma;
//    @BindView(R.id.regGeografiSma)
//    EditText regGeografiSma;
//    @BindView(R.id.regAstronomiSma)
//    EditText regAstronomiSma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity_sign_up);
        Firebase.setAndroidContext(this);
        //getRefrance for user table
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        ButterKnife.bind(this);

        getJp();


    }

    private void getJp() {

        NetworkClient.service.actionGetPacket().enqueue(new Callback<ResponsePacket>() {
            @Override
            public void onResponse(Call<ResponsePacket> call, Response<ResponsePacket> response) {

                if (response.isSuccessful()) {

                    List<DataItem> data = response.body().getData();
                    showDataPacket(data);
                }

            }

            @Override
            public void onFailure(Call<ResponsePacket> call, Throwable t) {

            }
        });


    }

    private void showDataPacket(final List<DataItem> data) {

        JenisPacketAdapter adapter = new JenisPacketAdapter(data);
        regListJp.setAdapter(adapter);

        regListJp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                txtSpinner.setText(data.get(i).getJpId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }


    private void actionInsert() {


        name = regName.getText().toString();
        email = regEmail.getText().toString();
        alamat = etAlamat.getText().toString();
        kota = regKota.getText().toString();
//        iqraumum = regIqraUmum.getText().toString();
//        alquranumum = regAlQuranUmum.getText().toString();
//        hafalquranumum = regHafalquranUmum.getText().toString();
//        arabsd = regArabSd.getText().toString();
//        arabsmp = regArabSmp.getText().toString();
//        arabsma = regArabSma.getText().toString();
//        inggrissd = regInggrisSd.getText().toString();
//        inggrissmp = regInggrisSmp.getText().toString();
//        inggrissma = regInggrisSma.getText().toString();
//        tematiksd = regTematikSd.getText().toString();
//        biologismp = regBiologiSmp.getText().toString();
//        matematikasmp = regMatematikaSmp.getText().toString();
//        fisikasmp = regFisikaSmp.getText().toString();
//        biologisma = regBiologiSma.getText().toString();
//        kimiasma = regKimiaSma.getText().toString();
//        fisikasma = regFisikaSma.getText().toString();
//        matematikasma = regMatematikaSma.getText().toString();
//        facialumum = regFacialUmum.getText().toString();
//        barberumum = regBarberUmum.getText().toString();
//        jahitumum = regJahitUmum.getText().toString();
//        makeupumum = regMakeupUmum.getText().toString();
//        namabank = regNamaBank.getText().toString();
//        namapemilik = regNamaPemilik.getText().toString();
//        norek = regNoRek.getText().toString();
//        bindosmp = regBindoSmp.getText().toString();
//        ipssmp = regIpsSmp.getText().toString();
//        bindosma = regBindoSma.getText().toString();
//        sejarahsma = regSejarahSma.getText().toString();
//        sosiologisma = regSosiologiSma.getText().toString();
//        geografisma = regGeografiSma.getText().toString();
//        astronomisma = regAstronomiSma.getText().toString();
        String jk = regJk.getText().toString();
        password = regPassword.getText().toString();
        noHp = regHp.getText().toString();
        String confirPass = regConfirmPas.getText().toString();
        String data1, data2, data3;
        String nMatpel1, nMatpel2, nMatpel3;


        data1 = matpel1;
        data2 = matpel2;
        data3 = matpel3;

        //cek data
//        if (data1.isEmpty()) {
//            nMatpel1 = "NULL";
//        } else {
//            nMatpel1 = cbFisika.getText().toString();
//        }
//
//        if (data2.isEmpty()) {
//            nMatpel2 = "NULL";
//        } else {
//            nMatpel2 = cbIpa.getText().toString();
//        }
//
//        if (data3.isEmpty()) {
//            nMatpel3 = "NULL";
//        } else {
//            nMatpel3 = cbMtk.getText().toString();
//        }


        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirPass.isEmpty() || noHp.isEmpty()) {

            showToast(getString(R.string.pesan));
        } else if (!password.equals(confirPass)) {

            showToast(getString(R.string.not_match));
        } else {

            final ProgressDialog pd = new ProgressDialog(NewSignUpActivity.this);
            pd.setMessage("Loading...");
            pd.show();

//            NetworkClient.service.actionSignUp(name, password, noHp, email, jk, nMatpel1, nMatpel2, nMatpel3, alamat, kota, iqraumum, alquranumum, hafalquranumum, arabsd, arabsmp, arabsma, inggrissd, inggrissmp, inggrissma, tematiksd, biologismp, matematikasmp, fisikasmp, biologisma, kimiasma, fisikasma, matematikasma, facialumum, barberumum, jahitumum, makeupumum, namabank, namapemilik, norek, bindosmp, ipssmp, bindosma, sejarahsma, geografisma, sosiologisma, astronomisma).enqueue(new Callback<ResponseSignUp>() {
//                @Override
//                public void onResponse(Call<ResponseSignUp> call, Response<ResponseSignUp> response) {
//
//                    if (response.isSuccessful()) {
//
//                        Boolean result = response.body().isStatus();
//                        String pesan = response.body().getPesan();
//                        if (result) {
//                            daftar_chat();
//                            startActivity(new Intent(NewSignUpActivity.this, LoginActivity.class));
//                            finish();
//                        } else {
//
//                            showToast(pesan);
//
//                        }
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<ResponseSignUp> call, Throwable t) {
//
//                }
//            });

            NetworkClient.service.actionSignUpGuru(name,password,noHp,email,jk,alamat,kota,namabank,namapemilik,norek,txtSpinner.getText().toString())
                    .enqueue(new Callback<ResponseSignUp>() {
                        @Override
                        public void onResponse(Call<ResponseSignUp> call, Response<ResponseSignUp> response) {
                            if(response.isSuccessful()){
                                String pesan = response.body().getPesan() ;
                                Boolean result = response.body().isStatus();

                                if(result){
                                    daftar_chat();
                                    startActivity(new Intent(NewSignUpActivity.this,LoginActivity.class));
                                    finish();
                                }
                                else{
                                    showToast(pesan);
                                }

                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseSignUp> call, Throwable t) {

                        }
                    });

            pd.dismiss();
        }
    }


    private void showToast(String pesan) {
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.regbtnSignUp, R.id.linkLogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.regbtnSignUp:
                actionInsert();


                break;
            case R.id.linkLogin:
                actionMove();
                break;


        }
    }

    private void actionMove() {


        startActivity(new Intent(NewSignUpActivity.this, LoginActivity.class));


    }

    private void daftar_chat() {

//       final  String id ;
        //creating an User Object


        String url = "https://guruku2-572b2.firebaseio.com/guru.json";

        StringRequest request = new StringRequest(Request.Method.GET, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Firebase reference = new Firebase("https://guruku2-572b2.firebaseio.com/guru");

                if (s.equals("null")) {
//                    id = reference.push().getKey();
                    RegisterUser User = new RegisterUser(name, email, noHp, levelUser);
                    //Saving the User
                    reference.child(name).setValue(User);
//                    reference.child(noHp).child("password").setValue(password);
//                    reference.child(noHp).child("nohp").setValue(noHp);
//                    reference.child(password).child("password").setValue(password);
//                    reference.child(name).child("name").setValue(name);
//                    reference.child("nohp").setValue(noHp);
//                    reference.child("password").setValue(password);

                    Toast.makeText(getApplicationContext(), "registration successful", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        JSONObject obj = new JSONObject(s);

                        if (!obj.has(name)) {
                            RegisterUser User = new RegisterUser(name, email, noHp, levelUser);
                            //Saving the User
                            reference.child(name).setValue(User);
//                            reference.child(noHp).child("nohp").setValue(noHp);
//                            reference.child(password).child("password").setValue(password);
//                            reference.child(name).child("name").setValue(name);
////                            reference.child(noHp).child("password").setValue(password);
//                            reference.child("nohp").setValue(noHp);
//                           reference. child("password").setValue(password);

                            Toast.makeText(getApplicationContext(), "registration successful", Toast.LENGTH_LONG).show();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


            }

        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                System.out.println("" + volleyError);
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(NewSignUpActivity.this);
        rQueue.add(request);

    }


}
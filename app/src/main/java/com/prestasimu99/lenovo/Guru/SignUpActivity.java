package com.prestasimu99.lenovo.Guru;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.prestasimu99.lenovo.Guru.modelsignup.ResponseSignUp;
import com.prestasimu99.lenovo.Guru.register_user.RegisterUser;
import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {


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
    @BindView(R.id.regAlamat)
    EditText regAlamat;
    @BindView(R.id.regKel)
    EditText regKel;
    @BindView(R.id.regKec)
    EditText regKec;
    @BindView(R.id.regKota)
    EditText regKota;
    @BindView(R.id.regbtnSignup)
    Button regbtnSignup;
    @BindView(R.id.linkLogin)
    TextView linkSignIn;


    String levelUser = "guru";

    String noHp, name, password, email, jk, alamat, kelurahan, kec, kab, confirPass;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Firebase.setAndroidContext(this);
        //getRefrance for user table
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        ButterKnife.bind(this);


    }


    private void actionInsert() {


        name = regName.getText().toString();
        email = regEmail.getText().toString();
        jk = regJk.getText().toString();
        password = regPassword.getText().toString();
        noHp = regHp.getText().toString();
        alamat = regAlamat.getText().toString();
        kab = regKota.getText().toString();
        kec= regKec.getText().toString();
        kelurahan = regKel.getText().toString();
        confirPass = regConfirmPas.getText().toString();






        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirPass.isEmpty() || jk.isEmpty() || alamat.isEmpty() || kelurahan.isEmpty() || kec.isEmpty() || kab.isEmpty() || noHp.isEmpty()) {

            showToast(getString(R.string.pesan));
        } else if (!password.equals(confirPass)) {

            showToast(getString(R.string.not_match));
        } else {

            final ProgressDialog pd = new ProgressDialog(SignUpActivity.this);
            pd.setMessage("Loading...");
            pd.show();

            NetworkClient.service.actionSINGup(name, email, password, alamat, kelurahan, kec, kab, noHp, jk).enqueue(new Callback<ResponseSignUp>() {
                @Override
                public void onResponse(Call<ResponseSignUp> call, Response<ResponseSignUp> response) {

                    if (response.isSuccessful()) {

                        Boolean result = response.body().isStatus();
                        String pesan = response.body().getPesan();
                        if (result) {
                            daftar_chat();
                            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                            finish();
                        } else {

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

    @OnClick({R.id.regbtnSignup, R.id.linkLogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.regbtnSignup:
                actionInsert();


                break;
            case R.id.linkLogin:
                actionMove();
                break;


        }
    }

    private void actionMove() {


        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));


    }

    private void daftar_chat(){

//       final  String id ;
        //creating an User Object



        String url = "https://guruku2-572b2.firebaseio.com/guru.json";

        StringRequest request = new StringRequest(Request.Method.GET, url, new com.android.volley.Response.Listener<String>(){
            @Override
            public void onResponse(String s) {
                Firebase reference = new Firebase("https://guruku2-572b2.firebaseio.com/guru");

                if(s.equals("null")){
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
                }
                else {
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

        },new com.android.volley.Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                System.out.println("" + volleyError );
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(SignUpActivity.this);
        rQueue.add(request);

    }


}
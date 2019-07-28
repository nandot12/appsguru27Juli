package com.prestasimu99.lenovo.Guru;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected SessionManager sesi ;
    protected Context c ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        c = this ;
        sesi = new SessionManager(c);
    }
}
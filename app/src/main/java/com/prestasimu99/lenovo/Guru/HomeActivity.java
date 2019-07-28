package com.prestasimu99.lenovo.Guru;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.prestasimu99.lenovo.Guru.chat_package.ListUserChat;


public class HomeActivity extends AppCompatActivity {

    private SessionManager sesi ;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    FragmentTransaction move = getSupportFragmentManager().beginTransaction();
                    move.replace(R.id.container, new HomeFragment()).commit();
                    return true;
                case R.id.navigation_notifications:

                    FragmentTransaction move2 = getSupportFragmentManager().beginTransaction();
                    move2.replace(R.id.container, new ProfileFragment()).commit();
                    return true;
                case R.id.navigation_chat:

                    FragmentTransaction move3 = getSupportFragmentManager().beginTransaction();
                    move3.replace(R.id.container, new ListUserChat()).commit();
                    return true;
                case R.id.navigation_harga:

                    FragmentTransaction move4 = getSupportFragmentManager().beginTransaction();
                    move4.replace(R.id.container, new HargaFragment()).commit();
                    return true;
                case R.id.navigation_ketentuan:

                    FragmentTransaction move5 = getSupportFragmentManager().beginTransaction();
                    move5.replace(R.id.container, new SyaratFragment()).commit();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sesi = new SessionManager(this);
        actionToken();

        FragmentTransaction move = getSupportFragmentManager().beginTransaction();
        move.replace(R.id.container, new HomeFragment()).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation_btm);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void actionToken() {


        String token = FirebaseInstanceId.getInstance().getToken();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference reference = firebaseDatabase.getReference("Token_User");
        reference.child(sesi.getNama()).child("token").setValue(token);


    }

}
package com.example.express_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Clinic_page extends AppCompatActivity  implements View.OnClickListener {

    private CardView bu1, bu2, bu3, bu4;

    DrawerLayout drawerLayout;

    ImageView menu;


    LinearLayout home, seetting, logout, cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic_page);


        drawerLayout = findViewById(R.id.drawballay);

        menu = findViewById(R.id.menue);
        home = findViewById(R.id.Home);
        seetting = findViewById(R.id.seeting);
        logout = findViewById(R.id.logout);
        cart = findViewById(R.id.cart);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrawer(drawerLayout);

            }
        });

        seetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(Clinic_page.this,Servies_page.class);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(Clinic_page.this,mnu_appl.class);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(Clinic_page.this,mnu_appl.class);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(Clinic_page.this,MainActivity.class);
            }
        });



    }
    public static void  openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public static void closeDrawer(DrawerLayout drawerLayout){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public static void redirectActivity(Activity activity, Class secondActivity){
        Intent intent = new Intent(activity,secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);


    bu1 = (CardView) findViewById(R.id.lacgo);
        bu2 = (CardView) findViewById(R.id.cosmo);
        bu3 = (CardView) findViewById(R.id.kaya);
        bu4 = (CardView) findViewById(R.id.dar);



        initial();
    }

    private void initial() {

       bu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Clinic_page.this, laclinic.class);
                startActivity(intent);
                finish();
            }
        });


        bu1.setOnClickListener((View.OnClickListener) this);
        bu2.setOnClickListener((View.OnClickListener) this);
        bu3.setOnClickListener((View.OnClickListener) this);
        bu4.setOnClickListener((View.OnClickListener) this);




    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.lacgo:
                i = new Intent(Clinic_page.this, laclinic.class);
                startActivities(i);
                break;
            case R.id.cosmo:
                i = new Intent(Clinic_page.this, cosmclin.class);
                startActivities(i);
                break;
            case R.id.kaya:
                i = new Intent(Clinic_page.this, kayacli.class);
                startActivities(i);
                break;
            case R.id.dar:
                i = new Intent(Clinic_page.this, darclinc.class);
                startActivities(i);
                break;

        }
    }

    private void startActivities(Intent i) {

        bu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Clinic_page.this, Clinic_page.class);
                startActivity(intent);
            }
        });

        bu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Clinic_page.this, cosmclin.class);
                startActivity(intent);
            }
        });

        bu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Clinic_page.this, kayacli.class);
                startActivity(intent);
            }
        });

        bu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Clinic_page.this, darclinc.class);
                startActivity(intent);
            }
        });


    }

}





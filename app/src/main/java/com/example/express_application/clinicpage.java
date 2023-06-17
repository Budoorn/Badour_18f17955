package com.example.express_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class clinicpage extends AppCompatActivity implements View.OnClickListener {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_mnue, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.logout) {
            startActivity(new Intent(clinicpage.this,MainActivity.class));
        }
        else if (id == R.id.home) {

            startActivity(new Intent(clinicpage.this,mnu_appl.class));
        }
        else if (id == R.id.store) {
            startActivity(new Intent(clinicpage.this,Servies_page.class));
        }


        return super.onOptionsItemSelected(item);
    }



    private CardView m1, m2, m3, m4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinicpage);

        m1 = (CardView) findViewById(R.id.lacgo);
        m2 = (CardView) findViewById(R.id.cosmo);
        m3 = (CardView) findViewById(R.id.kaya);
        m4 = (CardView) findViewById(R.id.dar);




        m1.setOnClickListener((View.OnClickListener) this);
        m2.setOnClickListener((View.OnClickListener) this);
        m3.setOnClickListener((View.OnClickListener) this);
        m4.setOnClickListener((View.OnClickListener) this);

    }

    @Override

    public void onClick (View v){
        Intent i ;
        switch ((v.getId())){

            case R.id.lacgo: i = new Intent(this, laclinic.class);
            startActivity(i);
            break;

            case R.id.cosmo: i = new Intent(this, cosmclin.class);
                startActivity(i);
                break;
            case R.id.kaya: i = new Intent(this, kayacli.class);
                startActivity(i);
                break;
            case R.id.dar: i = new Intent(this, darclinc.class);
                startActivity(i);
                break;
        }
    }

}
package com.example.express_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class mnu_appl extends AppCompatActivity  implements View.OnClickListener {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_mnue, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.logout) {
            startActivity(new Intent(mnu_appl.this,MainActivity.class));
        }
        else if (id == R.id.home) {

            startActivity(new Intent(mnu_appl.this,mnu_appl.class));
        }
        else if (id == R.id.store) {
            startActivity(new Intent(mnu_appl.this,Servies_page.class));
        }


        return super.onOptionsItemSelected(item);
    }


    private CardView b1, b2, b3, b4;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mnu_appl);

        b1 = (CardView) findViewById(R.id.bud1);
        b2 = (CardView) findViewById(R.id.bud2);
        b3 = (CardView) findViewById(R.id.bud3);
        b4 = (CardView) findViewById(R.id.bud4);

        initial();
    }


    private void initial() {

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(mnu_appl.this, clinicpage.class);
                startActivity(intent);
                finish();
            }
        });


        b1.setOnClickListener((View.OnClickListener) this);
        b2.setOnClickListener((View.OnClickListener) this);
        b3.setOnClickListener((View.OnClickListener) this);
        b4.setOnClickListener((View.OnClickListener) this);
    }
    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.bud1:
                i = new Intent(mnu_appl.this, clinicpage.class);
                startActivities(i);
                break;
            case R.id.bud2:
                i = new Intent(mnu_appl.this, Doctor_page.class);
                startActivities(i);
                break;
            case R.id.bud3:
                i = new Intent(mnu_appl.this, Comment_page.class);
                startActivities(i);
                break;
            case R.id.bud4:
                i = new Intent(mnu_appl.this, Servies_page.class);
                startActivities(i);
                break;

        }
    }

    private void startActivities(Intent i) {

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(mnu_appl.this, clinicpage.class);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(mnu_appl.this, Doctor_page.class);
                startActivity(intent);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(mnu_appl.this, Comment_page.class);
                startActivity(intent);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(mnu_appl.this, Servies_page.class);
                startActivity(intent);
            }
        });


    }
}






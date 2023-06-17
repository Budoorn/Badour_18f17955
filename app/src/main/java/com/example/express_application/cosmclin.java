package com.example.express_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class cosmclin extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_mnue, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.logout) {
            startActivity(new Intent(cosmclin.this,MainActivity.class));
        }
        else if (id == R.id.home) {

            startActivity(new Intent(cosmclin.this,mnu_appl.class));
        }
        else if (id == R.id.store) {
            startActivity(new Intent(cosmclin.this,Servies_page.class));
        }


        return super.onOptionsItemSelected(item);
    }


    private Button sta;
    private TextView smu;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosmclin);


        smu=(TextView)  findViewById(R.id.smu);
        smu.setText("9924409");
        Linkify.addLinks(smu,Linkify.PHONE_NUMBERS);

        sta = (Button) findViewById(R.id.click);

        initial();
    }

    private void initial() {

        sta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(cosmclin.this, Cheakout_page.class);
                startActivity(intent);
            }

        });

    }
}

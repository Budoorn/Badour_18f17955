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

public class laclinic extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_mnue, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.logout) {
            startActivity(new Intent(laclinic.this,MainActivity.class));
        }
        else if (id == R.id.home) {

            startActivity(new Intent(laclinic.this,mnu_appl.class));
        }
        else if (id == R.id.store) {
            startActivity(new Intent(laclinic.this,Servies_page.class));
        }


        return super.onOptionsItemSelected(item);
    }


    private Button go;
    private TextView textView5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laclinic);

        textView5=(TextView)  findViewById(R.id.textView5);
        textView5.setText("9260011");
        Linkify.addLinks(textView5,Linkify.PHONE_NUMBERS);

        go = (Button) findViewById(R.id.choose);

        initial();
    }

    private void initial() {

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(laclinic.this, Servies_page.class);
                startActivity(intent);
            }

        });

    }
}
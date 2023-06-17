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

public class kayacli extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_mnue, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.logout) {
            startActivity(new Intent(kayacli.this,MainActivity.class));
        }
        else if (id == R.id.home) {

            startActivity(new Intent(kayacli.this,mnu_appl.class));
        }
        else if (id == R.id.store) {
            startActivity(new Intent(kayacli.this,Servies_page.class));
        }


        return super.onOptionsItemSelected(item);
    }


    private Button get;
    private TextView phone3;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayacli);

        phone3=(TextView)  findViewById(R.id.phone3);
        phone3.setText("8007754");
        Linkify.addLinks(phone3,Linkify.PHONE_NUMBERS);

        get = (Button) findViewById(R.id.gott);

        initial();
    }

    private void initial() {

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(kayacli.this, Kaya_Book.class);
                startActivity(intent);
            }

        });

    }
}

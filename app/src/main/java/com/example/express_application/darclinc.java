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

public class darclinc extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_mnue, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.logout) {
            startActivity(new Intent(darclinc.this,MainActivity.class));
        }
        else if (id == R.id.home) {

            startActivity(new Intent(darclinc.this,mnu_appl.class));
        }
        else if (id == R.id.store) {
            startActivity(new Intent(darclinc.this,Servies_page.class));
        }


        return super.onOptionsItemSelected(item);
    }


    private Button wab;
    private TextView number;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darclinc);

        number=(TextView)  findViewById(R.id.number);
        number.setText("9660033");
        Linkify.addLinks(number,Linkify.PHONE_NUMBERS);

        wab = (Button) findViewById(R.id.want);

        initial();
    }

    private void initial() {

        wab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(darclinc.this, Dermacli_book.class);
                startActivity(intent);
            }

        });

    }
}

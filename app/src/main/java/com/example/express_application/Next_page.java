package com.example.express_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Next_page extends AppCompatActivity {

    Button logb,subm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_page);

        // get the id
        logb=(Button) findViewById(R.id.button2);
        subm=(Button) findViewById(R.id.button3);

        initial();
    }
    private void initial(){

        logb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Next_page.this,First_Page.class);
                startActivity(intent);
            }
        });


        subm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Next_page.this,Signup_app.class);
                startActivity(intent);
            }
        });


    }
}
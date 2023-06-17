package com.example.express_application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_user extends AppCompatActivity {

    private Button costm,adma;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user);

        costm = findViewById(R.id.user);
        adma = findViewById(R.id.admin);


        initial();
    }
    private void initial(){

        costm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Admin_user.this,Next_page.class);
                startActivity(intent);
            }
        });


        adma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Admin_user.this,Adminlogin.class);
                startActivity(intent);
            }
        });


    }
}
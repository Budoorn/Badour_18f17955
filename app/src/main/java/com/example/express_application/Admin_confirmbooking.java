package com.example.express_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Admin_confirmbooking extends AppCompatActivity {

    TextView nameusr, emaileusr;

    RecyclerView recyviewb;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_booking);

        nameusr = findViewById(R.id.nameser);
        emaileusr = findViewById(R.id.emaileusr);
        recyviewb = findViewById(R.id.recyviewb);


        showBookinginfo();
    }

    public void showBookinginfo() {

        Intent intent = getIntent();
        String username = intent.getStringExtra("name");
        String useremail = intent.getStringExtra("email");


        nameusr.setText(username);
        emaileusr.setText(useremail);
    }
    }
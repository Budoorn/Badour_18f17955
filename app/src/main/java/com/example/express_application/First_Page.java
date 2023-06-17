package com.example.express_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class First_Page extends AppCompatActivity {

    private EditText ema, pass;
    private TextView forpass;
    private Button loginb, signup;

    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        auth = FirebaseAuth.getInstance();
        ema = findViewById(R.id.login);
        pass = findViewById(R.id.password);
        forpass = findViewById(R.id.forget);
        loginb = findViewById(R.id.buttonPanel);
        signup = findViewById(R.id.buttonPanel2);

        initial();
    }

    private void initial() {

        forpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(First_Page.this, Pssword_forget.class);
                startActivity(intent);
                finish();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(First_Page.this, Signup_app.class);
                startActivity(intent);
                finish();
            }
        });
        loginb.setOnClickListener(view -> {
        LoginUser();
        });
    }
    private void LoginUser(){
        String email,password;
        email = String.valueOf(ema.getText());
        password = String.valueOf(pass.getText());

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(First_Page.this, "Enter your email ...", Toast.LENGTH_SHORT).show();
            return;
        }else {

        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(First_Page.this, "Enter your password ...", Toast.LENGTH_SHORT).show();
            return;


        } else {
            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(First_Page.this, "User login successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(First_Page.this, mnu_appl.class));
                    } else {
                        Toast.makeText(First_Page.this, "User login not successfully" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}










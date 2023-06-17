package com.example.express_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Notification;
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

public class Signup_app extends AppCompatActivity {

    private EditText nam, emi, passw;

    private TextView accou;

    private Button sign;

    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_app);

        //get id

        nam = (EditText) findViewById(R.id.sign);
        emi = (EditText) findViewById(R.id.sin);
        passw = (EditText) findViewById(R.id.signup);
        sign = (Button) findViewById(R.id.button);
        accou = (TextView) findViewById(R.id.account);
        auth = FirebaseAuth.getInstance();

        initial();
    }

    private void initial() {

        accou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Signup_app.this, First_Page.class);
                startActivity(intent);
                finish();
            }
        });


        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sing, signup;
                sing = String.valueOf(emi.getText());
                signup = String.valueOf(passw.getText());

                if (TextUtils.isEmpty(sing)) {
                    Toast.makeText(Signup_app.this, "Enter your email ...", Toast.LENGTH_SHORT).show();
                    return;
                } else {

                }
                if (TextUtils.isEmpty(signup)) {
                    Toast.makeText(Signup_app.this, "Enter your password ...", Toast.LENGTH_SHORT).show();
                    return;


                } else {
                    auth.createUserWithEmailAndPassword(sing, signup)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Signup_app.this, "User register successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Signup_app.this, First_Page.class));
                                finish();
                            } else {
                                Toast.makeText(Signup_app.this, "User register not successfully" +task.getException().getMessage() , Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}

















package com.example.express_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class Adminlogin extends AppCompatActivity {

    EditText name,passw;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        name = findViewById(R.id.admin_name);
        passw = findViewById(R.id.admin_password);
        login = findViewById(R.id.loginadmin);

       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(name.getText().toString().equals("Admin")&& passw.getText().toString().equals("123123")){
                   Toast.makeText(Adminlogin.this, "Login successfully", Toast.LENGTH_SHORT).show();
                   startActivity(new Intent(Adminlogin.this, edit_admin.class));
               }else {
                   Toast.makeText(Adminlogin.this, "Login failed?", Toast.LENGTH_SHORT).show();
               }
           }
       });

    }
}
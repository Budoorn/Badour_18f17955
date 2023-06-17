package com.example.express_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Pssword_forget extends AppCompatActivity {

    EditText enter;
    Button sendit;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pssword_forget);

        //get the id
        enter = (EditText) findViewById(R.id.textView3);
        sendit = (Button) findViewById(R.id.button4);
        auth = FirebaseAuth.getInstance();


        sendit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        String email;
                        email = String.valueOf(enter.getText());

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Pssword_forget.this, "Enter your email ...", Toast.LENGTH_SHORT).show();
                    return;

                }

                auth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(Pssword_forget.this, "Check your email plas", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Pssword_forget.this, First_Page.class));
                                    finish();
                                }else {
                                    Toast.makeText(Pssword_forget.this, "Email faild", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }


        });


    }
}

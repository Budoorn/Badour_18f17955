package com.example.express_application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Comment;

public class Comment_page extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_mnue, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.logout) {
            startActivity(new Intent(Comment_page.this,MainActivity.class));
        }
        else if (id == R.id.home) {

            startActivity(new Intent(Comment_page.this,mnu_appl.class));
        }
        else if (id == R.id.store) {
            startActivity(new Intent(Comment_page.this,Servies_page.class));
        }


        return super.onOptionsItemSelected(item);
    }


    private EditText com1, namebb;
    private Button send;
    private DatabaseReference reference;
    private FirebaseDatabase data;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_page);


        com1 = (EditText) findViewById(R.id.comments);
        send = (Button) findViewById(R.id.sub_comm);
        namebb = (EditText) findViewById(R.id.nameb);


        user = new User();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                data = FirebaseDatabase.getInstance();
                DatabaseReference reference = data.getReference("Comment");

                String name = namebb.getText().toString();
                String comment = com1.getText().toString();

                User user = new User(name, comment);

                reference.child(name).setValue(user);

                Toast.makeText(Comment_page.this, "comment submit successfully...", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Comment_page.this, submit_comment.class);
                startActivity(intent);


            }
        });


    }


    private void InsertData() {
        user.setName(namebb.getText().toString().trim());
        user.setComment(com1.getText().toString().trim());



    }
    public void add(View view) {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) ;
                com1.setError(null);


                InsertData();

                reference.child("Comment").setValue(user);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }
}























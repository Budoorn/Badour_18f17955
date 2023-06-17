package com.example.express_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.example.express_application.adapter.MyServiceAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Cheakout_page extends AppCompatActivity {

    GridView gridView;
    ArrayList<Servies> list;
    MyServiceAdapter adapter;

    final private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Cosmlinc Serves");



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosmtec_book);

        gridView = findViewById(R.id.gridview);

        list= new ArrayList<>();
        adapter = new MyServiceAdapter(list,this);
        gridView.setAdapter(adapter);


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Servies servies = dataSnapshot.getValue(Servies.class);
                    list.add(servies);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_mnue, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.logout) {
            startActivity(new Intent(Cheakout_page.this, MainActivity.class));
        } else if (id == R.id.home) {

            startActivity(new Intent(Cheakout_page.this, mnu_appl.class));
        } else if (id == R.id.store) {
            startActivity(new Intent(Cheakout_page.this, Servies_page.class));
        }


        return super.onOptionsItemSelected(item);
    }
}





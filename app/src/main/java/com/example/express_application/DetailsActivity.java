package com.example.express_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class DetailsActivity extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_mnue, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.logout) {
            startActivity(new Intent(DetailsActivity.this, MainActivity.class));
        } else if (id == R.id.home) {

            startActivity(new Intent(DetailsActivity.this, mnu_appl.class));
        } else if (id == R.id.store) {
            startActivity(new Intent(DetailsActivity.this, Servies_page.class));
        }


        return super.onOptionsItemSelected(item);
    }


    TextView detailsname, detailsprice, detail;
    ImageView detailiamg;
    Button Book;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        detailsname = findViewById(R.id.detailsname);
        detailsprice = findViewById(R.id.detailsprice);
        detail = findViewById(R.id.detail);
        detailiamg = findViewById(R.id.detailiamg);
        Book = findViewById(R.id.Booking);


        initial();
    }

    private void initial() {

        Book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(DetailsActivity.this, Booking_page.class);
                startActivity(intent);
            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            detailsname.setText(bundle.getString("name"));
            detailsprice.setText(bundle.getString("Price"));
            detail.setText(bundle.getString("Description"));
            Glide.with(this).load(bundle.getString("image")).into(detailiamg);
        }
    }
        }


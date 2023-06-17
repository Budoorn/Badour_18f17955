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
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Confirm_Booking extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_mnue, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.logout) {
            startActivity(new Intent(Confirm_Booking.this, MainActivity.class));
        } else if (id == R.id.home) {

            startActivity(new Intent(Confirm_Booking.this, mnu_appl.class));
        } else if (id == R.id.store) {
            startActivity(new Intent(Confirm_Booking.this, Servies_page.class));
        }


        return super.onOptionsItemSelected(item);
    }



    TextView confirmName, confirmEmail,confirmphone,confirmNDate,confirmNServies;

    Button confirm;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_booking);

        confirmName = findViewById(R.id.confirmName);
        confirmEmail = findViewById(R.id.confirmEmail);
        confirmphone = findViewById(R.id.confirmphone);
        confirmNDate = findViewById(R.id.confirmNDate);
        confirmNServies = findViewById(R.id.confirmNServies);
        confirm= findViewById(R.id.confirm);


        initial();
    }
    private void initial(){

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Confirm_Booking.this,Done_Booking.class);
                startActivity(intent);
            }
        });


     showBookinginfo();
    }

    public void showBookinginfo(){

        Intent intent= getIntent();
        String username = intent.getStringExtra("name");
        String useremail = intent.getStringExtra("email");
        String nmphone = intent.getStringExtra("phone");
        String sedate = intent.getStringExtra("date");
        String setservice = intent.getStringExtra("service");


        confirmName.setText(username);
        confirmEmail.setText(useremail);
        confirmphone.setText(nmphone);
        confirmNDate.setText(sedate);
        confirmNServies.setText(setservice);

    }



}
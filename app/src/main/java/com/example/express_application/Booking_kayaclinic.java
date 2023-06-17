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
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Booking_kayaclinic extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_mnue, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.logout) {
            startActivity(new Intent(Booking_kayaclinic.this, MainActivity.class));
        } else if (id == R.id.home) {

            startActivity(new Intent(Booking_kayaclinic.this, mnu_appl.class));
        } else if (id == R.id.store) {
            startActivity(new Intent(Booking_kayaclinic.this, Servies_page.class));
        }


        return super.onOptionsItemSelected(item);
    }


    EditText bname, booking_email, booking_phone, booking_data,booking_serves;
    Button bookpag;
    FirebaseDatabase database;
    DatabaseReference reference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_page);

        bname = findViewById(R.id.bname);
        booking_email = findViewById(R.id.booking_email);
        booking_phone = findViewById(R.id.booking_phone);
        booking_data = findViewById(R.id.booking_data);
        booking_serves = findViewById(R.id.booking_serves);
        bookpag = findViewById(R.id.bookpag);

        bookpag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("Book Kaya clinic");

                String name = bname.getText().toString();
                String email = booking_email.getText().toString();
                String phone = booking_phone.getText().toString();
                String date = booking_data.getText().toString();
                String service = booking_serves.getText().toString();


                Bookinginfo bookinginfo = new Bookinginfo(name,email,phone,date,service);
                reference.child(name).setValue(bookinginfo);

                Toast.makeText(Booking_kayaclinic.this, "confirm your Booking", Toast.LENGTH_SHORT).show();




                Intent intent = new Intent(Booking_kayaclinic.this,Confirm_Booking.class);

                intent.putExtra("name",name);
                intent.putExtra("email",email);
                intent.putExtra("phone",phone);
                intent.putExtra("date",date);
                intent.putExtra("service",service);

                startActivity(intent);



            }
        });
    }
}

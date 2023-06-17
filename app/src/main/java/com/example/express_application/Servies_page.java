package com.example.express_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.express_application.adapter.MyServiceAdapter;
import com.example.express_application.listenerr.ICartLoadListenerr;
import com.example.express_application.listenerr.IServiesLoadListenerr;
import com.example.express_application.model.CartModel;
import com.example.express_application.model.ServiceModel;
import com.example.express_application.utils.SpaceItemDecoration;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Servies_page extends AppCompatActivity {

    GridView gridView;
    ArrayList<Servies> list;
    MyAdapter adapter;

    final private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Servies");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servies_page);

        gridView = findViewById(R.id.gridview);

        list= new ArrayList<>();
        adapter = new MyAdapter(list,this);
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
            startActivity(new Intent(Servies_page.this, MainActivity.class));
        } else if (id == R.id.home) {

            startActivity(new Intent(Servies_page.this, mnu_appl.class));
        } else if (id == R.id.store) {
            startActivity(new Intent(Servies_page.this, Servies_page.class));
        }


        return super.onOptionsItemSelected(item);
    }
}
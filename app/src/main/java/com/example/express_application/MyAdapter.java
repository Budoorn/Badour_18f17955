package com.example.express_application;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private  ArrayList<Servies> list;

    private Context context;

    LayoutInflater layoutInflater;

    public MyAdapter(ArrayList<Servies> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @SuppressLint("ServiceCast")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (layoutInflater == null){
            layoutInflater = (LayoutInflater)  context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null){
            view= layoutInflater.inflate(R.layout.layout_service_item,null);
        }
        ImageView gridiamg = view.findViewById(R.id.gridiamg);
        TextView nameser = view.findViewById(R.id.nameser);
        TextView priceser = view.findViewById(R.id.priceser);
        CardView recCard = view.findViewById(R.id.recCard);


        Glide.with(context).load(list.get(i).getImage()).into(gridiamg);

        recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetailsActivity.class);
                intent.putExtra("image",list.get(i).getImage());
                intent.putExtra("name",list.get(i).getName());
                intent.putExtra("Price",list.get(i).getPrice());
                intent.putExtra("Description",list.get(i).getDescription());
                context.startActivity(intent);
            }

        });


        nameser.setText(list.get(i).getName());

        priceser.setText(list.get(i).getPrice());
        return view;
    }
}
package com.example.express_application.adapter;

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
import com.example.express_application.DetailsActivity;
import com.example.express_application.DetailsCosmlinc;
import com.example.express_application.Detils_Kaya;
import com.example.express_application.R;
import com.example.express_application.Servies;
import com.example.express_application.model.ServiceModel;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MyServiceAdapter extends BaseAdapter {

    private ArrayList<Servies> list;

    private Context context;

    LayoutInflater layoutInflater;

    public MyServiceAdapter(ArrayList<Servies> list, Context context) {
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
                Intent intent = new Intent(context, DetailsCosmlinc.class);
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


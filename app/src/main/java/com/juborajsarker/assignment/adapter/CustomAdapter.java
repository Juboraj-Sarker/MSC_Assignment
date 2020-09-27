package com.juborajsarker.assignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.juborajsarker.assignment.R;
import com.juborajsarker.assignment.model.Bike;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private List<Bike> bikeList;
    private RecyclerView recyclerView;

    public CustomAdapter(Context context, List<Bike> bikeList, RecyclerView recyclerView) {
        this.context = context;
        this.bikeList = bikeList;
        this.recyclerView = recyclerView;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView ivBike;
        TextView tvBikeName, tvBrandName, tvBrandOrigin, tvPrice;

        public MyViewHolder(@NonNull View view) {
            super(view);
            ivBike = (ImageView) view.findViewById(R.id.iv_bike);
            tvBikeName = (TextView) view.findViewById(R.id.tv_bike_name);
            tvBrandName = (TextView) view.findViewById(R.id.tv_brand_name);
            tvBrandOrigin = (TextView) view.findViewById(R.id.tv_brand_origin);
            tvPrice = (TextView) view.findViewById(R.id.tv_price);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_bike, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Bike bike = bikeList.get(position);

        holder.tvBikeName.setText(bike.getBikeName());
        holder.tvBrandName.setText(bike.getBrandName());
        holder.tvBrandOrigin.setText(bike.getBrandOrigin());
        holder.tvPrice.setText(String.valueOf(bike.getPrice()));
        holder.ivBike.setImageDrawable(ContextCompat.getDrawable(context, bike.getImageID()));
    }

    @Override
    public int getItemCount() {
        return bikeList.size();
    }
}

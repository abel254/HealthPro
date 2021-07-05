package com.example.healthpro;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewSummary extends RecyclerView.Adapter<RecyclerViewSummary.MyViewHolder> {
    private Context mContext;
    private List<Food> foodList;

    String proteins, carbs, fats, calories;
    Double proteins_d, carbs_d, fats_d, calories_d;
    Double proteins_c, carbs_c, fats_c, calories_c;
    int cartEditText_d;

    public RecyclerViewSummary(Context mContext, List<Food> foodList) {
        this.mContext = mContext;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.listitem, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Food foodItem = foodList.get(position);

        holder.foodName_summary.setText(foodItem.getName());
        holder.image_summary.setImageResource(foodItem.getImage());
        holder.calories_summary.setText(foodItem.getCalories());

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView foodName_summary, calories_summary;
        ImageView image_summary;
        Button viewFoodValue;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            foodName_summary = itemView.findViewById(R.id.foodname_summary);
            calories_summary = itemView.findViewById(R.id.calories_summary);
            image_summary = itemView.findViewById(R.id.image_summary);
            viewFoodValue = itemView.findViewById(R.id.view_summarydata);
        }
    }
}

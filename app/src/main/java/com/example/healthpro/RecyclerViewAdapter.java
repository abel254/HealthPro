package com.example.healthpro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<Food> foodList;

    public RecyclerViewAdapter(Context mContext, List<Food> foodList) {
        this.mContext = mContext;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_food, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Food foodItem = foodList.get(position);

        holder.tv_food_title.setText(foodItem.getName());
        holder.img_food_thumbnail.setImageResource(foodItem.getImage());

        holder.cardView_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Food foodItem = foodList.get(position);
                Intent intent = new Intent(mContext, InfoActivity.class);
                intent.putExtra("proteins", foodItem.getProteins());
                intent.putExtra("carbs", foodItem.getCarbs());
                intent.putExtra("fats", foodItem.getFats());
                intent.putExtra("calories", foodItem.getCalories());
                intent.putExtra("image", foodItem.getImage());
                intent.putExtra("name", foodItem.getName());
                mContext.startActivity(intent);
                ((FoodList)mContext).finish();
            }
        });

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_food_title;
        ImageView img_food_thumbnail;
        CardView cardView_food;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_food_title = itemView.findViewById(R.id.food_title_id);
            img_food_thumbnail = itemView.findViewById(R.id.food_img_id);
            cardView_food = itemView.findViewById(R.id.cardview_fooditem);


        }
    }
}

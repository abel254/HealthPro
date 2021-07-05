package com.example.healthpro.Exercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthpro.R;

import java.util.List;

public class RecyclerViewSummaryExercise extends RecyclerView.Adapter<RecyclerViewSummaryExercise.MyViewHolder> {
    private Context mContext;
    private List<Exercise> exerciseList;

    public RecyclerViewSummaryExercise(Context mContext, List<Exercise> exerciseList) {
        this.mContext = mContext;
        this.exerciseList = exerciseList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.listitem, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(exerciseList.get(position).getName());
        holder.calories.setText(exerciseList.get(position).getCalories());
        holder.image.setImageResource(exerciseList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, calories;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.foodname_summary);
            calories = itemView.findViewById(R.id.calories_summary);
            image = itemView.findViewById(R.id.image_summary);
        }
    }
}

package com.example.healthpro.Exercise;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthpro.R;
import com.example.healthpro.SummaryCart;

import java.util.List;

public class RecyclerViewExercise extends RecyclerView.Adapter<RecyclerViewExercise.MyViewHolder> {
   private Context mContext;
   private List<Exercise> exercises;


    public RecyclerViewExercise(Context mContext, List<Exercise> exercises) {
        this.mContext = mContext;
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.exercise_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Exercise exerciseItem = exercises.get(position);

        holder.exercise_name.setText(exerciseItem.getName());
        holder.exercise_calories.setText(exerciseItem.getDescription());
        holder.exercise_image.setImageResource(exerciseItem.getImage());

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, InfoExercise.class);
                intent.putExtra("exname", exerciseItem.getName());
                intent.putExtra("description", exerciseItem.getDescription());
                intent.putExtra("calories", exerciseItem.getCalories());
                intent.putExtra("image", exerciseItem.getImage());
                mContext.startActivity(intent);
                ((ExerciseActivity)mContext).finish();

            }
        });
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView exercise_name, exercise_calories;
        ImageView exercise_image;
        RelativeLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            exercise_name = itemView.findViewById(R.id.exercise_name);
            exercise_calories = itemView.findViewById(R.id.exercise_description);
            exercise_image = itemView.findViewById(R.id.exerces_image);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}

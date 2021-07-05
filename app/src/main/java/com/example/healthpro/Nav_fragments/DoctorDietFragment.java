package com.example.healthpro.Nav_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.healthpro.Exercise.ExerciseActivity;
import com.example.healthpro.FoodList;
import com.example.healthpro.R;
import com.example.healthpro.SummaryCart;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import static java.lang.String.format;

public class DoctorDietFragment extends Fragment {
    private CardView breakfast_cardview, lunch_cardview, dinner_cardview, activity_cardview, today_food;
    private TextView proteins_cont, carbs_cont, fats_cont, calories_cont;
    private TextView proteins_p, carbs_p, fats_p;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doctordiet, container, false);

        breakfast_cardview = view.findViewById(R.id.breakfast_cardview);
        lunch_cardview = view.findViewById(R.id.lunch_cardview);
        dinner_cardview = view.findViewById(R.id.dinner_cardview);
        activity_cardview = view.findViewById(R.id.activity_cardview);
        today_food = view.findViewById(R.id.today_foods);

        proteins_cont = view.findViewById(R.id.protein_cont);
        carbs_cont = view.findViewById(R.id.carbs_cont);
        fats_cont = view.findViewById(R.id.fats_cont);
        calories_cont = view.findViewById(R.id.calories_cont);

        proteins_p = view.findViewById(R.id.proteins_perc);
        carbs_p = view.findViewById(R.id.carbs_perc);
        fats_p = view.findViewById(R.id.fats_perc);

        getData();


        today_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SummaryCart.class);
                startActivity(intent);
            }
        });
        breakfast_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FoodList.class);
                startActivity(intent);
            }
        });

        lunch_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FoodList.class);
                startActivity(intent);

            }
        });

        dinner_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FoodList.class);
                startActivity(intent);
                //((HealthProMain)getContext()).finish();
            }
        });

        activity_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ExerciseActivity.class);
                startActivity(intent);
            }
        });
        return view;


    }

    public void getData(){
        Intent intent = getActivity().getIntent();
        String proteins = intent.getStringExtra("totalProteins");
        String carbs = intent.getStringExtra("totalCarbs");
        String fats = intent.getStringExtra("totalFats");
        String calories = intent.getStringExtra("totalCalories");




        if (proteins == null || carbs == null || fats == null || calories == null){

        }else {
            Double proteins_float = Double.parseDouble(proteins);
            Double carbs_float = Double.parseDouble(carbs);
            Double fats_float = Double.parseDouble(fats);
            Double calories_float = Double.parseDouble(calories);

            proteins_cont.setText(String.format("%.1f", proteins_float));
            carbs_cont.setText(String.format("%.1f", carbs_float));
            fats_cont.setText(String.format("%.1f", fats_float));
            calories_cont.setText(String.format("%.1f", calories_float));

            Double proteins_perc = (100 * proteins_float)/(proteins_float + carbs_float + fats_float);

            Double carbs_perc = (100 * carbs_float)/(proteins_float + carbs_float + fats_float);
            Double fats_perc = (100 * fats_float)/(proteins_float + carbs_float + fats_float);


            proteins_p.setText(String.format("%.1f", proteins_perc));
            carbs_p.setText(String.format("%.1f", carbs_perc));
            fats_p.setText(String.format("%.1f", fats_perc));
        }

    }

}
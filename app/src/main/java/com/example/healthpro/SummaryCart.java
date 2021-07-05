package com.example.healthpro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.healthpro.Exercise.DatabaseHelperExercise;
import com.example.healthpro.Exercise.Exercise;
import com.example.healthpro.Exercise.RecyclerViewSummaryExercise;

import java.util.ArrayList;
import java.util.List;

public class SummaryCart extends AppCompatActivity {
    ArrayList<Food> list;
    RecyclerView recyclerView, recyclerView2;
    DatabaseHelper databaseHelper;
    RecyclerViewSummary adapter;
    Button viewSummary, clearFoodList;

    ArrayList<Exercise> exercises;
    DatabaseHelperExercise databaseHelperExercise;
    RecyclerViewSummaryExercise adapter2;

    String name, proteins, carbs, fats, calories;
    Double proteins_d, carbs_d, fats_d, calories_d;
    Double totalCalories = 0.0;
    Double totalProteins = 0.0;
    Double totalCarbs = 0.0;
    Double totalFats = 0.0;
    int image, image1;

    String name1, description, calories1;
    Double calories1_d;
    Double totalCalories1 = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_cart);

        viewSummary = findViewById(R.id.view_summarydata);
        clearFoodList = findViewById(R.id.clear_foodlist);

        recyclerView = findViewById(R.id.recyclerview_summary);
        recyclerView2 = findViewById(R.id.recyclerview_exercise);

        list = new ArrayList<>();
        adapter = new RecyclerViewSummary(this, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        databaseHelper = new DatabaseHelper(this, "FoodDB_CART.sqlite", null, 1);

        Cursor cursor = databaseHelper.getData("SELECT * FROM FOOD");
        list.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            name = cursor.getString(1);
            proteins = cursor.getString(2);
            carbs = cursor.getString(3);
            fats = cursor.getString(4);
            calories = cursor.getString(5);
            image = cursor.getInt(6);

            list.add(new Food(id, name, proteins, carbs, fats, calories, image));
        }


        exercises = new ArrayList<>();
        adapter2 = new RecyclerViewSummaryExercise(this, exercises);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setAdapter(adapter2);

        databaseHelperExercise = new DatabaseHelperExercise(this, "ActivitySummary.sqlite", null, 1);

        Cursor cursor1 = databaseHelperExercise.getData("SELECT * FROM EXERCISE");
        exercises.clear();
        while (cursor1.moveToNext()){
            int id = cursor1.getInt(0);
            name1 = cursor1.getString(1);
            description = cursor1.getString(2);
            calories1 = cursor1.getString(3);
            image1 = cursor1.getInt(4);

            exercises.add(new Exercise(id, name1, description,calories1, image1));
        }



        if (proteins == null || carbs == null || fats == null || calories == null){

        }else {


            for (int i = 0; i < list.size(); i++){
                totalCalories += Double.parseDouble(list.get(i).getCalories());

            }


            for (int i = 0; i < list.size(); i++){
                totalProteins += Double.parseDouble(list.get(i).getProteins());
            }

            for (int i = 0; i < list.size(); i++){
                totalCarbs += Double.parseDouble(list.get(i).getCarbs());
            }

            for (int i = 0; i < list.size(); i++){
                totalFats += Double.parseDouble(list.get(i).getFats());
            }

        }


        if (calories1 == null){

        }else {
            calories1_d = Double.parseDouble(calories1);

            for (int i = 0; i < exercises.size(); i++){
                totalCalories1 += Double.parseDouble(exercises.get(i).getCalories());
            }
        }

        totalCalories = totalCalories - totalCalories1;



        viewSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SummaryCart.this, HealthProMain.class);
                intent.putExtra("totalCalories", totalCalories.toString());
                intent.putExtra("totalProteins", totalProteins.toString());
                intent.putExtra("totalCarbs", totalCarbs.toString());
                intent.putExtra("totalFats", totalFats.toString());
                startActivity(intent);
                finish();
            }
        });

        clearFoodList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.deleteAll();
                databaseHelperExercise.deleteAll();
                finish();
            }
        });

    }

}

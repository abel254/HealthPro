package com.example.healthpro.Exercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.example.healthpro.R;

import java.util.ArrayList;

public class ExerciseActivity extends AppCompatActivity {
    ArrayList<Exercise> exercises;
    RecyclerView recyclerView;
    DatabaseHelperExercise databaseHelperExercise;
    RecyclerViewExercise adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        databaseHelperExercise = new DatabaseHelperExercise(this, "Activity.sqlite", null, 1);
        databaseHelperExercise.queryData("CREATE TABLE IF NOT EXISTS EXERCISE (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, description VARCHAR, calories VARCHAR, image INTEGER)");

        recyclerView = findViewById(R.id.exercise_recyclerview);
        exercises = new ArrayList<>();
        adapter = new RecyclerViewExercise(this, exercises);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        //saveData();

        Cursor cursor = databaseHelperExercise.getData("SELECT * FROM EXERCISE");
        exercises.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String description = cursor.getString(2);
            String calories = cursor.getString(3);
            int image = cursor.getInt(4);

            exercises.add(new Exercise(id, name, description, calories, image));
        }

    }

    public void saveData(){

        databaseHelperExercise.insertData("Brisk Walking", "4 Cal/min", "4", R.drawable.walking);
        databaseHelperExercise.insertData("Walking Uphill", "5.7 Cal/min", "5.7", R.drawable.uphill);
        databaseHelperExercise.insertData("Jogging", "9.8 Cal/min", "9.8", R.drawable.jogging);
        databaseHelperExercise.insertData("Running", "11.4 Cal/min", "11.4", R.drawable.runing);
        databaseHelperExercise.insertData("Bicycling", "11.9 Cal/min", "11.9", R.drawable.bicycling);
        databaseHelperExercise.insertData("Push ups", "7 Cal/min", "7", R.drawable.push_ups);
        databaseHelperExercise.insertData("Sit ups", "3 Cal per min", "3", R.drawable.sit_ups);
        databaseHelperExercise.insertData("Jumping Jacks", "8 Cal/min", "8", R.drawable.jumping_jacks);
        databaseHelperExercise.insertData("Aerobic dancing", "7.6 Cal/min", "7.6", R.drawable.aerobic_dancing);
        databaseHelperExercise.insertData("Jumping Rope", "17 Cal/min", "17", R.drawable.jumping_rope);
        databaseHelperExercise.insertData("weight lifting, body building", "12.6 Cal/min", "12.6", R.drawable.weight);
        databaseHelperExercise.insertData("Swimming", "14.8 Cal/min", "14.8", R.drawable.swimming);
        databaseHelperExercise.insertData("Paddle boating", "8.6 Cal/min", "8.6", R.drawable.paddle_boating);
        databaseHelperExercise.insertData("Rowing canoe", "6.7 Cal per min", "6.7", R.drawable.rowing_canoe);
        databaseHelperExercise.insertData("Skin diving", "7.5 Cal/min", "7.5", R.drawable.skin_diving);
        databaseHelperExercise.insertData("Fishing and Hunting", "5 Cal/min", "5", R.drawable.fishing);
        databaseHelperExercise.insertData("Horse back riding - trotting or galloping", "7.9 Cal/min", "7.9", R.drawable.horse_riding);
        databaseHelperExercise.insertData("sports rugby, Field Hockey and soccer", "8.8 Cal/min", "8.8", R.drawable.sporting);
        databaseHelperExercise.insertData("Mountain biking", "13 Cal/min", "13", R.drawable.mountain_biking);
        databaseHelperExercise.insertData("Ice Skating", "10 Cal/min", "10", R.drawable.ice_skating);
    }
}

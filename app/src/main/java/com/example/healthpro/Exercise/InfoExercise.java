package com.example.healthpro.Exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healthpro.R;
import com.example.healthpro.SummaryCart;

public class InfoExercise extends AppCompatActivity {
    ImageView exerciseImage;
    TextView exerciseName;
    EditText exerciseEditText;
    Button exerciseAddButton;

    String name, description, calories, calories_s;
    Double calories_d, calories_c;
    int image, editText_d;

    DatabaseHelperExercise databaseHelperExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_exercise);

        databaseHelperExercise = new DatabaseHelperExercise(this, "ActivitySummary.sqlite", null, 1);
        databaseHelperExercise.queryData("CREATE TABLE IF NOT EXISTS EXERCISE (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, description VARCHAR, calories VARCHAR, image INTEGER)");

        exerciseImage = findViewById(R.id.exercise_imageview);
        exerciseName = findViewById(R.id.exercise_textView);
        exerciseEditText = findViewById(R.id.exercise_edittext);
        exerciseAddButton = findViewById(R.id.exercise_addButton);

        Intent intent = getIntent();
        name =  intent.getStringExtra("exname");
        calories = intent.getStringExtra("calories");
        description = intent.getStringExtra("description");
        image = intent.getExtras().getInt("image");

        exerciseImage.setImageResource(image);
        exerciseName.setText(name);

        exerciseAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calories == null){

                }else {
                    calories_d = Double.parseDouble(calories);
                    editText_d = Integer.parseInt(exerciseEditText.getText().toString());

                    calories_c = calories_d * editText_d;
                }
                calories_s = String.valueOf(calories_c);

                databaseHelperExercise.insertData(name, description, calories_s, image);

                Intent intent = new Intent(InfoExercise.this, SummaryCart.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

package com.example.healthpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InfoActivity extends AppCompatActivity {
    ImageView cartImageView;
    TextView cartFoodName;
    EditText cartEditText;
    Button cartAddButton;

    String proteins, carbs, fats, calories, name;
    Double proteins_d, carbs_d, fats_d, calories_d;
    Double proteins_c, carbs_c, fats_c, calories_c;
    String  proteins_s, carbs_s, fats_s, calories_s;
    int image, cartEditText_d;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        databaseHelper = new DatabaseHelper(this, "FoodDB_CART.sqlite", null, 1);
        databaseHelper.queryData("CREATE TABLE IF NOT EXISTS FOOD (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, proteins VARCHAR, carbs VARCHAR, fats VARCHAR, calories VARCHAR, image INTEGER)");


        cartImageView = findViewById(R.id.cart_imageview);
        cartFoodName = findViewById(R.id.cart_foodname);
        cartEditText = findViewById(R.id.cart_edittext);
        cartAddButton = findViewById(R.id.cart_addButton);


        cartFoodName.setText("Orange");

        Intent intent = getIntent();
        proteins = intent.getStringExtra("proteins");
        carbs = intent.getStringExtra("carbs");
        fats = intent.getStringExtra("fats");
        calories = intent.getStringExtra("calories");
        image = intent.getExtras().getInt("image");
        name = intent.getStringExtra("name");

        cartImageView.setImageResource(image);
        cartFoodName.setText(name);



        cartAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //cartEditText_d = Integer.parseInt(cartEditText.getText().toString());

                if (proteins == null || carbs == null || fats == null || calories == null){

                }else {
                    proteins_d = Double.parseDouble(proteins);
                    carbs_d = Double.parseDouble(carbs);
                    fats_d = Double.parseDouble(fats);
                    calories_d = Double.parseDouble(calories);

                    if (cartEditText == null){
                        Toast.makeText(getApplicationContext(), "empty grams field", Toast.LENGTH_LONG).show();
                    }else {
                        cartEditText_d = Integer.parseInt(cartEditText.getText().toString());

                        proteins_c = (proteins_d * cartEditText_d)/100;
                        carbs_c = (carbs_d * cartEditText_d)/100;
                        fats_c = (fats_d * cartEditText_d)/100;
                        calories_c = (calories_d * cartEditText_d)/100;
                    }

                    proteins_s = String.valueOf(proteins_c);
                    carbs_s = String.valueOf(carbs_c);
                    fats_s = String.valueOf(fats_c);
                    calories_s = String.valueOf(calories_c);

                }

                databaseHelper.insertData(name, proteins_s, carbs_s, fats_s, calories_s, image);


               Intent intent = new Intent(InfoActivity.this, SummaryCart.class);
               startActivity(intent);
               finish();
            }
        });



    }
}

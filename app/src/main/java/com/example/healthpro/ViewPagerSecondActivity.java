package com.example.healthpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewPagerSecondActivity extends AppCompatActivity {
    ImageView mainImageView;
    TextView title, desc;

    String data1, data2;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_second);

        mainImageView = findViewById(R.id.image_second_layout);
        title = findViewById(R.id.title);
        desc = findViewById(R.id.desc);

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("myImage")&&getIntent().hasExtra("data1")&&getIntent().hasExtra("data2")){
            myImage = getIntent().getIntExtra("myImage", 1);
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
        }
    }

    private void setData(){
        title.setText(data1);
        desc.setText(data2);
        mainImageView.setImageResource(myImage);
    }
}

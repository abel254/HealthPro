package com.example.healthpro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class FoodList extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.food_viewpager);
        FoodViewPagerAdapter adapter = new FoodViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new FragmentFruitsAndVegetables(), "Fruits & Vegetables");
        adapter.AddFragment(new FragmentCarbohydrates(), "Carbs");
        adapter.AddFragment(new FragmentProteins(), "Proteins");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}

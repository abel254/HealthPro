package com.example.healthpro;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentCarbohydrates extends Fragment {
    View view;
    ArrayList<Food> list;
    RecyclerView recyclerView;
    DatabaseHelper databaseHelper;
    RecyclerViewAdapter adapter;

    public FragmentCarbohydrates() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.carbohydrates_fragment, container, false);

        databaseHelper = new DatabaseHelper(getContext(), "FoodDB_CARB.sqlite", null, 1);
        databaseHelper.queryData("CREATE TABLE IF NOT EXISTS FOOD (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, proteins VARCHAR, carbs VARCHAR, fats VARCHAR, calories VARCHAR, image INTEGER)");

        //saveData();

        recyclerView = view.findViewById(R.id.carbohydrates_recycler);
        list = new ArrayList<>();
        adapter = new RecyclerViewAdapter(getContext(), list);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setAdapter(adapter);

        Cursor cursor = databaseHelper.getData("SELECT * FROM FOOD");
        list.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String proteins = cursor.getString(2);
            String carbs = cursor.getString(3);
            String fats = cursor.getString(4);
            String calories = cursor.getString(5);
            int image = cursor.getInt(6);

            list.add(new Food(id, name, proteins, carbs, fats, calories, image));
        }

        return view;
    }

    public void saveData(){
        databaseHelper.insertData("brown rice", "7.9","77", "2.9", "370", R.drawable.brown_rice);
        databaseHelper.insertData("buckwheat", "13","72", "3.4", "343", R.drawable.buckwheat);
        databaseHelper.insertData("popcorn", "5.6","33.8", "0.4", "151", R.drawable.porpcon);
        databaseHelper.insertData("millet", "6","41", "1.7", "207", R.drawable.millet);
        databaseHelper.insertData("maize", "3.2","19", "1.2", "207", R.drawable.maize);
        databaseHelper.insertData("oats", "11","60", "8", "374", R.drawable.oats);

    }
}

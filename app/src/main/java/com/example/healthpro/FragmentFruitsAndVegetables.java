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
import java.util.List;

public class FragmentFruitsAndVegetables extends Fragment {
    View view;
    ArrayList<Food> list;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    DatabaseHelper databaseHelper;

    public FragmentFruitsAndVegetables() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fruitsandvegetables_fragment, container, false);

        databaseHelper = new DatabaseHelper(getContext(), "FoodDB_FV.sqlite", null, 1);
        databaseHelper.queryData("CREATE TABLE IF NOT EXISTS FOOD (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, proteins VARCHAR, carbs VARCHAR, fats VARCHAR, calories VARCHAR, image INTEGER)");

        //saveData();

        recyclerView = view.findViewById(R.id.fruitandvegetable_recycler);
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
        databaseHelper.insertData("orange", "0.9","11.8", "0.1", "47", R.drawable.orange);
        databaseHelper.insertData("grape fruit", "1","13", "0.1", "42", R.drawable.grapefruit);
        databaseHelper.insertData("mandarin", "0.7","12", "0.3", "53", R.drawable.mandarins);
        databaseHelper.insertData("lettuce", "0.6","1.5", "0.1", "8", R.drawable.lettuce);
        databaseHelper.insertData("spinach", "2.9","3.6", "0.4", "23", R.drawable.spinach);
        databaseHelper.insertData("sliverbeet", "3.2","3.7", "0.2", "19", R.drawable.silverbeet);
        databaseHelper.insertData("cabbage", "1","0", "0", "22", R.drawable.cabbage);
        databaseHelper.insertData("cauliflower", "1.9","5", "0.3", "25", R.drawable.cauliflower);
        databaseHelper.insertData("lime", "0.5","7", "0.1", "20", R.drawable.lime);
        databaseHelper.insertData("nectrine", "1.1","11", "0.3", "44", R.drawable.netrine);
        databaseHelper.insertData("apricots", "1.4","11", "0.4", "48", R.drawable.apricots);
        databaseHelper.insertData("peaches", "0.9","10", "0.3", "39", R.drawable.peach);
        databaseHelper.insertData("onion", "1.1","9.3", "0.1", "39", R.drawable.onion);

    }
}

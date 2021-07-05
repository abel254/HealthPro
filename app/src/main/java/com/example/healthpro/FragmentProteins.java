package com.example.healthpro;

import android.content.Intent;
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

public class FragmentProteins extends Fragment {
    View view;
    ArrayList<Food> list;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    DatabaseHelper databaseHelper;

    public FragmentProteins() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.proteins_fragment, container, false);

        databaseHelper = new DatabaseHelper(getContext(), "FoodDB_PRO.sqlite", null, 1);
        databaseHelper.queryData("CREATE TABLE IF NOT EXISTS FOOD (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, proteins VARCHAR, carbs VARCHAR, fats VARCHAR, calories VARCHAR, image INTEGER)");

        //saveData();

        recyclerView = view.findViewById(R.id.proteins_recycler);
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
        databaseHelper.insertData("egg", "12","0.6", "5", "156", R.drawable.egg);
        databaseHelper.insertData("gamalost_cheese", "50","1", "1", "213", R.drawable.gamalost_cheese);
        databaseHelper.insertData("beef", "26","0", "11.8", "217", R.drawable.beef);
        databaseHelper.insertData("pork", "25.7","0", "20.8", "297", R.drawable.pork);
        databaseHelper.insertData("green peas", "5","14", "0.4", "81", R.drawable.green_peas);
        databaseHelper.insertData("lamb", "25","0", "21", "294", R.drawable.lamb_meat);
        databaseHelper.insertData("veal", "24","0", "8", "172", R.drawable.veal);
        databaseHelper.insertData("kangaroo", "22","0", "1", "98", R.drawable.kangaroo);
        databaseHelper.insertData("chicken", "27","0", "14", "239", R.drawable.chicken);
        databaseHelper.insertData("turkey", "29","0.1", "7", "189", R.drawable.turkey);
        databaseHelper.insertData("duck", "19","0", "28", "337", R.drawable.duck);
        databaseHelper.insertData("emu", "25.5","0", "1.9", "120", R.drawable.emu);
        databaseHelper.insertData("goose", "29","0", "13", "238", R.drawable.goose);
        databaseHelper.insertData("fish", "22","0", "12", "206", R.drawable.fish);
        databaseHelper.insertData("prawns", "24","0.2", "0.3", "99", R.drawable.prawn);
        databaseHelper.insertData("crab", "19","0", "1.5", "97", R.drawable.crab);
        databaseHelper.insertData("lobster", "19","0", "0.9", "98", R.drawable.lobster);
        databaseHelper.insertData("mussels", "24","7", "4.5", "172", R.drawable.mussels);
    }
}

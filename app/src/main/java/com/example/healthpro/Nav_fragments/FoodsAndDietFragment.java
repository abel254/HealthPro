package com.example.healthpro.Nav_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.healthpro.R;
import com.example.healthpro.ViewPagerAdapter;
import com.example.healthpro.ViewPagerModel;

import java.util.ArrayList;
import java.util.List;

public class FoodsAndDietFragment extends Fragment {
    ViewPager viewPager, viewPager1, viewPager2, viewPager3;
    ViewPagerAdapter adapter, adapter1, adapter2, adapter3;
    List<ViewPagerModel>models, models1, models2, models3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_foodsanddiet, container, false);

        models = new ArrayList<>();
        models.add(new ViewPagerModel(R.drawable.fatty_fish, "fatty fish", "Salmon, sardines, herring anchovies and mackel are great sources of the omega-3 fatty acids DHA and EPA. Omega-3 fats help reduce inflamatio and other risk factors for heart diseases and stroke. They are source of proteins which are important for blood sugar regulation"));
        models.add(new ViewPagerModel(R.drawable.avocado, "avocado", "Good for the intestines"));
        models.add(new ViewPagerModel(R.drawable.chia_seeds, "chia seeds", "Good for the intestines"));
        models.add(new ViewPagerModel(R.drawable.eggs, "eggs", "Good for the intestines"));
        models.add(new ViewPagerModel(R.drawable.leafy_greens, "leafy greens", "Good for the intestines"));

        models1 = new ArrayList<>();
        models1.add(new ViewPagerModel(R.drawable.ic_dashboard_black_24dp, "black", "Enough fiber content for easy digestion"));
        models1.add(new ViewPagerModel(R.drawable.ic_dashboard_black_24dp, "black", "Enough fiber content for easy digestion"));
        models1.add(new ViewPagerModel(R.drawable.ic_dashboard_black_24dp, "black", "Enough fiber content for easy digestion"));
        models1.add(new ViewPagerModel(R.drawable.ic_dashboard_black_24dp, "black", "Enough fiber content for easy digestion"));
        models1.add(new ViewPagerModel(R.drawable.ic_dashboard_black_24dp, "black", "Enough fiber content for easy digestion"));

        models2 = new ArrayList<>();
        models2.add(new ViewPagerModel(R.drawable.ic_dashboard_black_24dp, "black", "Enough fiber content for easy digestion"));
        models2.add(new ViewPagerModel(R.drawable.ic_dashboard_black_24dp, "black", "Enough fiber content for easy digestion"));
        models2.add(new ViewPagerModel(R.drawable.ic_dashboard_black_24dp, "black", "Enough fiber content for easy digestion"));
        models2.add(new ViewPagerModel(R.drawable.ic_dashboard_black_24dp, "black", "Enough fiber content for easy digestion"));
        models2.add(new ViewPagerModel(R.drawable.ic_dashboard_black_24dp, "black", "Enough fiber content for easy digestion"));

        models3 = new ArrayList<>();
        models3.add(new ViewPagerModel(R.drawable.ic_dashboard_black_24dp, "black", "Enough fiber content for easy digestion"));
        models3.add(new ViewPagerModel(R.drawable.ic_dashboard_black_24dp, "black", "Enough fiber content for easy digestion"));
        models3.add(new ViewPagerModel(R.drawable.ic_dashboard_black_24dp, "black", "Enough fiber content for easy digestion"));
        models3.add(new ViewPagerModel(R.drawable.ic_dashboard_black_24dp, "black", "Enough fiber content for easy digestion"));
        models3.add(new ViewPagerModel(R.drawable.ic_dashboard_black_24dp, "black", "Enough fiber content for easy digestion"));


        adapter = new ViewPagerAdapter(models,getContext());
        adapter1 = new ViewPagerAdapter(models1, getContext());
        adapter2 = new ViewPagerAdapter(models2, getContext());
        adapter3 = new ViewPagerAdapter(models3, getContext());

        viewPager = view.findViewById(R.id.viewpager);
        viewPager1 = view.findViewById(R.id.viewpager1);
        viewPager2 = view.findViewById(R.id.viewpager2);
        viewPager3 = view.findViewById(R.id.viewpager3);

        viewPager.setAdapter(adapter);
        viewPager1.setAdapter(adapter1);
        viewPager2.setAdapter(adapter2);
        viewPager3.setAdapter(adapter3);

        viewPager.setPadding(170, 0, 170, 0);
        viewPager1.setPadding(170, 0, 170, 0);
        viewPager2.setPadding(170, 0, 170, 0);
        viewPager3.setPadding(170, 0, 170, 0);

        return view;
    }
}

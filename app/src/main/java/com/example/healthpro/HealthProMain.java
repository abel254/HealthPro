package com.example.healthpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.healthpro.Authentication.Login;
import com.example.healthpro.Nav_fragments.DoctorDietFragment;
import com.example.healthpro.Nav_fragments.FoodsAndDietFragment;
import com.example.healthpro.Nav_fragments.QualitySleepFragment;
import com.example.healthpro.Nav_fragments.SettingsFragment;
import com.google.android.material.navigation.NavigationView;


public class HealthProMain extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_pro_main);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new DoctorDietFragment()).commit();
            navigationView.setCheckedItem(R.id.home);

        }
    }



    public void onBackPressed(){
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.doctordiet:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DoctorDietFragment()).commit();
                toolbar.setTitle("Doctor_diet");
                break;
            case R.id.foodsanddiet:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FoodsAndDietFragment()).commit();
                toolbar.setTitle("Foods and diet");
                break;
            case R.id.qualitysleep:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new QualitySleepFragment()).commit();
                toolbar.setTitle("Quality sleep");
                break;
            case R.id.settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SettingsFragment()).commit();
                toolbar.setTitle("Settings");
                break;
            case R.id.logout:
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

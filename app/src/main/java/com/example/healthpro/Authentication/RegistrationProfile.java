package com.example.healthpro.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;

import com.example.healthpro.R;

import java.util.ArrayList;

public class RegistrationProfile extends AppCompatActivity {
    ArrayList<Reg> regDetails;
    DatabaseHelperReg databaseHelperReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_registration_profile);

        databaseHelperReg = new DatabaseHelperReg(this, "REGDB.sqlite", null, 1);
        databaseHelperReg.queryData("CREATE TABLE IF NOT EXISTS PROFILE (id INTEGER PRIMARY KEY AUTOINCREMENT, firstname VARCHAR, lastname VARCHAR, currentweight VARCHAR, targetweight VARCHAR, birth VARCHAR, gender VARCHAR)");

    }
}

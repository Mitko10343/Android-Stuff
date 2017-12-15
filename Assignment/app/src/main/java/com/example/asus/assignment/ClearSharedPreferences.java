//Mobile Software Development Assignmet
//Written By Dimiter Dinkov
//Student Number:C15334276

package com.example.asus.assignment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ClearSharedPreferences extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clear_shared_preferences);

        //gets the shared preferences file for the calories progress and clears it
        getApplicationContext().getSharedPreferences("caloriesProgress",Context.MODE_PRIVATE).edit().clear().apply();
        //Go back to main activity straight after the shared Preferences are deleted
        Intent i = new Intent(this,homeScreen.class);
        startActivity(i);
        finish();
    }
}

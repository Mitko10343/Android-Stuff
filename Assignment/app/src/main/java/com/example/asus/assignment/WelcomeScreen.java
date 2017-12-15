//Mobile Software Development Assignmet
//Written By Dimiter Dinkov
//Student Number:C15334276

package com.example.asus.assignment;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.InterpolatorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeScreen extends AppCompatActivity {
    //Create a Timeout for the  Splash screen
    public static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        //Create a new Handler
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //New Intent for the home screen
                Intent home= new Intent(WelcomeScreen.this, homeScreen.class);
                //Start The homescreen Activity
                startActivity(home);
                //Close this Activity
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}

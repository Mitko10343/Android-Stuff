//Mobile Software Development Assignmet
//Written By Dimiter Dinkov
//Student Number:C15334276

package com.example.asus.assignment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class bodyMeasurementsScreen extends AppCompatActivity {

    //Declare Some Edit Text Variables
    EditText height,weight,age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_measurements_screen);

        //Get a reference to these variables
         height = (EditText)findViewById(R.id.HeightEditText);
         weight = (EditText) findViewById(R.id.weightEditText);
         age  =(EditText)findViewById(R.id.ageEditText);
    }

    //When the user clicks the enter measurements button
    public void enterMeasurementsClicked(View v)
    {
        //Assigning user input to Variables
        //Parsing the user input from a string to an int
        int heightInput = Integer.parseInt(height.getText().toString());
        int weightInput = Integer.parseInt(weight.getText().toString());
        int ageInput = Integer.parseInt(age.getText().toString());

        //calculate the users Base Metabolic Rate (BMR)
        int BMR = calculateBMR(heightInput,weightInput,ageInput);

        //Save the User input into Shared Preferences
        //Use Mode_Private since this share preferences file can be only accessed by this app
        SharedPreferences sharePref = getSharedPreferences("bodyMeasurements", Context.MODE_PRIVATE);

        //Create an editor for the share preferences that will be able to edit the file
        SharedPreferences.Editor editor = sharePref.edit();

        //Store the user Input into Share preferences using key and pair values
        editor.putInt("Height",heightInput);
        editor.putInt("Weight",weightInput);
        editor.putInt("Age",ageInput);
        editor.putInt("CaloriesGoal",BMR);
        //Apply changes to the file
        editor.apply();

        //Create a new intent
        Intent i = new Intent(this,homeScreen.class);

        //Display small message to the user telling them they have updated their measurements
        //And also start the next activity
        Toast.makeText(this,"Updated",Toast.LENGTH_SHORT).show();
        startActivity(i);
    }

    //function that calculate the Base metabolic Rate for a male user
    //I go the formula for calculating the BMR online
    //Reference: https://www.livestrong.com/article/184215-how-to-calculate-bmr-manually/

    // BMR = (height in centimeters x 6.25) + (weight in kilograms x 9.99) - (age x 4.92) + 5

    //Function returns the result in Kcal
    public int calculateBMR(int userHeight, int userWeight, int userAge)
    {
        int BMR =0;

        BMR = (int)((userHeight * 6.25) + (userWeight *9.99) - (userAge *4.92) + 5);
        return BMR;
    }


}

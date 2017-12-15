//Mobile Software Development Assignmet
//Written By Dimiter Dinkov
//Student Number:C15334276

package com.example.asus.assignment;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addFoodScreen extends AppCompatActivity {

    //Declare Some Edit Text Variables
    EditText foodN,foodC,portSize;

    //Declare a database object
    foodsDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_screen);

        //Get a Reference to these variables
        foodN = (EditText) findViewById(R.id.FoodName);
        foodC = (EditText) findViewById(R.id.Calories);
        portSize= (EditText) findViewById(R.id.PortionSize);

        //Instanciate the database object
        db = new foodsDatabase(this);
    }

    public void AddFoodDetails(View v)
    {
        //Get the User Input and store it into variables
        String foodName = foodN.getText().toString();
        //Parse some String input into an int variable
        int foodCalories = Integer.parseInt(foodC.getText().toString());
        int portionSize = Integer.parseInt(portSize.getText().toString());

        //Try to add the new food created by the user in the databse
        try{
            db.addFood(foodName,foodCalories,portionSize);
            Toast.makeText(this,"Added Successfully",Toast.LENGTH_LONG).show();
        }
        //else Display an error message
        catch(Exception e)
        {
            Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();
        }


    }
}

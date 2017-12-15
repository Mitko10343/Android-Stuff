//Mobile Software Development Assignmet
//Written By Dimiter Dinkov
//Student Number:C15334276

package com.example.asus.assignment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class SearchForFood extends AppCompatActivity {

    foodsDatabase db = new foodsDatabase(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_for_food);

        //tries to open the database and insert some data into it
        try{
            db.open();
            db.addFood("Snickers Bar",488,100);
            db.addFood("Twix Bar",502,100);
            db.addFood("Apple",52,100);
            db.addFood("Bannana",89,100);
            db.addFood("Pear",57,100);
            db.addFood("Watermelon",30,100);
            db.addFood("Melon",36,100);
            db.addFood("Beef Steak",271,100);
            db.addFood("Pork Chops",231,100);
            db.addFood("Chocolate Cake",371,100);
            db.addFood("Milk",42,100);
            populateList();
        }
        //Else it catches an exception and displays an error
        catch (Exception e)
        {
            Toast.makeText(this,String.valueOf(e),Toast.LENGTH_LONG).show();
            Log.e("error", String.valueOf(e));
        }

    }

    //When this method is called the database is closed
    @Override
    protected void onDestroy() {
        db.close();
        super.onDestroy();
    }

    //A method that will populate the List
    public void populateList()
    {
        // call the method DisplayFoods() that in the database class
        //and assign the returned results to a cursor
        Cursor cursor = db.DisplayFoods();

        //Declare two parallel arrays that will act as a key value pair
        String[] foods = new String[] {db.COLUMN_ID,db.COLUMN_FOODNAME, db.COLUMN_CALORIES, db.COLUMN_SERVINGSIZE};//This Array will contain the values from the cursor we want displayed
        int[] viewIDs = new int[] {R.id.id,R.id.FoodName,R.id.Calories,R.id.ServingSize};//THis array contains the view ID's where we want to display the cursor results

        //declare an adapter that will be used to display the information to the list View
        SimpleCursorAdapter myCursor = new SimpleCursorAdapter(this,R.layout.activity_search_cust_row,cursor,foods,viewIDs,0);
        //Get a reference to the list view in the activity
        ListView foodList = (ListView)findViewById(R.id.foodList);
        //Apply the adapter to the list view
        foodList.setAdapter(myCursor);

    }

    //Start a new activity when the user clicks the Add New Food Button
    public void newFoodClicked(View v)
    {
        Intent addFoodPressed = new Intent(this,addFoodScreen.class);
        startActivity(addFoodPressed);
    }


    //When the user tries to search for a food this function is called
    public void searchClicked(View v)
    {
        //get a reference to edit text view that will contain the user input
        EditText search = (EditText)findViewById(R.id.searchInput);
        //get the user input from the search edit text and convert it to a string
        String searchInput = search.getText().toString();
        //Try opening the foods database
        try {
            db.open();
        }
        //Else catch an exception and display an error meassage
        catch (Exception e) {
            e.printStackTrace();
        }
        //Pass in the user input to the getFood() method in the database class
        //Since this function returns a cursor assign the result to a cursor variable
        Cursor cursor = db.getFood(searchInput);

        //Make two parallel Arrays that will act as a key an value pair
        String[] results = new String[]{db.COLUMN_ID,db.COLUMN_FOODNAME,db.COLUMN_CALORIES,db.COLUMN_SERVINGSIZE}; //This array will hold the result from the cursor
        int[] viewIDs = new int[] {R.id.id,R.id.FoodName,R.id.Calories,R.id.ServingSize}; //This array will how the view ID's The results need to be assigned too

        //Declare an adapter that will be used to populate the list with the results from the database
        SimpleCursorAdapter myCursor = new SimpleCursorAdapter(this,R.layout.activity_search_cust_row,cursor,results,viewIDs,0);
        //Get a reference to the list view in the activity
        ListView foodList = (ListView)findViewById(R.id.foodList);
        //Close the databse
        db.close();

        //Clear the list view by setting a null adapter first
        //and The re-populate it using the myCursor adapter that was created above
        foodList.setAdapter(null);
        foodList.setAdapter(myCursor);

    }

    public void addFoodClicked(View v)
    {

        //Crete two variables to store the current daily calories
        //and the new calories the user will want to add to their daily calorie intake
        int currentCalories;
        int newCalories;

        //Get a shared preference file
        SharedPreferences sharePref = getSharedPreferences("caloriesProgress", Context.MODE_PRIVATE);
        //Create a Share preference editor that will add values into the file
        SharedPreferences.Editor editor = sharePref.edit();
        //Get the current calories intake for the user from the share preference file
        currentCalories = sharePref.getInt("Calories",0);
        //Get the calories for the food the user wishes to add from the calories
        //text view in the list and parse the string to an int
        TextView calories = (TextView)((View) v.getParent()).findViewById(R.id.Calories);
        String Kcal = calories.getText().toString();
        newCalories = Integer.parseInt(Kcal);

        Toast.makeText(this,"AddedFood",Toast.LENGTH_LONG).show();

        //Calculate the new current daily calories intake for the user by adding their current calorie
        //intake with the new calories intake from the food the wish to include
        currentCalories = currentCalories + newCalories;
        //Enter the updated calories Intake in the shared Preferences file
        editor.putInt("Calories" ,currentCalories);
        editor.apply();
        Intent i = new Intent();
        setResult(RESULT_OK, i);
        finish();
    }


}

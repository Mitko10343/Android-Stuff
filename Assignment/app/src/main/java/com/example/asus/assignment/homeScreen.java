//Mobile Software Development Assignmet
//Written By Dimiter Dinkov
//Student Number:C15334276

package com.example.asus.assignment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class homeScreen extends AppCompatActivity {

    //Declaring The text view variables that will display calories
    TextView cals,calsGoal;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //Set the time to midnight
        Calendar Midnight= Calendar.getInstance();
        Midnight.set(Calendar.HOUR_OF_DAY,23);
        Midnight.set(Calendar.MINUTE,59);
        Midnight.set(Calendar.SECOND,59);

        //Create and alram Manager that will trigger an activity at midnight, which will clear the share Preferences of the calories
        //In other words, when its midnight the app will refresh the calorie intake for the day to 0
        //So the user will be able to start inputing The food they will eat for the next day without
        //Overriding the calories intake from the previous day
        AlarmManager am =( AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(this, ClearSharedPreferences.class);
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);
        am.setInexactRepeating(AlarmManager.RTC, Midnight.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pi);

        //Get The current Calories intake for the user from share preferences
        SharedPreferences CurrentCal = getSharedPreferences("caloriesProgress", Context.MODE_PRIVATE);
        //Get the current Calories intake for the user from share preferences file, assgint it
        //to an integer value and the set the corresponding text view on the home screen
        //to that value
        int CurrentCaloriesIntake = CurrentCal.getInt("Calories",0);
        cals = (TextView)findViewById(R.id.currentCalories);
        cals.setText(Integer.toString(CurrentCaloriesIntake));


        //Get the daily Calories Goal From the Share Preference File
        SharedPreferences CalGoal = getSharedPreferences("bodyMeasurements", Context.MODE_PRIVATE);
        // Assignt the Goal Calories Intake For the user to a variable and then
        //Assign that value to the corresponding text view on the screen
        int DailyCaloriesGoal = CalGoal.getInt("CaloriesGoal", Integer.parseInt("0"));
        calsGoal = (TextView)findViewById(R.id.dailyGoal);
        calsGoal.setText(Integer.toString(DailyCaloriesGoal));

        //Creating a simple List view with a custom row adapter
        //That will display all the Meals the user can add
        //Array of Meals
        String[] meal= {"Breakfast","Lunch", "Dinner", "Snacks"};
        //Referencing the List Adapter
        ListAdapter rowAdapter = new mealRowAdapter(this,meal);
        //Getting A reference for the list view
        ListView mealList = (ListView)findViewById(R.id.Meal_List);
        //Setting the Adapter
        mealList.setAdapter(rowAdapter);



    }

    //When add meal Button is Clicked a this activity is called and it
    //starts a new activity
    public void addMealClicked(View view)
    {
        Intent SearchFoodScreen = new Intent(homeScreen.this,SearchForFood.class);
        startActivityForResult(SearchFoodScreen,1);
    }

    //When Update measurements button is clicked
    //this function is called that starts a new activity
    public void updateMeasurementsClicked(View v)
    {
        Intent updateMeasurements = new Intent(this,bodyMeasurementsScreen.class);
        startActivity(updateMeasurements);
    }


    //This function is called when a new activity is started.
    //It awaits a result from the new activity to let this activity know its done
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            //If the request code is RESULT_OK then update the current calories intake by reading the data from the
            //shared preference file
            if(resultCode == RESULT_OK) {
                SharedPreferences CurrentCal = getSharedPreferences("caloriesProgress", Context.MODE_PRIVATE);
                //Get the current Calories intake for the user from share preferences file, assgint it
                //to an integer value and the set the corresponding text view on the home screen
                //to that value
                int CurrentCaloriesIntake = CurrentCal.getInt("Calories",0);
                Toast.makeText(this,Integer.toString(CurrentCaloriesIntake),Toast.LENGTH_SHORT);
                cals = (TextView)findViewById(R.id.currentCalories);
                cals.setText(Integer.toString(CurrentCaloriesIntake));
            }
        }
    }


}

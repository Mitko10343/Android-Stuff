package com.example.asus.customlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.asus.customlist.R;

import java.util.List;

class homeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] meal= {"Breakfast","Lunch", "Dinner", "Snacks"};

        ListAdapter rowAdapter = new mealRowAdapter(this,meal);
        ListView mealList = (ListView)findViewById(R.id.Meal_List);

        mealList.setAdapter(rowAdapter);

    }

    class mealRowAdapter extends ArrayAdapter<String> {
        public mealRowAdapter(Context context, String[] mealNames) {
            super(context,R.layout.meal_row, mealNames);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater mealLayout = LayoutInflater.from(getContext());
            View custView =  mealLayout.inflate(R.layout.meal_row,parent,false);

            String singleMealName = getItem(position);
            TextView meal = (TextView)custView.findViewById(R.id.meal);

            meal.setText(singleMealName);
            return custView;
        }
    }
}

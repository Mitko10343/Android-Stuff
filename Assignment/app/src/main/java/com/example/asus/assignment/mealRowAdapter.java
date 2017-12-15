//Mobile Software Development Assignmet
//Written By Dimiter Dinkov
//Student Number:C15334276
package com.example.asus.assignment;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

//Custom Row Adapter for the Meal List
class mealRowAdapter extends ArrayAdapter<String> {


    public mealRowAdapter( Context context,String[] mealNames) {
        super(context,R.layout.meal_row, mealNames);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater mealLayout = LayoutInflater.from(getContext());
        View custView =  mealLayout.inflate(R.layout.meal_row,parent,false);

        String singleMealName = getItem(position);
        TextView meal = (TextView)custView.findViewById(R.id.meal);
        Button addButton = (Button)custView.findViewById(R.id.add);


        meal.setText(singleMealName);
        return custView;
    }
}

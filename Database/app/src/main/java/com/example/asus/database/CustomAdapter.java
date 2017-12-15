package com.example.asus.database;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.database.R;

/**
 * Created by Asus on 08/11/2017.
 */

public class CustomAdapter extends ArrayAdapter<String> {


    public CustomAdapter(Context context, Cursor myCursor, String[] task,int[] to) {
        super(context, R.layout.custom_row ,task);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater sqlInflater = LayoutInflater.from(getContext());
        View customView = sqlInflater.inflate(R.layout.custom_row,parent,false);

        String singleTask = getItem(position);
        TextView row1 = (TextView) customView.findViewById(R.id.row1);
        TextView row2 = (TextView) customView.findViewById(R.id.row2);

        row1.setText(singleTask);
        row2.setText(singleTask);

        return customView;
    }
}

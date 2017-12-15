package com.example.asus.database;

import android.app.Activity;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Database extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        DatabaseExampleOutline db = new DatabaseExampleOutline(this);
        Cursor myCursor;

        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();

        try {
            db.open();
            //db.insertTasks("Cooking", "Preparing Food", 0);
           // db.insertTasks("Compiling", "Generating Machine Code", 1);
           // db.insertTasks("Coding", "Writing Code", 0);
           // db.insertTasks("Making A Database", "making a pool of data", 0);

            db.close();

            Toast.makeText(this, "Everything went wellllllllllll", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
        }

        myCursor = db.getTasks(1);
        String[] taskList = {"task name","task description"};
        int[] to = {R.id.row1,R.id.row2};

        CustomAdapter mAdapter = new CustomAdapter(this,myCursor, taskList, to);
        ListView Sql= (ListView) findViewById(R.id.Sql);
        Sql.setAdapter(mAdapter);
    }

}
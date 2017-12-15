package com.example.killian.lab5;

import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    Context context;

    ArrayList prgmName;
    public static int [] prgmImages={R.drawable.android, R.drawable.android,R.drawable.ok,R.drawable.android,R.drawable.android,R.drawable.android,R.drawable.android,R.drawable.android,R.drawable.android,R.drawable.android, };
    public static String [] prgmNameList={ "American Samoa",
            "El Salvador",
            "Ireland",
            "Saint Kitts and Nevis",
            "Saint Lucia",
            "Saint Pierre and Miquelton",
            "Saint Vincent and the Grenadines",
            "Samoa",
            "San Marino",
            "Saudi Arabia"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;

        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}



package com.example.asus.lab4_pt3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class part3 extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part3);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.List);

        // Defined Array values to show in ListView
        String[] values = new String[]{"American Samoa",
                "El Salvador",
                "Saint Helena",
                "Saint Kitts and Nevis",
                "Saint Lucia",
                "Saint Pierre and Miquelon",
                "Saint Vincentm and the Gerandines",
                "Samoa",
                "San Marino",
                "Saudi Arabia"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id., values);




        listView.setAdapter(adapter);


    }
}

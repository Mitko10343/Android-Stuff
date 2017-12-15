package com.example.asus.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.R.attr.button;
import static com.example.asus.lab3.R.id.buttonToast;
import static com.example.asus.lab3.R.id.buttonToast2;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(ActivityFrom.this,ActivityTo.class);


        Button button = (Button) findViewById(R.id.buttonToast);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Button is clicked", Toast.LENGTH_LONG).show();
            }
        });

        Button button2 = (Button) findViewById(R.id.buttonToast2);

    }
    public void showToast(View view)
    {
        Toast.makeText(getApplicationContext(),"Button Clicked",Toast.LENGTH_LONG).show();
    }

}

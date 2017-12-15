package com.example.asus.simplebutton;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Date;

import static android.R.attr.button;

public class SimpleButton extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_button);



        findViewById(R.id.button).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Inform the user the button has been clicked
                Toast.makeText(getApplicationContext(), "Button is clicked", Toast.LENGTH_LONG).show();
            }
        });



    }

}

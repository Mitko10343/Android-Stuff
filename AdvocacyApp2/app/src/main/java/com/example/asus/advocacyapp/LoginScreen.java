package com.example.asus.advocacyapp;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {

    private static String password ="";
    private static int counter =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

    }

    public void keyPressed(View v)
    {
        password = password + (String) v.getTag();
        counter++;
        Toast.makeText(this,"Key pressed "+password, Toast.LENGTH_LONG).show();

        if(counter == 6 )
        {
            if(password.equals("123456"))
            {
                Intent i = new Intent(this,MainMenu.class);

                Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
            else{
                Toast.makeText(this, "You done fucked up", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

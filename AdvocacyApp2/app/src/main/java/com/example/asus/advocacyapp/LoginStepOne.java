package com.example.asus.advocacyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginStepOne extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_step_one);
    }

    public void registerClicked(View v)
    {
        Intent i = new Intent(this,Register.class);
        startActivity(i);
    }

    public void nextClicked(View v)
    {
        EditText userInput = (EditText) findViewById(R.id.NameInput);

        String userName = userInput.getText().toString();

        //Check if the username is in the DB and then go to the next screen if the user exists
        Intent i = new Intent(this,LoginScreen.class);
    }

}

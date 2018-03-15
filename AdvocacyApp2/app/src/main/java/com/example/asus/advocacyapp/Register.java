package com.example.asus.advocacyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText userInput;
    private String password= "";
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userInput = (EditText) findViewById(R.id.nameInput);
    }

    public void padClicked(View v)
    {
        password = password + v.getTag();

        int len = password.length();

        if(len == 6)
        {
            username = userInput.getText().toString();

            if(username.equals(null)) {
                Toast.makeText(this,"Please enter your username",Toast.LENGTH_SHORT);
            }else {
                Toast.makeText(this,"User "+username+ " \nPassword: "+password,Toast.LENGTH_SHORT);
                 /*Intent i = new Intent(this,LoginStepOne.class);
                 startActivity(i);*/
            }
        }
    }
}

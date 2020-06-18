package com.example.androidlabs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.TwoStatePreference;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {


    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String EMAIL = "email";
    public static final String password = "pass";
    public String email;
    public static final String ACTIVITY_NAME = "MAIN_ACTIVITY";
    private Button obutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab3layout);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
  //      editor.commit();
    //    Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();

        email = prefs.getString(EMAIL, "");
        EditText emailText = findViewById(R.id.textView);
        emailText.setText(email);

        Button oButton = findViewById(R.id.obutton);
        oButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginClick();
            }
        });


        Log.e(ACTIVITY_NAME, "In function:" + "onCreate()");


    }

  //  public void openProfileActivity(){
  //      Intent intent = new Intent(this, ProfileActivity.class);
 //   }


    public void savePreferences(){

        SharedPreferences sp = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        EditText emailText = findViewById(R.id.textView);
        email = emailText.getText().toString();
        editor.putString(EMAIL, email);

        editor.commit();
    }


    public void onLoginClick(){

        Intent nextPage = new Intent(MainActivity.this, ProfileActivity.class);

        EditText emailInfo = findViewById(R.id.textView);
        email = emailInfo.getText().toString();
        nextPage.putExtra("EMAIL", email);

        startActivity(nextPage);
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.e(ACTIVITY_NAME, "In function:" + "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(ACTIVITY_NAME, "In function:" + "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(ACTIVITY_NAME, "In function:" + "onDestroy()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(ACTIVITY_NAME, "In function:" + "onResume()");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(ACTIVITY_NAME, "In function:" + "onActivityResult()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        savePreferences();


        Log.e(ACTIVITY_NAME, "In function:" + "onPause()");


   //     editor.putString(EMAIL, findViewById(R.id.textView).toString());



    }




}
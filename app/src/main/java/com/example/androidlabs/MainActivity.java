package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.TwoStatePreference;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    CheckBox text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        }

        public void onDisplay(View v){

        text = (CheckBox) findViewById(R.id.checkbox);
        String message = getResources().getString(R.string.check);
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();

    }


    public void onCheckChanged(View view) {

        final Switch s = (Switch) findViewById(R.id.switch1);

        if (s.isChecked()) {
            Snackbar mySnackbar = Snackbar.make(findViewById(R.id.switch1), getResources().getString(R.string.swch) + " " + getResources().getString(R.string.on), Snackbar.LENGTH_LONG);
            mySnackbar.setAction(R.string.undo, new MyUndoListener());
            mySnackbar.show();

        } else {
            Snackbar mySnackbar = Snackbar.make(findViewById(R.id.switch1), getResources().getString(R.string.swch) + " " + getResources().getString(R.string.off), Snackbar.LENGTH_SHORT);
            mySnackbar.setAction(R.string.undo, new MyUndoListener());
            mySnackbar.show();
        }

    }
}
package com.example.pin.listofstuff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void myFunction(View v) {
        Intent myIntent = new Intent(this, SecondActivity.class);
        startActivity(myIntent);
    }
    public void onClickMonaLisa(View v) {
        Toast.makeText(getApplication(), "Mona Lisa!", Toast.LENGTH_SHORT).show();
    }
}

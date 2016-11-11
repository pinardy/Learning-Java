package com.example.pin.geolocationnew;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void launchMap(View v) {
        //instantiating
        Geocoder geocoder = new Geocoder(this);
        List<Address> matchedList = null;
        EditText entry = (EditText) findViewById(R.id.editText);

        //retrieving location
        try {
            Toast.makeText(getApplicationContext(), "Retrieving location...", Toast.LENGTH_LONG).show();
            matchedList =  geocoder.getFromLocationName(entry.getText().toString(), 1);
        } catch (IOException e) {
            Toast.makeText(this, "Not able to find location" + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        //instantiating data to retrieve location
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String lat = null;
        String lon = null;

        //retrieving location
        try{
            lat = String.valueOf(matchedList.get(0).getLatitude());
            lon = String.valueOf(matchedList.get(0).getLongitude());
        } catch (Exception e){
            Toast.makeText(this, "A problem occured in retrieving location", Toast.LENGTH_LONG).show();
            return;
        }
        intent.setData(Uri.parse("geo:"+lat+","+lon));

        Intent chooser = Intent.createChooser(intent, "Launch maps");
        startActivity(chooser);

        // Code below is my first attempt (wrong)

//        EditText entry = (EditText) findViewById(R.id.editText);
//        if (entry.getText().toString().equals("8 Somapah road")) {
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            intent.setData(Uri.parse("geo:1.340091, 103.962990"));
//            startActivity(intent);

    }
}


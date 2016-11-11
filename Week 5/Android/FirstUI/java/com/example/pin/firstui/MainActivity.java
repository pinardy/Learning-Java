package com.example.pin.firstui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity{

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void myFunction(View view) {
        Intent myIntent = new Intent(this, SecondActivity.class);
        startActivity(myIntent);
        Button myBtn = (Button) findViewById(R.id.button);
        myBtn.setText("Hi!");
    }

    public void onClickListenerButton(View v) {
        boolean checked = ((RadioButton) v).isChecked();
        if(checked) {
            Toast.makeText(getApplicationContext(), "Radio button selected", Toast.LENGTH_LONG).show();
            }
        }

    public void myEmailFunction(View view) {
        Button myBtn = (Button) findViewById(R.id.button2);
        String[] TO = {"myemail@mymail.sutd.edu.sg", "hello@world.com"};
        String[] CC = {"andrew_yoong@mymail.sutd.edu.sg"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        // to send data
        emailIntent.setData(Uri.parse("mailto: "));
        emailIntent.setType("text/plain"); // plain text

        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        // string holding desired subject
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
        // contain text message to be sent

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Cannot open mail", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.pin.firstui/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.pin.firstui/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}

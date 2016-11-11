package com.example.pin.camera;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private File myImageFile;

    public void cameraFunction(View v){
        Intent myIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        myImageFile = new File(Environment.getDataDirectory(),"myImage.jpg");
        Uri tempUri = Uri.fromFile(myImageFile);
        myIntent.putExtra(MediaStore.EXTRA_OUTPUT,tempUri);
        startActivity(myIntent);
    }

}

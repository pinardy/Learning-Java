package com.example.pin.filereadwrite;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    public EditText editText;
    public Button save, load;

    public String path = Environment.getExternalStorageDirectory().getAbsolutePath();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        save = (Button) findViewById(R.id.save);
        load = (Button) findViewById(R.id.load);

        File dir = new File(path);
        dir.mkdirs();
    }

    public void writeButton(View v) {
        String message = editText.getText().toString();
        try {
            FileOutputStream fileOut = openFileOutput("myFile.txt", MODE_PRIVATE);
            fileOut.write(message.getBytes());
            fileOut.close();
            Toast.makeText(getApplicationContext(), "Message saved", Toast.LENGTH_LONG).show();
            editText.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readButton(View v) {
        try {
            FileInputStream fileIn = openFileInput("myFile.txt");
            InputStreamReader inputRead = new InputStreamReader(fileIn);
            BufferedReader buffRead = new BufferedReader(inputRead);
            StringBuffer stringBuffer = new StringBuffer();
            String message;
            while ((message = buffRead.readLine()) != null) { // if line is existing
                stringBuffer.append(message);
            }
            Toast.makeText(getApplicationContext(), stringBuffer.toString(), Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(), "File read successfully!", Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

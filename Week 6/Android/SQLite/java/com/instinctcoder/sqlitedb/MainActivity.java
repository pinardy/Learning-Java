package com.instinctcoder.sqlitedb;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkPassword(View v){
        EditText password = (EditText) findViewById(R.id.editText);
        Toast.makeText(getApplicationContext(), password.getText(), Toast.LENGTH_SHORT).show();
        if (password.getText().toString().equals("1234")) {
            Toast.makeText(getApplication(), "Password match", Toast.LENGTH_SHORT).show();
            Intent myIntent = new Intent(this, Particulars.class);
            startActivity(myIntent);
        } else{
            Toast.makeText(getApplication(), "Password doesn't match", Toast.LENGTH_SHORT).show();
        }
    }
}
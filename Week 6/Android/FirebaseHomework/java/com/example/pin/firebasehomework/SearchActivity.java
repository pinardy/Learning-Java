package com.example.pin.firebasehomework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Pin on 28-Oct-16.
 */

public class SearchActivity extends AppCompatActivity {

    FirebaseDatabase ref = FirebaseDatabase.getInstance();
    DatabaseReference reference = ref.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    public void search(View v){
        EditText editTextSearch = (EditText) findViewById(R.id.editTextSearch);

        // Creating Student object
//        Student student = new Student();

        // Getting values to store
        final String name = editTextSearch.getText().toString().trim();


        // Value event listener for realtime data update
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String string;
                string="";
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                    //Getting the data from snapshot and add
                    String student = postSnapshot.child("name").getValue(String.class);
                    if (student.equals(name)) {
                        string += student + "\n";
                        String pillar = postSnapshot.child("pillar").getValue(String.class);
                        string += pillar;
                    }

                    Log.d("snap", postSnapshot.toString()); // for debugging

                    //Update TextView of the student names
                    TextView textViewStudSearch = (TextView) findViewById(R.id.textViewStudSearch);
                    textViewStudSearch.setText(string);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("ErrorFailure", "Failed to read value.", error.toException());
            }
        });
    }
}

package com.example.pin.firebasehomework;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    FirebaseDatabase ref = FirebaseDatabase.getInstance();
    DatabaseReference reference = ref.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("debug", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d("debug", "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public void onClick(View v){
        mAuth.signInWithEmailAndPassword("pinardy.yang@gmail.com", "123456")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("Pinardy", "signInWithEmail:onComplete:" + task.isSuccessful());
                        Toast.makeText(MainActivity.this, "Authentication success.",
                                Toast.LENGTH_SHORT).show();


                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w("Sign In", "signInWithEmail", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }
    public void save(View v){
        EditText editTextName = (EditText) findViewById(R.id.editTextName);
        EditText editTextPillar = (EditText) findViewById(R.id.editTextPillar);

//        FirebaseDatabase ref = FirebaseDatabase.getInstance();
//        DatabaseReference reference = ref.getReference();

        // Creating Student object
        Student student = new Student();

        // Getting values to store
        String name = editTextName.getText().toString().trim();
        String pillar= editTextPillar.getText().toString().trim();

        // Setting values
        student.setName(name);
        student.setPillar(pillar);

        // Storing values to firebase
        reference.child(name).setValue(student);

        // Update message to show success of uploading
        TextView textViewStatus = (TextView) findViewById(R.id.textViewStatus);
        textViewStatus.setText("Data saved successfully");

        // Value event listener for realtime data update
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String string;
                string="";
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    //Getting the data from snapshot
                    String student = postSnapshot.child("name").getValue(String.class);

                    Log.d("snap", postSnapshot.toString()); // for debugging

                    //Adding it to a string
                    string += student + "\n";

                    //Update TextView of the student names
                    TextView textViewStudents = (TextView) findViewById(R.id.textViewStudents);
                    textViewStudents.setText(string);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("ErrorFailure", "Failed to read value.", error.toException());
            }
        });
    }

    public void goToSearch(View v){
        Intent myIntent = new Intent(this, SearchActivity.class);
        startActivity(myIntent);
    }

}
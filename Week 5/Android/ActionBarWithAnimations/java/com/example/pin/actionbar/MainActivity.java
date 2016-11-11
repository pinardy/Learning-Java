package com.example.pin.actionbar;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

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

        ImageView imageView = (ImageView) findViewById(R.id.nyancat);
        Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        imageView.startAnimation(animRotate);

        imageView = (ImageView) findViewById(R.id.nyancat2);
        Animation animRotate2 = AnimationUtils.loadAnimation(this, R.anim.rotate1);
        imageView.startAnimation(animRotate2);

        imageView = (ImageView) findViewById(R.id.beanalisa);
        Animation zoom = AnimationUtils.loadAnimation(this, R.anim.zoom);
        imageView.setAnimation(zoom);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id = item.getItemId();
        if (res_id == R.id.smile) {
            Toast.makeText(getApplicationContext(), "Settings menu 1 pressed",
                    Toast.LENGTH_LONG).show();
        }
        if(res_id == R.id.set3){
            Toast.makeText(getApplicationContext(), "Settings menu 3 pressed",
                    Toast.LENGTH_LONG).show();
        }
        if(res_id == R.id.set2){
            Toast.makeText(getApplicationContext(), "Settings menu 2 pressed",
                    Toast.LENGTH_LONG).show();
        }
        if(res_id == R.id.set){
            Toast.makeText(getApplicationContext(), "Settings menu pressed",
                    Toast.LENGTH_LONG).show();
        }
        return true;
    }





}

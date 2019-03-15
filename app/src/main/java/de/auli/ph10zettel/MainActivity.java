package de.auli.ph10zettel;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import de.auli.ph10zettel.activity.GroupActivity;
import de.auli.ph10zettel.activity.PlayerActivity;
import de.auli.ph10zettel.activity.SessionActivity;
import de.auli.ph10zettel.activity.SessionStartActivity;
import de.auli.ph10zettel.util.Logger;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void actionGroup(MenuItem item) {
        Toast.makeText(MainActivity.this, "actionGroup", Toast.LENGTH_SHORT).show();
        Logger.log(TAG, "actionGroup kicks you to --> ", GroupActivity.class.getSimpleName());
        startActivity(new Intent(this, GroupActivity.class));
    }

    public void actionPlayer(MenuItem item) {
        Toast.makeText(MainActivity.this, "actionPlayer", Toast.LENGTH_SHORT).show();
        Logger.log(TAG, "actionPlayer kicks you to --> ", PlayerActivity.class.getSimpleName());
        startActivity(new Intent(this, PlayerActivity.class));
    }

    public void actionSession(MenuItem item) {
        Toast.makeText(MainActivity.this, "actionStartSession", Toast.LENGTH_SHORT).show();
        Logger.log(TAG, "actionSession kicks you to --> ", SessionActivity.class.getSimpleName());
        startActivity(new Intent(this, SessionActivity.class));
    }

    public void actionSessionStart(MenuItem item) {
        Toast.makeText(MainActivity.this, "actionSessionStart", Toast.LENGTH_SHORT).show();
        Logger.log(TAG, "actionSessionStart kicks you to --> ", SessionStartActivity.class.getSimpleName());
        startActivity(new Intent(this, SessionStartActivity.class));
    }
}

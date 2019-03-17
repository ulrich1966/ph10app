package de.auli.ph10app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import de.auli.ph10app.activity.GroupActivity;
import de.auli.ph10app.activity.PlayerActivity;
import de.auli.ph10app.activity.SessionActivity;
import de.auli.ph10app.activity.SessionStartActivity;
import de.auli.ph10app.util.AppLogger;

public class MainActivity extends AppCompatActivity {
    private static final AppLogger LOG = new AppLogger(MainActivity.class, false);

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
        LOG.log("actionGroup kicks you to --> ", GroupActivity.class.getSimpleName());
        startActivity(new Intent(this, GroupActivity.class));
    }

    public void actionPlayer(MenuItem item) {
        Toast.makeText(MainActivity.this, "actionPlayer", Toast.LENGTH_SHORT).show();
        LOG.log("actionPlayer kicks you to --> ", PlayerActivity.class.getSimpleName());
        startActivity(new Intent(this, PlayerActivity.class));
    }

    public void actionSession(MenuItem item) {
        Toast.makeText(MainActivity.this, "actionStartSession", Toast.LENGTH_SHORT).show();
        LOG.log("actionSession kicks you to --> ", SessionActivity.class.getSimpleName());
        startActivity(new Intent(this, SessionActivity.class));
    }

    public void actionSessionStart(MenuItem item) {
        Toast.makeText(MainActivity.this, "actionSessionStart", Toast.LENGTH_SHORT).show();
        LOG.log("actionSessionStart kicks you to --> ", SessionStartActivity.class.getSimpleName());
        startActivity(new Intent(this, SessionStartActivity.class));
    }
}

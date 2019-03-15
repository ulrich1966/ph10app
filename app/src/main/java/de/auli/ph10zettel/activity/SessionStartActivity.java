package de.auli.ph10zettel.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import de.auli.ph10zettel.R;

public class SessionStartActivity extends AppCompatActivity {
    private static final String TAG = SessionStartActivity.class.getSimpleName();
    ActionBar actionBar = null;

    public SessionStartActivity(){
        super();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "--> onCreate");
        setContentView(R.layout.activity_sessionstart);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_session, menu);
        return true;
    }

    public void actionEmpty(MenuItem item) {
        Log.d(TAG, "--> actionEmpty");
        Toast.makeText(SessionStartActivity.this, "actionEmpty", Toast.LENGTH_SHORT).show();
    }
}

package de.auli.ph10zettel.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import de.auli.ph10zettel.R;
import de.auli.ph10zettel.util.Logger;

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
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_session, menu);
        return true;
    }

    public void actionNewGroup(View view) {
        Logger.log(TAG, "Moin actionNewGroup");
        Toast.makeText(SessionStartActivity.this, "implement create new Group", Toast.LENGTH_SHORT).show();
        //TODO run a Handler here and create new Group
    }

    public void actionNewGroup(MenuItem item) {
        Logger.log(TAG, "Moin actionNewGroup");
        Toast.makeText(SessionStartActivity.this, "Item click: "+item.getTitle(), Toast.LENGTH_SHORT).show();
        //TODO run a Handler here and create new Group
    }
}

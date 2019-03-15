package de.auli.ph10app.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import de.auli.ph10app.R;
import de.auli.ph10app.handler.GroupHandler;
import de.auli.ph10app.util.Logger;

public class SessionStartActivity extends AppCompatActivity {
    private static final String TAG = SessionStartActivity.class.getSimpleName();
    private View rootView;

    public SessionStartActivity(){
        super();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "--> onCreate");
        setContentView(R.layout.activity_sessionstart);
        //GroupHandler.getInstance().handelList(null);
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        this.rootView = super.onCreateView(parent, name, context, attrs);
        return rootView;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(this.rootView == null){
            throw new IllegalStateException("The atached view must not be null");
        }
        GroupHandler.getInstance().handelList(rootView);
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

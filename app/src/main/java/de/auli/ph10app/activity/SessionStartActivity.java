package de.auli.ph10app.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import de.auli.ph10app.R;
import de.auli.ph10app.util.AppLogger;

public class SessionStartActivity extends Ph10Activity {
    private static final AppLogger LOG = new AppLogger(SessionStartActivity.class, false);
    private View rootView;
    private ImageButton cmdAddGroup;
    private boolean isDebug = false;

    public SessionStartActivity() {
        super();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LOG.log("you'r arrived --> onCreate");
        setContentView(R.layout.activity_sessionstart);
        setupClickListener();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (this.rootView == null) {
            throw new IllegalStateException("The atached view must not be null");
        }
        LOG.log("--> view is build and you'r arrived --> onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        this.rootView = super.onCreateView(parent, name, context, attrs);
        return rootView;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_group_session, menu);
        return true;
    }

    public void menActionNewGroup(MenuItem item) {
        LOG.log("Moin actionNewGroup");
        String msg = String.format("implement create new Group for click in menu: ", item.getTitle());
        Toast.makeText(SessionStartActivity.this, msg, Toast.LENGTH_SHORT).show();
        //TODO run a Handler here and create new Group
    }

    public void actionNewGroup(View view) {
        LOG.log("Moin actionNewGroup");
        String msg = String.format("implement create new Group for click in view: ", view.getId());
        Toast.makeText(SessionStartActivity.this, msg, Toast.LENGTH_SHORT).show();
        //TODO run a Handler here and create new Group
    }

    public void actionStartSession(View view) {
        LOG.log("Moin actionStartSession");
        String msg = String.format("implement create new Group for click in view: ", view.getId());
        Toast.makeText(SessionStartActivity.this, msg, Toast.LENGTH_SHORT).show();
        //TODO run a Handler here and create new Session
    }

    @Override
    public void setupClickListener() {
        cmdAddGroup = findViewById(R.id.cmd_add_group);
        cmdAddGroup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                actionNewGroup(view);
            }
        });
    }
}

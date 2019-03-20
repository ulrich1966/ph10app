package de.auli.ph10app.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import de.auli.ph10app.R;
import de.auli.ph10app.util.AppLogger;

public class PlayerGroupActivity extends Ph10Activity {
    private static final AppLogger LOG = new AppLogger(PlayerGroupActivity.class, true);
    private View rootView;
    private ImageButton cmdAddGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LOG.log("you'r arrived --> onCreate");
        setContentView(R.layout.activity_group);
        setupClickListener();
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        this.rootView = super.onCreateView(parent, name, context, attrs);
        return rootView;
    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            if (this.rootView == null) {
                throw new IllegalStateException("The atached view must not be null");
            }
        } catch (IllegalStateException e) {
            LOG.error(e.getMessage(), e);
        }
        LOG.log("--> view is build and you'r arrived --> onStart");
    }

    public void actionNewGroup(View view) {
        LOG.log("Moin actionNewGroup");
        String msg = String.format("implement create new Group for click in view: ", view.getId());
        Toast.makeText(PlayerGroupActivity.this, msg, Toast.LENGTH_SHORT).show();
        //TODO run a Handler here and create new Group
    }


    public void menActionNewGroup(MenuItem item) {
        LOG.log("Moin actionNewGroup");
        String msg = String.format("implement create new Group for click in menu: ", item.getTitle());
        Toast.makeText(PlayerGroupActivity.this, msg, Toast.LENGTH_SHORT).show();
        //TODO run a Handler here and create new Group
    }

    public void actionNewPlayerInGrp(View view) {
        LOG.log("Moin actionNewPlayerInGrp");
        String msg = String.format("implement create new Group for click in view: ", view.getId());
        Toast.makeText(PlayerGroupActivity.this, msg, Toast.LENGTH_SHORT).show();
        //TODO run a Handler here and add a player in playgroup
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

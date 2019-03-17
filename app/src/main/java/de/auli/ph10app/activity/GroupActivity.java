package de.auli.ph10app.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import de.auli.ph10app.R;
import de.auli.ph10app.util.AppLogger;

public class GroupActivity extends AppCompatActivity implements Ph10Activity {
    private View rootView;
    private ImageButton cmdAddGroup;
    private static final AppLogger LOG = AppLogger.getLogger(GroupActivity.class, true);

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
        if (this.rootView == null) {
            throw new IllegalStateException("The atached view must not be null");
        }
        LOG.log("--> view is build and you'r arrived --> onStart");
    }

    public void actionNewGroup(View view) {
        LOG.log("Moin actionNewGroup");
        Toast.makeText(GroupActivity.this, "implement create new Group", Toast.LENGTH_SHORT).show();
        //TODO run a Handler here and create new Group
    }

    public void actionShowPlayers(View view) {
        LOG.log("Moin actionShowPlayers");
        String msg = String.format("implement create new Group for click in view: ", view.getId());
        Toast.makeText(GroupActivity.this, msg, Toast.LENGTH_SHORT).show();
        //TODO run a Handler here and show players for playgroup
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

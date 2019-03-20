package de.auli.ph10app.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.auli.ph10app.R;
import de.auli.ph10app.fragment.PlayerFragment;
import de.auli.ph10app.model.Player;
import de.auli.ph10app.service.MarshallService;
import de.auli.ph10app.util.AppLogger;

public class PlayerActivity extends Ph10Activity {
    private static final AppLogger LOG = new AppLogger(PlayerActivity.class, false);
    private View rootView;

    private PlayerFragment playerFragment = new PlayerFragment();

    // Activity needs defaultconstructor
    public PlayerActivity() {
        super();
    }

    public PlayerActivity(View rootView) {
        this();
        this.rootView = rootView;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LOG.log("your'r arrived --> onCreate");
        super.onCreate(savedInstanceState);
        //super.onRestoreInstanceState(savedInstanceState);

        setContentView(R.layout.activity_player);
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


    public void actionNewPlayer(View view) {
        LOG.log("Moin actionNewGroup");
        Toast.makeText(PlayerActivity.this, "implement create new Player", Toast.LENGTH_SHORT).show();
        //TODO run a Handler here and create new Player
    }

    @Override
    public void setupClickListener() {

    }
}

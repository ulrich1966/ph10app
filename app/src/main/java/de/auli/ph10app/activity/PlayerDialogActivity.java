package de.auli.ph10app.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import de.auli.ph10app.R;
import de.auli.ph10app.fragment.PlayerDialogFragment;
import de.auli.ph10app.util.AppLogger;

public class PlayerDialogActivity extends Activity {
    private static final AppLogger LOG = new AppLogger(PlayerDialogActivity.class, false);
    private View rootView;
    private PlayerDialogFragment plsDialogFragment = new PlayerDialogFragment();

    // Activity needs defaultconstructor
    public PlayerDialogActivity() {
        super();
    }

    public PlayerDialogActivity(View rootView) {
        this();
        this.rootView = rootView;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_dialog);
    }

}

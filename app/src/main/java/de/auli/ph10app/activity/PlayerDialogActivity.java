package de.auli.ph10app.activity;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;

import de.auli.ph10app.R;
import de.auli.ph10app.fragment.PlayerDialogFragment;
import de.auli.ph10app.util.AppLogger;

public class PlayerDialogActivity extends FragmentActivity implements PlayerDialogFragment.NoticeDialogListener {
    private static final AppLogger LOG = new AppLogger(PlayerDialogActivity.class, false);
    private View rootView;
    private PlayerDialogFragment plsDialogFragment = new PlayerDialogFragment();

    @Override
    public FragmentManager getSupportFragmentManager() {
        return super.getSupportFragmentManager();
    }

    // Activity needs defaultconstructor
    public PlayerDialogActivity() {
        super();
    }

    public PlayerDialogActivity(View rootView) {
        this();
        this.rootView = rootView;
    }


    @Override
    protected void onStart() {
        super.onStart();
        DialogFragment dialog = new PlayerDialogFragment();
        dialog.show(getSupportFragmentManager(), "PlayerDialogFragment");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_dialog);
    }



    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {

    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }
}

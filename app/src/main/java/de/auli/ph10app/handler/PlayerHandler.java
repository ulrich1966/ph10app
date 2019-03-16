package de.auli.ph10app.handler;

import android.view.View;
import android.widget.ArrayAdapter;

import de.auli.ph10app.model.PlayerGroup;
import de.auli.ph10app.util.Logger;

public class PlayerHandler extends Handler {
    private static final String TAG = PlayerHandler.class.getSimpleName();
    private static final PlayerHandler instance = new PlayerHandler();

    private PlayerHandler() {
        super();
    }

    public static PlayerHandler getInstance(){
        return PlayerHandler.instance;
    }

    @Override
    public void handelCreate(View view) {
        Logger.log(TAG, "handelCreate");
    }

    @Override
    public ArrayAdapter<PlayerGroup> handelList(View view) {
        Logger.log(TAG, "handelList");
        return null;
    }

    @Override
    public void handelModel(View view, Long id) {
        Logger.log(TAG, "handelModel");
    }

    @Override
    public void handelUpdate(View view) {
        Logger.log(TAG, "handelUpdate");
    }

    @Override
    public void handelDelete(View view) {
        Logger.log(TAG, "handelDelete");
    }
}

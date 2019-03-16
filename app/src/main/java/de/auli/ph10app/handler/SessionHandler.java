package de.auli.ph10app.handler;

import android.view.View;
import android.widget.ArrayAdapter;

import de.auli.ph10app.model.PlayerGroup;
import de.auli.ph10app.util.Logger;

public class SessionHandler extends Handler {
    private static final String TAG = SessionHandler.class.getSimpleName();
    private static final SessionHandler instance = new SessionHandler();

    private SessionHandler() {
        super();
    }

    public static SessionHandler getInstance(){
        return SessionHandler.instance;
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

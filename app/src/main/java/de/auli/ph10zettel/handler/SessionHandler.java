package de.auli.ph10zettel.handler;

import android.view.View;

import de.auli.ph10zettel.util.Logger;

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
        super.setView(view);
    }

    @Override
    public void handelList(View view) {
        Logger.log(TAG, "handelList");
        super.setView(view);
    }

    @Override
    public void handelModel(View view, Long id) {
        Logger.log(TAG, "handelModel");
        super.setView(view);
    }

    @Override
    public void handelUpdate(View view) {
        Logger.log(TAG, "handelUpdate");
        super.setView(view);
    }

    @Override
    public void handelDelete(View view) {
        Logger.log(TAG, "handelDelete");
        super.setView(view);
    }
}

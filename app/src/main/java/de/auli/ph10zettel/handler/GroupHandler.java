package de.auli.ph10zettel.handler;

import android.view.View;
import android.widget.ArrayAdapter;

import java.net.MalformedURLException;
import java.net.URL;

import de.auli.ph10zettel.model.PlayerGroup;
import de.auli.ph10zettel.service.GroupService;
import de.auli.ph10zettel.util.ApiUrl;
import de.auli.ph10zettel.util.Logger;

public class GroupHandler extends Handler {
    private static final String TAG = GroupHandler.class.getSimpleName();
    private static final GroupHandler instance = new GroupHandler();
    private GroupService service = new GroupService(ApiUrl.REMOTE_BASE);

    private GroupHandler() {
        super();
    }

    public static GroupHandler getInstance() {
        return GroupHandler.instance;
    }

    @Override
    public void handelCreate(View view) {
        Logger.log(TAG, "handelCreate");
        super.setView(view);
    }

    @Override
    public ArrayAdapter<PlayerGroup> handelList(View view) {
        super.setView(view);
        Logger.log(TAG, "handelList");
        try {
            URL url= service.createUrl(ApiUrl.GROUPS);
            Logger.log(TAG, url.toString());
            service.GET(url);
            return null;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
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

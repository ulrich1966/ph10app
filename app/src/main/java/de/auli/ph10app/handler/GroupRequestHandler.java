package de.auli.ph10app.handler;

import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.auli.ph10app.R;
import de.auli.ph10app.adapter.PlayerListAdapter;
import de.auli.ph10app.model.Player;
import de.auli.ph10app.model.PlayerGroup;
import de.auli.ph10app.util.ApiUrl;
import de.auli.ph10app.util.AppLogger;

/**
 * Calls came usualy out of fragments
 */
public class GroupRequestHandler extends Handler {
    private static final AppLogger LOG = new AppLogger(GroupRequestHandler.class, true);
    private String modelList = ApiUrl.GROUPS;
    private String model = ApiUrl.GROUP_ID;

    public GroupRequestHandler(ArrayAdapter adapter, Class clazz) {
        super(adapter, clazz);
    }

    @Override
    public void GET(String apiRequest) {
        adapter.clear();
        final String url = createUrl(apiRequest);
        LOG.log("request goes to:", url);
        Object[] params = new Object[]{"GET", "application/json", url};
        execute(params);
    }

    @Override
    public void POST(String apiRequest) {
        adapter.clear();
        final String url = createUrl(apiRequest);
        LOG.log("request goes to:", url);
        Object[] params = new Object[]{"POST", "application/json", url};
        execute(params);
    }

    @Override
    public void PUT(String apiRequest) {
        adapter.clear();
        final String url = createUrl(apiRequest);
        LOG.log("request goes to:", url);
        Object[] params = new Object[]{"GET", "application/json", url};
        execute(params);
    }

    @Override
    public void DELETE(String apiRequest) {
        adapter.clear();
        final String url = createUrl(apiRequest);
        LOG.log("request goes to:", url);
        Object[] params = new Object[]{"DELETE", "application/json", url};
        execute(params);
    }

    @Override
    protected void onPostExecute(Object result) {
        super.onPostExecute(result);
        LOG.log("result:", result);
        if (result != null) {
            try {
                List<PlayerGroup> list = marshallService.marshall(result, PlayerGroup.class);
                for (PlayerGroup model : list) {
                    LOG.log(model);
                    // If you like to add Player instantly to their gropps uncommand this
                    /*
                    PlayerListAdapter listAdapter = new PlayerListAdapter(adapter.getContext(), R.layout.item_playergroup, new ArrayList<Player>());
                    PlayerRequestHandler handler = new PlayerRequestHandler(listAdapter, Player.class);
                    handler.GET(handler.createUrl(ApiUrl.PLAYER_IN_GROUP, model.getId()));
                     */
                    adapter.add(model);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        Toast.makeText(adapter.getContext(), values[0] + " von " + values[1] + " geladen", Toast.LENGTH_SHORT).show();
    }

}

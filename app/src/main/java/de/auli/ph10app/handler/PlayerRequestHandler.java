package de.auli.ph10app.handler;

import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import de.auli.ph10app.model.Player;
import de.auli.ph10app.model.PlayerGroup;
import de.auli.ph10app.util.ApiUrl;
import de.auli.ph10app.util.AppLogger;

public class PlayerRequestHandler extends Handler {
    private static final AppLogger LOG = new AppLogger(PlayerRequestHandler.class, true);
    private String modelList = ApiUrl.PLAYER;
    private String model = ApiUrl.PLAYER_ID;
    private String playerInGroup = ApiUrl.PLAYER_IN_GROUP;

    public PlayerRequestHandler(ArrayAdapter adapter, Class clazz) {
        super(adapter, clazz);
    }

    @Override
    public void GET(String apiRequest) {
        final String url = createUrl(apiRequest);
        LOG.log("request goes to:", url);
        Object[] params = new Object[]{"GET", "application/json", url};
        execute(params);
    }

    @Override
    public void POST(String apiRequest) {
        final String url = createUrl(apiRequest);
        LOG.log("request goes to:", url);
        Object[] params = new Object[]{"POST", "application/json", url};
        execute(params);
    }

    @Override
    public void PUT(String apiRequest) {
        final String url = createUrl(apiRequest);
        LOG.log("request goes to:", url);
        Object[] params = new Object[]{"GET", "application/json", url};
        execute(params);
    }

    @Override
    public void DELETE(String apiRequest) {
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
            adapter.clear();
            try {
                List<Player> list = marshallService.marshall(result, Player.class);
                for (Player model : list) {
                    LOG.log(model);
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

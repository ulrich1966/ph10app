package de.auli.ph10app.handler;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import de.auli.ph10app.model.Model;
import de.auli.ph10app.model.PlayerGroup;
import de.auli.ph10app.util.ApiUrl;
import de.auli.ph10app.util.Logger;

public class GroupRequestHandler extends Handler {
    private static final String TAG = GroupRequestHandler.class.getSimpleName();
    private String modelList = ApiUrl.GROUPS;
    private String model = ApiUrl.GROUP_ID;

    public GroupRequestHandler(ArrayAdapter adapter, Class clazz) {
        super(adapter, clazz);
    }


    @Override
    public void GET(String apiRequest) {
        final String url = createUrl(apiRequest);
        Logger.log(TAG, "request goes to:", url);
        Object[] params = new Object[]{"GET", "application/json", url};
        execute(params);
    }

    @Override
    public void POST(String apiRequest) {
        final String url = createUrl(apiRequest);
        Logger.log(TAG, "request goes to:", url);
        Object[] params = new Object[]{"POST", "application/json", url};
        execute(params);
    }

    @Override
    public void PUT(String apiRequest) {
        final String url = createUrl(apiRequest);
        Logger.log(TAG, "request goes to:", url);
        Object[] params = new Object[]{"GET", "application/json", url};
        execute(params);
    }

    @Override
    public void DELETE(String apiRequest) {
        final String url = createUrl(apiRequest);
        Logger.log(TAG, "request goes to:", url);
        Object[] params = new Object[]{"DELETE", "application/json", url};
        execute(params);
    }

    @Override
    protected void onPostExecute(Object result) {
        super.onPostExecute(result);
        Logger.log(TAG, "result:", result);
        if (result != null) {
            adapter.clear();
            try {
                List<PlayerGroup> list = marshallService.marshall(result, PlayerGroup.class);
                for (PlayerGroup model : list) {
                    Logger.log(TAG, model);
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

package de.auli.ph10app.handler;

import android.view.View;
import android.widget.ArrayAdapter;

import de.auli.ph10app.model.Model;
import de.auli.ph10app.model.PlayerGroup;
import de.auli.ph10app.util.ApiUrl;
import de.auli.ph10app.util.Logger;

public class GroupRequestHandler extends Handler {
    private static final String TAG = GroupRequestHandler.class.getSimpleName();
    private String modelList = ApiUrl.GROUPS;
    private String model = ApiUrl.GROUP_ID;
    private View currenView;

    // android.app.Service needs a Defaultconstuktor
    public GroupRequestHandler(View view) {
        super();
    }

    @Override
    public void GET(String apiRequest, ArrayAdapter adapter) {
        final String url = createUrl(apiRequest);
        Logger.log(TAG, "request goes to:", url);
        HttpRequestHandler<PlayerGroup> requestService = new HttpRequestHandler<PlayerGroup>(adapter);
        Object[] params = new Object[] {"GET", "application/json", url};
        requestService.execute(params);
    }

    @Override
    public void POST(String apiRequest, ArrayAdapter adapter) {
        final String url = createUrl(apiRequest);
        Logger.log(TAG, "request goes to:", url);
        HttpRequestHandler<Model> requestService = new HttpRequestHandler<Model>(adapter);
        Object[] params = new Object[] {"POST", "application/json", url};
        requestService.execute(params);
    }

    @Override
    public void PUT(String apiRequest, ArrayAdapter adapter) {
        final String url = createUrl(apiRequest);
        Logger.log(TAG, "request goes to:", url);
        HttpRequestHandler<Model> requestService = new HttpRequestHandler<Model>(adapter);
        Object[] params = new Object[] {"GET", "application/json", url};
        requestService.execute(params);
    }

    @Override
    public void DELETE(String apiRequest, ArrayAdapter adapter) {
        final String url = createUrl(apiRequest);
        Logger.log(TAG, "request goes to:", url);
        HttpRequestHandler<Model> requestService = new HttpRequestHandler<Model>(adapter);
        Object[] params = new Object[] {"DELETE", "application/json", url};
        requestService.execute(params);
    }
}

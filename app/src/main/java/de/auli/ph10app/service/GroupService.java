package de.auli.ph10app.service;

import android.view.View;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import org.apache.http.client.methods.HttpUriRequest;

import de.auli.ph10app.controller.RequestController;
import de.auli.ph10app.util.ApiUrl;
import de.auli.ph10app.util.Logger;

public class GroupService extends Service {
    private static final String TAG = GroupService.class.getSimpleName();
    private String modelList = ApiUrl.GROUPS;
    private String model = ApiUrl.GROUP_ID;
    private View currenView;

    // android.app.Service needs a Defaultconstuktor
    public GroupService(View view) {
        super();
    }

    @Override
    public String GET(String apiRequest, View view) {
        final String url = createUrl(apiRequest);
        Logger.log(TAG, "request goes to:", url);
        HttpRequestService requestService = new HttpRequestService(view);
        Object[] params = new Object[] {"GET", "application/json", url};
        requestService.execute(params);
        return "";
    }

    @Override
    public Object POST(String url, View view) {
        return null;
    }

    @Override
    public Object PUT(String url, View view) {
        return null;
    }

    @Override
    public Object DEL(String url, View view) {
        return null;
    }
}

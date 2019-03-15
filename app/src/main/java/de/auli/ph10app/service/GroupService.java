package de.auli.ph10app.service;

import de.auli.ph10app.util.ApiUrl;
import de.auli.ph10app.util.Logger;

public class GroupService extends Service {
    private static final String TAG = GroupService.class.getSimpleName();
    private String modelList = ApiUrl.GROUPS;
    private String model = ApiUrl.GROUP_ID;
    private GetRequestService getReq;

    public GroupService(String server) {
        super(server);
    }

    @Override
    public String GET(String url) {
        getReq = new GetRequestService(this);
        getReq.execute(url);
        return getResult();
    }

    @Override
    public String POST(String url) {
        return null;
    }

    @Override
    public String PUT(String url) {
        return null;
    }

    @Override
    public String DEL(String url) {
        return null;
    }
}

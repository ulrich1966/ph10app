package de.auli.ph10app.service;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;

import de.auli.ph10app.util.ApiUrl;

public abstract class Service implements ServiceAble {
    private static final String TAG = Service.class.getSimpleName();
    private static final String rootUrl = ApiUrl.REMOTE_BASE;
    protected ObjectMapper mapper = new ObjectMapper();

    public String createUrl(String url) {
        return String.format(url, Service.rootUrl);
    }

    public String createUrl(String url, String id$1) {
        return String.format(url, Service.rootUrl, id$1);
    }

    public String createUrl(String url, String id$1, String id$2) {
        return String.format(url, Service.rootUrl, id$1, id$2);
    }

    public String createUrl(String url, String id$1, String id$2, String id$3) {
        return String.format(url, Service.rootUrl, id$1, id$2, id$3);
    }
}

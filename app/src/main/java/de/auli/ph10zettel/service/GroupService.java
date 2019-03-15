package de.auli.ph10zettel.service;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import javax.xml.transform.Result;

import de.auli.ph10zettel.R;
import de.auli.ph10zettel.model.Model;
import de.auli.ph10zettel.util.ApiUrl;
import de.auli.ph10zettel.util.Logger;

public class GroupService<T> extends Service {
    private static final String TAG = GroupService.class.getSimpleName();
    String modelList = ApiUrl.GROUPS;
    String model = ApiUrl.GROUP_ID;

    public GroupService(String server) {
        super(server);
    }

    @Override
    public Result GET(URL url) {
      HttpRequestService.getInstance(url, "GET").start();
      return null;
    }

    @Override
    public Result POST(URL url) {
        return null;
    }

    @Override
    public Result PUT(URL url) {
        return null;
    }

    @Override
    public Result DEL(URL url) {
        return null;
    }
}

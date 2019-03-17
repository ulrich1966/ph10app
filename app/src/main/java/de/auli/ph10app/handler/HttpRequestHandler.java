package de.auli.ph10app.handler;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import de.auli.ph10app.model.Model;
import de.auli.ph10app.model.PlayerGroup;
import de.auli.ph10app.service.MarshallService;
import de.auli.ph10app.util.Logger;

public class HttpRequestHandler<T> extends AsyncTask {
    private static final String TAG = HttpRequestHandler.class.getSimpleName();
    ArrayList<T> resultList;
    ArrayAdapter<T> adapter;
    Class<T> clazz;
    MarshallService<T> marshallService = new MarshallService();

    public HttpRequestHandler(ArrayAdapter<T> adapter, Class<? extends Model> clazz) {
        this.adapter = adapter;
    }

    @Override
    protected Object doInBackground(Object[] params) {
        HttpURLConnection connection = null;
        String requestMeth = String.format("%s", params[0]);
        String contentType = String.format("%s", params[1]);
        String url$ = String.format("%s", params[2]);
        try {
            URL url = new URL(url$);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(String.format("%s", requestMeth));
            connection.setRequestProperty("Content-Type", contentType);
            //connection.setDoOutput(true);

            int responseCode = connection.getResponseCode();
            Logger.log(TAG, "Sending '" + requestMeth + "' request to URL : " + url + " expecting: " + contentType);
            Logger.log(TAG, "Response Code : " + responseCode);

            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return null;
    }
}

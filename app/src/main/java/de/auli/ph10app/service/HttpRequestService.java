package de.auli.ph10app.service;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import de.auli.ph10app.util.Logger;

public class HttpRequestService extends AsyncTask {
    private static final String TAG = HttpRequestService.class.getSimpleName();
    String result = "";
    View view;

    public HttpRequestService(View view) {
        this.view = view;
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
            //connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Content-Type", contentType);
            //connection.setDoOutput(true);

            int responseCode = connection.getResponseCode();
            Logger.log(TAG, "Sending '" + requestMeth + "' request to URL : " + url + " expecting: " + contentType);
            Logger.log(TAG, "Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            result = response.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return result;
    }

    @Override
    protected void onPostExecute(Object result) {
        super.onPostExecute(result);
        Logger.log(TAG, "result:", result);
        TextViewService.getInstance((TextView) view).setText(result);
    }

    private void readStream(InputStream in) {
    }
}

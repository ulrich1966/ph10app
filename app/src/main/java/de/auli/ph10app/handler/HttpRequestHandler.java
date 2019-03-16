package de.auli.ph10app.handler;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import de.auli.ph10app.model.Model;
import de.auli.ph10app.util.Logger;

public class HttpRequestHandler<T extends Model> extends AsyncTask {
    private static final String TAG = HttpRequestHandler.class.getSimpleName();
    String result = "";
    ArrayAdapter<T> adapter;

    public HttpRequestHandler(ArrayAdapter<T> adapter) {
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
    protected void onProgressUpdate(Object[] values) {
        Toast.makeText(adapter.getContext(), values[0] + " von " + values[1] + " geladen", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPostExecute(Object result) {
        super.onPostExecute(result);
        Logger.log(TAG, "result:", result);

    }

    private void readStream(InputStream in) {
    }
}

package de.auli.ph10app.service;

import android.os.AsyncTask;
import android.util.Log;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import de.auli.ph10app.util.Logger;

class GetRequestService extends AsyncTask<String, String, String> {
    private static final String TAG = GetRequestService.class.getSimpleName();
    private Service service;

    public GetRequestService(Service service) {
        super();
        this.service = service;
    }

    @Override
    protected String doInBackground(String... args) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response;
        String responseString = null;
        try {
            response = httpclient.execute(new HttpGet(args[0]));
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                responseString = out.toString();
                out.close();
            } else {
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (ClientProtocolException e) {
            Log.e(TAG, String.format("Request to %s faild", args[0]), e);
        } catch (IOException e) {
            Log.e(TAG, String.format("Request to %s faild", args[0]), e);
        }
        return responseString;
    }

    protected void onProgressUpdate(Integer... progress) {
        //setProgressPercent(progress[0]);
        Logger.log(TAG, "progress:", progress[0]);
    }


    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        service.setResult(result);
    }

}

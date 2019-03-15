package de.auli.ph10zettel.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestService extends Thread {
    private static final HttpRequestService ourInstance = new HttpRequestService();
    private static URL url;
    private static String requestMethod;

    public static HttpRequestService getInstance(URL url, String requestMethod) {
        HttpRequestService.url = url;
        HttpRequestService.requestMethod = requestMethod;
        return ourInstance;
    }

    private HttpRequestService() {
        super();
    }

    public void run() {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) HttpRequestService.url.openConnection();
            connection.setRequestMethod(HttpRequestService.requestMethod);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            int responseCode = connection.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


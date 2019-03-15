package de.auli.ph10app.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.MalformedURLException;

public abstract class Service implements ServiceAble {
    private static String rootUrl;
    protected ObjectMapper mapper = new ObjectMapper();
    private static String result;

    public Service(String hostAddress) {
        Service.rootUrl = hostAddress;
    }

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

    public static String getResult() {
        return result;
    }

    public static void setResult(String result) {
        Service.result = result;
    }
}

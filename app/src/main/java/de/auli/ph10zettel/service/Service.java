package de.auli.ph10zettel.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.MalformedURLException;
import java.net.URL;

import de.auli.ph10zettel.model.Model;

public abstract class Service implements ServiceAble {
    private static String rootUrl;
    protected ObjectMapper mapper = new ObjectMapper();


    public Service(String hostAddress) {
        Service.rootUrl = hostAddress;
    }

    public URL createUrl(String url) throws MalformedURLException {
        return new URL(String.format(url, Service.rootUrl));
    }

    public URL createUrl(String url, String id$1) throws MalformedURLException {
        return new URL(String.format(url, Service.rootUrl, id$1));
    }

    public URL createUrl(String url, String id$1, String id$2) throws MalformedURLException {
        return new URL(String.format(url, Service.rootUrl, id$1, id$2));
    }

    public URL createUrl(String url, String id$1, String id$2, String id$3) throws MalformedURLException {
        return new URL(String.format(url, Service.rootUrl, id$1, id$2, id$3));
    }
}

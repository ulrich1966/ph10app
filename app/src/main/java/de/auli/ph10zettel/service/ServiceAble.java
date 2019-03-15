package de.auli.ph10zettel.service;

import java.io.IOException;
import java.net.URL;

import de.auli.ph10zettel.model.Model;

interface ServiceAble<T> {
    public T GET(URL url);
    public T POST(URL url);
    public T PUT(URL url);
    public T DEL(URL url);
}

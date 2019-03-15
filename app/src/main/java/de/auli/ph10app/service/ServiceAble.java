package de.auli.ph10app.service;

interface ServiceAble<T> {
    T GET(String url);
    T POST(String url);
    T PUT(String url);
    T DEL(String url);
}

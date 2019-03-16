package de.auli.ph10app.service;

import android.view.View;

interface ServiceAble<T> {
    T GET(String url, View view);
    T POST(String url, View view);
    T PUT(String url, View view);
    T DEL(String url, View view);
}

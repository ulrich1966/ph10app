package de.auli.ph10app.handler;

import android.view.View;
import android.widget.ArrayAdapter;

import de.auli.ph10app.model.Model;
import de.auli.ph10app.model.PlayerGroup;

interface HandlerAble<T> {
    void GET(String url);
    void POST(String url);
    void PUT(String url);
    void DELETE(String url);
}

package de.auli.ph10app.handler;

import android.view.View;
import android.widget.ArrayAdapter;

import de.auli.ph10app.model.Model;
import de.auli.ph10app.model.PlayerGroup;

interface HandlerAble<T> {
    void GET(String url, ArrayAdapter<? extends Model> adapter);
    void POST(String url, ArrayAdapter<? extends Model> adapter);
    void PUT(String url, ArrayAdapter<? extends Model> adapter);
    void DELETE(String url, ArrayAdapter<? extends Model> adapter);
}

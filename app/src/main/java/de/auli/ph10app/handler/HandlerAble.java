package de.auli.ph10app.handler;

import android.view.View;
import android.widget.ArrayAdapter;

import de.auli.ph10app.model.PlayerGroup;

interface HandlerAble {
    void handelCreate(View view);
    ArrayAdapter<PlayerGroup> handelList(View view);
    void handelModel(View view, Long id);
    void handelUpdate(View view);
    void handelDelete(View view);
}

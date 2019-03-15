package de.auli.ph10zettel.handler;

import android.view.View;
import android.widget.ArrayAdapter;

import de.auli.ph10zettel.model.PlayerGroup;

interface HandlerAble {
    public void handelCreate(View view);
    public ArrayAdapter<PlayerGroup> handelList(View view);
    public void handelModel(View view, Long id);
    public void handelUpdate(View view);
    public void handelDelete(View view);
}

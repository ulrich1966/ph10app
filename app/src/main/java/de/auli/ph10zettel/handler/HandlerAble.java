package de.auli.ph10zettel.handler;

import android.view.View;

interface HandlerAble {
    public void handelCreate(View view);
    public void handelList(View view);
    public void handelModel(View view, Long id);
    public void handelUpdate(View view);
    public void handelDelete(View view);
}

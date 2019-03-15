package de.auli.ph10zettel.handler;

import android.view.View;

abstract class Handler implements HandlerAble {
    private View view;

    protected View getView() {
        return view;
    }

    protected void setView(View view) {
        this.view = view;
    }
}

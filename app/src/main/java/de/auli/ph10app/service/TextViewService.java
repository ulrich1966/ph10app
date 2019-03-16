package de.auli.ph10app.service;

import android.view.View;
import android.widget.TextView;

public class TextViewService {
    private static final TextViewService ourInstance = new TextViewService();
    private Object object;
    private static TextView currentView;

    private TextViewService() {}

    public static TextViewService getInstance(TextView view) {
        currentView = view;
        return ourInstance;
    }

    public Object getObject() {
        return object;
    }

    public void setText(Object object) {
        this.object = object;
        currentView.setText(""+object);
    }
}

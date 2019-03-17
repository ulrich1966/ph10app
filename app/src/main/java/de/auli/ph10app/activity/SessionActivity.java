package de.auli.ph10app.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import de.auli.ph10app.R;
import de.auli.ph10app.util.AppLogger;

public class SessionActivity extends AppCompatActivity {
    private static final AppLogger LOG = AppLogger.getLogger(SessionActivity.class, false);
    private static final String TAG = SessionActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);
        LOG.log("your'r arrived --> onCreate");
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

}

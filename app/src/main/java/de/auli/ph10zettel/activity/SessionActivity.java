package de.auli.ph10zettel.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import de.auli.ph10zettel.R;
import de.auli.ph10zettel.util.Logger;

public class SessionActivity extends AppCompatActivity {
    private static final String TAG = SessionActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessionstart);
        Logger.log(TAG, "your'r arrived --> onCreate");
    }
}

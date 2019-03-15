package de.auli.ph10zettel.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import de.auli.ph10zettel.R;
import de.auli.ph10zettel.util.Logger;

public class GroupActivity extends AppCompatActivity {
    private static final String TAG = GroupActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        Logger.log(TAG, "your'r arrived --> onCreate");
    }
}

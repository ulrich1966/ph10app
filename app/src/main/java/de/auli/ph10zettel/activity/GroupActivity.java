package de.auli.ph10zettel.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import de.auli.ph10zettel.R;
import de.auli.ph10zettel.util.Logger;

public class GroupActivity extends AppCompatActivity {
    private static final String TAG = GroupActivity.class.getSimpleName();

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        Logger.log(TAG, "your'r arrived --> onCreate");
    }

    public void actionNewGroup(View view) {
        Logger.log(TAG, "Moin actionNewGroup");
        Toast.makeText(GroupActivity.this, "implement create new Group", Toast.LENGTH_SHORT).show();
        //TODO run a Handler here and create new Group
    }
}

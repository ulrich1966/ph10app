package de.auli.ph10app.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import de.auli.ph10app.R;
import de.auli.ph10app.util.Logger;

public class PlayerActivity extends AppCompatActivity {
    private static final String TAG = PlayerActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Logger.log(TAG, "your'r arrived --> onCreate");
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    public void actionNewPlayer(View view) {
        Logger.log(TAG, "Moin actionNewGroup");
        Toast.makeText(PlayerActivity.this, "implement create new Player", Toast.LENGTH_SHORT).show();
        //TODO run a Handler here and create new Player
    }
}

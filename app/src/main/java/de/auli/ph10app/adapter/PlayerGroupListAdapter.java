package de.auli.ph10app.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import de.auli.ph10app.model.PlayerGroup;

public class PlayerGroupListAdapter extends ArrayAdapter {
    // rootView --> fragment_sessionstart
    private int resourceLayout;
    // aufrufende Activity
    private Context mContext;
    // Inhaltsliste
    private List<PlayerGroup> groups;

    public PlayerGroupListAdapter(Context context, int resource, List<PlayerGroup> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
        this.groups = items;
    }
}

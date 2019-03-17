package de.auli.ph10app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import de.auli.ph10app.R;
import de.auli.ph10app.adapter.GroupListAdapter;
import de.auli.ph10app.model.PlayerGroup;
import de.auli.ph10app.handler.GroupRequestHandler;
import de.auli.ph10app.util.ApiUrl;
import de.auli.ph10app.util.Logger;

public class SessionStartFragment extends Fragment {
    private static final String TAG = SessionStartFragment.class.getSimpleName();
    private GroupRequestHandler handler;
    private ViewGroup container;
    private ArrayAdapter<PlayerGroup> groupListAdapter;

    public SessionStartFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Logger.log(TAG, "you'r arrived --> onCreateView");
        this.container = container;
        View rootView = inflater.inflate(R.layout.fragment_sessionstart, container, false);
        ListView groupListView = (ListView) rootView.findViewById(R.id.livi_startsession_groups);
        groupListAdapter = new GroupListAdapter(getActivity(), R.layout.fragment_sessionstart, new ArrayList<PlayerGroup>());
        groupListView.setAdapter(groupListAdapter);
        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStart() {
        super.onStart();
        handler = new GroupRequestHandler(groupListAdapter, PlayerGroup.class);
        handler.GET(handler.createUrl(ApiUrl.GROUPS));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_session, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}

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
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import de.auli.ph10app.R;
import de.auli.ph10app.adapter.PlayerGroupListAdapter;
import de.auli.ph10app.handler.GroupRequestHandler;
import de.auli.ph10app.model.PlayerGroup;
import de.auli.ph10app.util.ApiUrl;

public class GroupFragment extends Fragment {
    private PlayerGroupListAdapter listAdapter;
    private GroupRequestHandler handler;
    private ViewGroup container;
    private ImageButton cmdAddGroup;

    public GroupFragment() {
        // Required empty public constructor
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Logger.log(TAG, "you'r arrived --> onCreateView");
        this.container = container;
        View rootView = inflater.inflate(R.layout.fragment_group, container, false);
        ListView groupListView = (ListView) rootView.findViewById(R.id.livi_groups);
        listAdapter = new PlayerGroupListAdapter(getActivity(), R.layout.fragment_group, new ArrayList<PlayerGroup>());
        groupListView.setAdapter(listAdapter);
        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStart() {
        super.onStart();
        handler = new GroupRequestHandler(listAdapter, PlayerGroup.class);
        handler.GET(handler.createUrl(ApiUrl.GROUPS));
    }

    /**
     * This happends in GroupActivity
     */
//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.menu_group, menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);
//    }
}

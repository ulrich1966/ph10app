package de.auli.ph10app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import de.auli.ph10app.R;
import de.auli.ph10app.adapter.PlayerGroupListAdapter;
import de.auli.ph10app.adapter.PlayerListAdapter;
import de.auli.ph10app.handler.GroupRequestHandler;
import de.auli.ph10app.handler.PlayerRequestHandler;
import de.auli.ph10app.model.Player;
import de.auli.ph10app.model.PlayerGroup;
import de.auli.ph10app.util.ApiUrl;
import de.auli.ph10app.util.AppLogger;

public class GroupFragment extends Fragment {
    private static final AppLogger LOG = new AppLogger(GroupFragment.class, false);
    private PlayerGroupListAdapter listAdapter;
    private GroupRequestHandler handler;
    private ViewGroup container;
    private ImageButton cmdAddGroup;
    private ImageButton cmdMore;

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
        final ListView listView;
        try {
            final View rootView = inflater.inflate(R.layout.fragment_group, container, false);
            listView = (ListView) rootView.findViewById(R.id.livi_groups);
            listAdapter = new PlayerGroupListAdapter(getActivity(), R.layout.fragment_group, new ArrayList<PlayerGroup>());
            listView.setAdapter(listAdapter);
            return rootView;
        } catch (InflateException e) {
            LOG.error(e.getMessage(), null);
        }
        return null;
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

    public void actionShowMore(View view) {
        LOG.log("Moin actionNewGroup");
        PlayerListAdapter listAdapter = new PlayerListAdapter(view.getContext(), R.layout.item_playergroup, new ArrayList<Player>());
        PlayerRequestHandler handler = new PlayerRequestHandler(listAdapter, Player.class);
        Long id = null;
        try {
            id = Long.valueOf(((TextView) view.findViewById(R.id.txt_id)).getText().toString());
            LOG.log("ID:", id);
            handler.GET(handler.createUrl(ApiUrl.PLAYER_IN_GROUP, id));
        } catch (NumberFormatException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}

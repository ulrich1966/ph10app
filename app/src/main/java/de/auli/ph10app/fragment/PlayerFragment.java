package de.auli.ph10app.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

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

import static android.content.Context.MODE_PRIVATE;
import static de.auli.ph10app.util.AppSettings.PREFS_NAME;

public class PlayerFragment extends Fragment {
    private static final AppLogger LOG = new AppLogger(PlayerFragment.class, true);
    private ViewGroup container;
    private PlayerListAdapter listAdapter;
    private PlayerRequestHandler handler;
    private Player person;

    public PlayerFragment() {
        // Activity needs defaultconstructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LOG.log("you'r arrived --> onCreateView");
        // set container for further pourose
        this.container = container;
        // find the view with listview in it and maby other elements (mostly the fragment_view)
        final View rootView = inflater.inflate(R.layout.fragment_player, container, false);
        // we need the listView witch will receive the data and witch should resist in the fragment_view we just made to the rootView
        ListView listView = (ListView) rootView.findViewById(R.id.livi_player);
        // At least have to instantiate the ArrayAdapter
        listAdapter = new PlayerListAdapter(getActivity(), R.layout.fragment_player, new ArrayList<Player>());
        // return the just created  rootView
        listView.setAdapter(listAdapter);
        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStart() {
        LOG.log("start getting data in -->   onCreateView");
        super.onStart();
        Long currentId = null;

        // You have not an Id ... bad on you  ...
        if (currentId == null) {
            //currentId = 0l;
            return;
        }

        LOG.log(currentId);

        if (currentId != null) {
            handler = new PlayerRequestHandler(listAdapter, PlayerGroup.class);
            if (currentId <= 0 || currentId == null) {
                // all Players
                LOG.log("Alle Spieler werden vom Server geholt");
                handler.GET(handler.createUrl(ApiUrl.PLAYER));
            } else {
                // Players of group
                LOG.log("Suche Spieler der Gruppe mit ID:", currentId);
                handler.GET(handler.createUrl(ApiUrl.PLAYER_IN_GROUP, currentId));
            }
        }
    }

    public void setPerson(Player person){
        this.person = person;
    }

}

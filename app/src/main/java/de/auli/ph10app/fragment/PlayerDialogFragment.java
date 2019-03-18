package de.auli.ph10app.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.auli.ph10app.R;
import de.auli.ph10app.util.AppLogger;

public class PlayerDialogFragment extends Fragment {
    private static final AppLogger LOG = new AppLogger(PlayerDialogFragment.class, true);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LOG.log("onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_test, container,false);

        //ListView groupListView = (ListView) rootView.findViewById(R.id.livi_groups);
        //listAdapter = new PlayerGroupListAdapter(getActivity(), R.layout.fragment_group, new ArrayList<PlayerGroup>());
        //groupListView.setAdapter(listAdapter);

        return rootView;
    }

    @Override
    public void onStart() {
        LOG.log("onStart");
        super.onStart();
    }
}

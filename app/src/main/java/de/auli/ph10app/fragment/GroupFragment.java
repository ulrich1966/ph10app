package de.auli.ph10app.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.auli.ph10app.R;
import de.auli.ph10app.util.Logger;

public class GroupFragment extends Fragment {
    private static final String TAG = GroupFragment.class.getSimpleName();

    public GroupFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Logger.log(TAG, "you'r arrived --> onCreateView");
        return inflater.inflate(R.layout.fragment_group, container, false);
    }
}

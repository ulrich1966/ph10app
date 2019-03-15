package de.auli.ph10zettel.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.auli.ph10zettel.R;
import de.auli.ph10zettel.util.Logger;

public class GroupFragment extends Fragment {
    private static final String TAG = GroupFragment.class.getSimpleName();

    public GroupFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Logger.log(TAG, "you'r arrived --> onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_group, container, false);
        return rootView;
    }
}

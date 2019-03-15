package de.auli.ph10zettel.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.auli.ph10zettel.R;

public class SessionStartFragment extends Fragment {
    private static final String TAG = SessionStartFragment.class.getSimpleName();

    public SessionStartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "--> onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_sessionstart, container, false);
        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}

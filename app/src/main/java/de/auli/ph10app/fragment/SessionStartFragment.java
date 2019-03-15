package de.auli.ph10app.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.auli.ph10app.R;
import de.auli.ph10app.util.Logger;

public class SessionStartFragment extends Fragment {
    private static final String TAG = SessionStartFragment.class.getSimpleName();

    public SessionStartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Logger.log(TAG, "you'r arrived --> onCreateView");
        return inflater.inflate(R.layout.fragment_sessionstart, container, false);
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}

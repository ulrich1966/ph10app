package de.auli.ph10app.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.auli.ph10app.R;
import de.auli.ph10app.util.AppLogger;

public class SessionFragment extends Fragment {
    private static final AppLogger LOG = new AppLogger(SessionFragment.class, false);
    public SessionFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LOG.log("you'r arrived --> onCreateView");
        return inflater.inflate(R.layout.fragment_session, container, false);
    }
}

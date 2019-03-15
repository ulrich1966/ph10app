package de.auli.ph10zettel.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.auli.ph10zettel.R;
import de.auli.ph10zettel.util.Logger;

public class SessionFragment extends Fragment {
    private static final String TAG = SessionFragment.class.getSimpleName();

    public SessionFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Logger.log(TAG, "yuo'r arrived --> onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_session, container, false);
        return rootView;
    }
}

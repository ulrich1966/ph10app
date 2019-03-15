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

public class PlayerFragment extends Fragment {
    private static final String TAG = PlayerFragment.class.getSimpleName();

    public PlayerFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Logger.log(TAG, "you'r arrived --> onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_player, container, false);
        return rootView;
    }
}

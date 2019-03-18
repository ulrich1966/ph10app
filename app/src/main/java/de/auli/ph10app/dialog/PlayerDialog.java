package de.auli.ph10app.dialog;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import de.auli.ph10app.R;
import de.auli.ph10app.util.AppLogger;

public class PlayerDialog<Player> extends AlertDialog {
    private static final AppLogger LOG = new AppLogger(PlayerDialog.class, true);
    private final Long id;
    private final View root;
    // LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    public PlayerDialog(View root, Long id) {
        super(root.getContext());
        this.id = id;
        this.root = root;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        LOG.log("onCreate", id);
        View dialogView = LayoutInflater.from(root.getContext()).inflate(R.layout.dialog_player, null, false);

        if (dialogView != null) {
            setContentView(dialogView);
            Button cmdOk = ((Button) dialogView.findViewById(R.id.cmd_ok_test));
            cmdOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        } else {
            setMessage("Du hast keine View");
        }
    }

    @Override
    public void show() {
        super.show();
        LOG.log("show");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LOG.log("onStart");
    }
}

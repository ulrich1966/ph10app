package de.auli.ph10app.dialog;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import de.auli.ph10app.R;
import de.auli.ph10app.adapter.PlayerListAdapter;
import de.auli.ph10app.handler.PlayerRequestHandler;
import de.auli.ph10app.model.Player;
import de.auli.ph10app.util.ApiUrl;
import de.auli.ph10app.util.AppLogger;

import static android.content.Context.MODE_PRIVATE;
import static de.auli.ph10app.util.AppSettings.PREFS_NAME;

public class PlayerDialog extends AlertDialog {
    private static final AppLogger LOG = new AppLogger(PlayerDialog.class, true);
    private final View root;
    private final String name;
    private final String groupId;
    // LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    public PlayerDialog(View root, String groupId, String name) {
        super(root.getContext());
        this.groupId = groupId;
        this.name = name;
        this.root = root;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        LOG.log("onCreate", groupId, name);
        View dialogView = LayoutInflater.from(root.getContext()).inflate(R.layout.dialog_player, null, false);

        if (dialogView != null) {
            setContentView(dialogView);
            // find & set
            final TextView txtHead = dialogView.findViewById(R.id.pld_txt_group_name);
            final Button cmdOk = ((Button) dialogView.findViewById(R.id.pld_cmd_ok));
            final ImageButton cmdClose = dialogView.findViewById(R.id.pld_cmd_close);

            txtHead.setText(this.name);

            cmdOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });

            cmdClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });

            /*
            * call in fragment
            */

             //Vesuchen die Frgament Ansicht zu bekommen ...
            final View frgmtView  = LayoutInflater.from(getContext()).inflate(R.layout.fragment_player, null, false);
            // ... in der sich das ListView - Element bfindet, in das die Daten geschrieben werden sollen.
            ListView groupListView = (ListView) frgmtView.findViewById(R.id.livi_groups);
            // ... Instanz eines ArrayAdapter besorten ...
            PlayerListAdapter listAdapter = new PlayerListAdapter(getContext(), R.layout.fragment_player, new ArrayList<Player>());
            // ... der dem Requesthaenler mitgegeben wird, damit er was hat, in dass er die Daten schreiben kann
            PlayerRequestHandler handler = new PlayerRequestHandler(listAdapter, Player.class);
            // ... jetz fehlt noch die richtige URL fuer den REST-Service und und der GET-Request wird abgeschickt.
            // ... Und waerend wir jetzt was anderes machen, fuellt der Handler in einem asynconen Task die Liste im ArrayAdapter ... vielleicht ... wenn alles gut geht ...
            handler.GET(handler.createUrl(ApiUrl.PLAYER_IN_GROUP, Long.valueOf(groupId)));

        } else {
            setMessage("Du hast keine View");
        }
    }

    @Override
    public void show() {
        super.show();
        LOG.log("show", this.groupId, this.name);

    }

    @Override
    protected void onStart() {
        super.onStart();
        LOG.log("onStart");
    }
}


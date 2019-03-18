package de.auli.ph10app.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import de.auli.ph10app.R;
import de.auli.ph10app.dialog.PlayerDialog;
import de.auli.ph10app.model.PlayerGroup;
import de.auli.ph10app.util.AppLogger;

public class PlayerGroupListAdapter extends ArrayAdapter<PlayerGroup> {
    private static final AppLogger LOG = new AppLogger(PlayerGroupListAdapter.class, true);
    // rootView --> fragment_sessionstart
    private final int resourceLayout;
    // aufrufende Activity
    private final Context context;
    // Inhaltsliste
    private final List<PlayerGroup> playerGroups;
    private View itemView;

    private PlayerGroup currentModel;
    private PlayerListAdapter listAdapter;

    public PlayerGroupListAdapter(Context context, int resource, List<PlayerGroup> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.context = context;
        this.playerGroups = items;
    }

    /**
     * Die View fuer die Eintraege beschaffen
     * Das Model aus der uebergebenen Liste holen
     * Die Einzelelemente der View beschaffen
     * Den Einzelelementen ihre Werte zuweisen
     * Die fertige View fuer die Eintraege zurueckgeben
     */
    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        this.itemView = convertView;
        if (this.itemView == null){
            this.itemView = LayoutInflater.from(context).inflate(R.layout.item_playergroup, parent, false);
        }

        currentModel = getItem(position);

        if (currentModel != null) {
            final TextView txtName = itemView.findViewById(R.id.txt_playergroup_name);
            final TextView txtId = itemView.findViewById(R.id.txt_id);
            final TextView cmdMore = itemView.findViewById(R.id.cmd_players_show);
            final ImageButton cmdAddPlayer = itemView.findViewById(R.id.cmd_add_player);
            cmdMore.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View view) {
                    LOG.log("here happends some action soon", txtId.getText());
                    //Toast.makeText(context, "There will be action soon!", Toast.LENGTH_SHORT).show();
                    try {
                        openDialog(Long.valueOf(txtId.getText().toString()), itemView);
                    } catch (NumberFormatException e) {
                        LOG.error("Wert nicht umwandelbar in Long", e);
                    }
                }
            });

            cmdAddPlayer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LOG.log("here happends some action soon");
                    Toast.makeText(context, "There will be action soon!", Toast.LENGTH_SHORT).show();
                }
            });
        }
        return itemView;
    }

    private void openDialog(Long id, View root) {
        PlayerDialog dialog = new PlayerDialog(root, id);
        dialog.show();
    }

    @Override
    public void add(PlayerGroup object) {
        super.add(object);
        LOG.log("add ID", object.getId());
    }
}

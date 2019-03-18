package de.auli.ph10app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import de.auli.ph10app.R;
import de.auli.ph10app.model.PlayerGroup;

public class StartSessionListAdapter extends ArrayAdapter<PlayerGroup> {
    // rootView --> fragment_sessionstart
    private int resourceLayout;
    // aufrufende Activity
    private Context context;
    // Inhaltsliste
    private List<PlayerGroup> playerGroups;

    public StartSessionListAdapter(Context context, int resource, List<PlayerGroup> items) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;

        if(itemView == null)
            itemView = LayoutInflater.from(context).inflate(R.layout.item_session_playergroup, parent,false);

        PlayerGroup model = getItem(position);

        if (model != null) {
            TextView txtName = itemView.findViewById(R.id.txt_playergroup_name);
            ImageButton cmdMore = itemView.findViewById(R.id.cmd_players_show);
            ImageView imgIc = itemView.findViewById(R.id.cmd_start_session);

            if (txtName != null) {
                txtName.setText(model.getName());
            }

        }

        return itemView;
    }

}
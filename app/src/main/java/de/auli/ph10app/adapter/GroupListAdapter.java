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

public class GroupListAdapter extends ArrayAdapter<PlayerGroup> {
    // rootView --> fragment_sessionstart
    private int resourceLayout;
    // aufrufende Activity
    private Context mContext;
    // Inhaltsliste
    private List<PlayerGroup> groups;

    public GroupListAdapter(Context context, int resource, List<PlayerGroup> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
        this.groups = items;
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
            itemView = LayoutInflater.from(mContext).inflate(R.layout.item_list_group, parent,false);

        PlayerGroup model = getItem(position);

        if (model != null) {
            TextView txtName = itemView.findViewById(R.id.txt_playergroup_name);
            ImageButton cmdMore = itemView.findViewById(R.id.cmd_playergroup_more);
            ImageView imgIc = itemView.findViewById(R.id.image_cards_48);
            ListView liviPlayer = itemView.findViewById(R.id.livi_plyergoup_innerlist);

            if (txtName != null) {
                txtName.setText(model.getName());
            }

        }

        return itemView;
    }

}
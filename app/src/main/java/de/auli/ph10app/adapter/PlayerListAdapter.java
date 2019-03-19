package de.auli.ph10app.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import de.auli.ph10app.R;
import de.auli.ph10app.model.Player;
import de.auli.ph10app.util.AppLogger;

public class PlayerListAdapter extends ArrayAdapter<Player> {
    private static final AppLogger LOG = new AppLogger(PlayerListAdapter.class, true);
    // rootView --> fragment_sessionstart
    private int resourceLayout;
    // aufrufende Activity
    private Context mContext;
    // Inhaltsliste
    private List<Player> player;

    public PlayerListAdapter(Context context, int resource, List<Player> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
        this.player = items;
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
            itemView = LayoutInflater.from(mContext).inflate(R.layout.item_player, parent,false);

        Player model = getItem(position);
        LOG.log("getView ID", model.getId());

        if (model != null) {
            // find & set
            final TextView txtName = itemView.findViewById(R.id.itm_txt_player_name);
            final ImageView imgAvatar = itemView.findViewById(R.id.img_player_avatar);
            // Find a nice Icon and make a Drawable from it
            final Drawable pic = getContext().getResources().getDrawable(R.drawable.ic_android72);

            txtName.setText(model.getName());

            if(model.getPic() != null && !model.getPic().isEmpty() ){
                //TODO Bilder hoch und ruterladen implementerien
                // Eisweieln git es einen default
                imgAvatar.setImageDrawable(pic);
            } else {
                imgAvatar.setImageDrawable(pic);
            }
        }
        return itemView;
    }

    @Override
    public void add(Player object) {
        super.add(object);
        LOG.log("add ID", object.getId(), object.getName());
    }
}

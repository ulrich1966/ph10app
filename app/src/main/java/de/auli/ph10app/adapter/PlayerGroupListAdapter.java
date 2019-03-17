package de.auli.ph10app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.auli.ph10app.R;
import de.auli.ph10app.handler.PlayerRequestHandler;
import de.auli.ph10app.model.Player;
import de.auli.ph10app.model.PlayerGroup;
import de.auli.ph10app.util.ApiUrl;
import de.auli.ph10app.util.AppLogger;

public class PlayerGroupListAdapter extends ArrayAdapter<PlayerGroup> {
    private static final AppLogger LOG = new AppLogger(PlayerGroupListAdapter.class, true);
    // rootView --> fragment_sessionstart
    private int resourceLayout;
    // aufrufende Activity
    private Context context;
    // Inhaltsliste
    private List<PlayerGroup> playerGroups;

    private TextView txtName;
    private TextView txtId;
    private ImageButton cmdMore;
    private ImageButton cmdAddPlayer;
    private ListView liviPlayer;
    private PlayerGroup currentModel;
    private PlayerListAdapter listAdapter;
    private static final Map<Long, PlayerGroup> mapOfModels = new HashMap<Long, PlayerGroup>();

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
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;

        if (itemView == null)
            itemView = LayoutInflater.from(context).inflate(R.layout.item_playergroup, parent, false);

        currentModel = getItem(position);

        if (currentModel != null) {
            txtName = itemView.findViewById(R.id.txt_playergroup_name);
            txtId = itemView.findViewById(R.id.txt_id);
            cmdMore = itemView.findViewById(R.id.cmd_playergroup_more);
            cmdAddPlayer = itemView.findViewById(R.id.cmd_add_player);
            liviPlayer = itemView.findViewById(R.id.livi_playgoup_innerlist);

            txtName.setText(currentModel.getName());
            LOG.log("getView ID", currentModel.getId());
            txtId.setText(String.format("%s", currentModel.getId()));

            PlayerListAdapter listAdapter = new PlayerListAdapter(context, R.layout.item_playergroup, new ArrayList<Player>());
            PlayerRequestHandler handler = new PlayerRequestHandler(listAdapter, Player.class);
            handler.GET(handler.createUrl(ApiUrl.PLAYER_IN_GROUP, currentModel.getId()));

            cmdMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(liviPlayer.getVisibility() == View.INVISIBLE){
                        liviPlayer.setVisibility(View.VISIBLE);
                    } else if(liviPlayer.getVisibility() == View.VISIBLE){
                        liviPlayer.setVisibility(View.INVISIBLE);
                    }
                }
            });

            cmdAddPlayer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "There will be action soon!", Toast.LENGTH_SHORT).show();
                }
            });

            //mapOfModels.put(currentModel.getId(), currentModel);
        }
        return itemView;
    }

    @Override
    public void add( PlayerGroup object) {
        super.add(object);
        LOG.log("add ID", object.getId());
    }




/*

        PlayerListAdapter listAdapter = new PlayerListAdapter(view.getContext(), R.layout.item_playergroup, new ArrayList<Player>());
        PlayerRequestHandler handler = new PlayerRequestHandler(listAdapter, Player.class);
        Long id = null;
        try {
            id = Long.valueOf(((TextView) view.findViewById(R.id.txt_id)).getText().toString());
            LOG.log("ID:", id);
            handler.GET(handler.createUrl(ApiUrl.PLAYER_IN_GROUP, id));
        } catch (NumberFormatException e) {
            LOG.error(e.getMessage(), e);
        }
 */

}

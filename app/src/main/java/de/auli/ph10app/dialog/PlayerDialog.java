package de.auli.ph10app.dialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import de.auli.ph10app.activity.PlayerDialogActivity;
import de.auli.ph10app.activity.PlayerGroupActivity;
import de.auli.ph10app.model.PlayerGroup;
import de.auli.ph10app.util.AppLogger;

public class PlayerDialog extends AlertDialog {
    private static final AppLogger LOG = new AppLogger(PlayerDialog.class, true);
    private final String name;
    private final Long groupId;
    private final PlayerGroupActivity rootActivity;
    // LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    public PlayerDialog(Context context, PlayerGroup model, PlayerGroupActivity rootActivity) {
        super(context);
        this.rootActivity = rootActivity;
        this.groupId = model.getId();
        this.name = model.getName();
    }

    @Override
    protected void onCreate(Bundle bundle) {
        Intent intent = new Intent(rootActivity, PlayerDialogActivity.class);
        rootActivity.startActivity(intent);
    }
    //@Override
    protected void onCreate_Suspended(Bundle bundle) {
        LOG.log("onCreate", groupId, name);
        //View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.activity_player_dialog, null, false);
        Long value = null;
//
//        if (true) {
//            setContentView(dialogView);
//            // find & set
//            final TextView txtHead = dialogView.findViewById(R.id.pld_txt_group_name);
//            final Button cmdOk = ((Button) dialogView.findViewById(R.id.pld_cmd_ok));
//            final ImageButton cmdClose = dialogView.findViewById(R.id.pld_cmd_close);
//            txtHead.setText(this.name);
//            setupClickListener(Button.class, cmdOk, this);
//            setupClickListener(ImageButton.class, cmdClose, this);

 //           final View frgmtView  = LayoutInflater.from(getContext()).inflate(R.layout.fragment_player_dialog, null, false);
//            final ListView listView = (ListView) frgmtView.findViewById(R.id.id_pdl_listview);
//            final PlayerListAdapter listAdapter = new PlayerListAdapter(getContext(), R.layout.fragment_player, new ArrayList<Player>());
//            listView.setAdapter(listAdapter);
//            final PlayerRequestHandler handler = new PlayerRequestHandler(listAdapter, Player.class);
//            handler.GET(handler.createUrl(ApiUrl.PLAYER_IN_GROUP, Long.valueOf(groupId)));


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


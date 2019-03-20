package de.auli.ph10app.dialog;

import android.content.DialogInterface;
import android.view.View;

public class DialogDismissClick {

    public static <T> void setupClickListener(Class<T> claszz, View cmd, DialogInterface dialog) {
        cmd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}

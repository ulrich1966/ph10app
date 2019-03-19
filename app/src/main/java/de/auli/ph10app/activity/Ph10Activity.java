package de.auli.ph10app.activity;

import android.support.v7.app.AppCompatActivity;

import de.auli.ph10app.model.Model;
import de.auli.ph10app.model.Player;
import de.auli.ph10app.service.MarshallService;

abstract class Ph10Activity<T extends Model> extends AppCompatActivity implements Ph10ActivityInf {
    private MarshallService<Player> marshallService = new MarshallService<>();

    public MarshallService<Player> getMarshallService() {
        return marshallService;
    }

    public void setMarshallService(MarshallService<Player> marshallService) {
        this.marshallService = marshallService;
    }
}

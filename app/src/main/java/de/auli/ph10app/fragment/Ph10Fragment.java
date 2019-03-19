package de.auli.ph10app.fragment;

import android.support.v4.app.Fragment;

import de.auli.ph10app.model.Model;
import de.auli.ph10app.model.Player;
import de.auli.ph10app.service.MarshallService;

abstract class Ph10Fragment<T extends Model> extends Fragment {
    private MarshallService<T> marshallService = new MarshallService<>();
    private Model model;

    public MarshallService<T> getMarshallService() {
        return marshallService;
    }

    public void setModel(Model model){
        this.model = model;
    }

    public Model getModel() {
        return model;
    }
}

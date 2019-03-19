package de.auli.ph10app.activity;

import android.support.v7.app.AppCompatActivity;

import de.auli.ph10app.model.Model;

abstract class Ph10Activity<T extends Model> extends AppCompatActivity implements Ph10ActivityInf {
    private Model model;

    public void setModel(Model model){
        this.model = model;
    }
}

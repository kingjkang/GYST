package com.gyst.justinkang.gyst;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.beans.PropertyChangeListener;

/**
 * Created by justinkang on 3/23/16.
 */

public class Globals extends Application{
    private static Globals instance;

    private int streak;
    private int petals;

    private SharedPreferences.Editor editor;
    private Globals(){

    }
    public void setStreak(int i){

        this.streak = i;
    }

    public int getStreak(){

        return this.streak;
    }

    public void setPetals (int i) {
        this.petals = i;
     //   sun.update();
    }

    public int getPetals () { return this.petals; }

    public static synchronized Globals getInstance(){
        if (instance == null){
            instance = new Globals();
        }
        return instance;
    }

}

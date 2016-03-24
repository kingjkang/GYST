package com.gyst.justinkang.gyst;

import android.app.Application;

/**
 * Created by justinkang on 3/23/16.
 */
public class Globals extends Application{
    private static Globals instance;

    private int streak;

    public void setStreak(int i){
        this.streak = i;
    }

    public int getStreak(){
        return this.streak;
    }

    private int petals;

    public void setPetals (int i) { this.petals = i; }

    public int getPetals () { return this.petals; }

    public static synchronized Globals getInstance(){
        if (instance == null){
            instance = new Globals();
        }
        return instance;
    }

}

package com.gyst.justinkang.gyst;

/**
 * Created by justinkang on 3/23/16.
 */
public class Globals {
    private static Globals instance;

    private int streak = 0;

    public void setStreak(int i){
        this.streak = i;
    }

    public int getStreak(){
        return this.streak;
    }

    public static synchronized Globals getInstance(){
        if (instance == null){
            instance = new Globals();
        }
        return instance;
    }

}

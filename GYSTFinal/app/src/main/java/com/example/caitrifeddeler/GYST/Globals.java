package com.example.caitrifeddeler.GYST;

/**
 * Created by CaitriFeddeler on 4/29/16.
 */
import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by justinkang on 3/23/16.
 */

public class Globals extends Application{
    private static Globals instance;
    //public static final String storage = "StorageFile";

    private int streak;
    private int petals;
    private double userLat;
    private double userLong;


    private Globals (){}
    //This is our private constructor, limiting the access to the data strictly to this class.


    private SharedPreferences.Editor editor;

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

    public double getUserLat(){
        return this.userLat;
    }

    public void setUserLat(double lat){
        this.userLat=lat;
    }
    public double getUserLong(){
        return this.userLong;
    }

    public void setUserLong(double lon){
        this.userLong=lon;
    }

    public static synchronized Globals getInstance(){
        //this function returns the instsance of that object if it is already existing, or
        //creates the new one and only isntsance of that object and returning it.
        //this makes sure that only one instance of that object is created in the status quo
        if (instance == null){
            instance = new Globals();
        }

        return instance;
    }

}

package com.gyst.justinkang.gyst;

/**
 * Created by CaitriFeddeler on 4/24/16.
 */
public class GeoPoint {
    private int latitude;
    private int longitude;

    public GeoPoint(int lat, int lon){
        this.latitude=lat;
        this.longitude=lon;
    }
    public int getLatitude(){
        return this.latitude;
    }
    public int getLongitude(){
        return this.longitude;
    }
}

package com.gyst.justinkang.gystcomp;

/**
 * Created by CaitriFeddeler on 4/24/16.
 */
public class GeoPoint {
    private double latitude;
    private double longitude;

    public GeoPoint(double lat, double lon){
        this.latitude=lat;
        this.longitude=lon;
    }
    public void setLatitude(double lat){
        this.latitude=lat;
    }
    public void setLongitude(double lon){
        this.longitude=lon;
    }
    public double getLatitude(){
        return this.latitude;
    }

    public double getLongitude(){
        return this.longitude;
    }
}

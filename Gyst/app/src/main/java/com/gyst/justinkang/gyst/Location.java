package com.gyst.justinkang.gyst;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;

import java.util.List;
import android.location.Geocoder;
import android.location.Address;
/**
 * Created by CaitriFeddeler on 4/20/16.
 */
public class Location extends Activity {

    //alarms are created in the utilities class and updated every time read calendar is called
    //alarms are recieved by the alarm receiver class which is where the geofences are created


    //This class should be where we have helper methods for the geofences and location stuff


    //Could replace GeoPoint with LatLng which is a part of google play services
    public GeoPoint getLocationFromAddress(String strAddress){

        Geocoder coder = new Geocoder(this);
        List<Address> address;
        GeoPoint p1 = null;

        try {
            address = coder.getFromLocationName(strAddress,5);
            if (address==null) {
                return null;
            }
            Address location=address.get(0);
            location.getLatitude();
            location.getLongitude();

            p1 = new GeoPoint((int) (location.getLatitude() * 1E6),
                    (int) (location.getLongitude() * 1E6));

            return p1;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return p1;
    }



}

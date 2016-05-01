package com.example.caitrifeddeler.GYST;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by CaitriFeddeler on 4/21/16.
 */
public class AlarmReceiver extends BroadcastReceiver
{
    private LocationManager locationManager;
    private String provider;
    Globals variables = Globals.getInstance();

    @Override
    public void onReceive(Context context, Intent intent) {
        //Currently this should sound an alarm 15 min before an event
        //it should just pop up a Toast with the location of the event
        Bundle bundle = intent.getExtras();
        String title = bundle.getString("event_title");
        String location = bundle.getString("event_location");
        Double eventLat = bundle.getDouble("event_latitude");
        Double eventLon = bundle.getDouble("event_longitude");


        GeoPoint eventGeo= new GeoPoint(eventLat, eventLon);

        GeoPoint userGeo=new GeoPoint(variables.getUserLat(), variables.getUserLong());

        Location locationA = new Location("point A");
        locationA.setLatitude(userGeo.getLatitude());
        locationA.setLongitude(userGeo.getLongitude());

        Location locationB = new Location("point B");
        locationB.setLatitude(eventGeo.getLatitude());
        locationB.setLongitude(eventGeo.getLongitude());

        System.out.println("user location, latitude: " + locationA.getLatitude() + " longitude: " + locationA.getLongitude());
        System.out.println("event location, latitude: " + locationB.getLatitude() + " longitude: " + locationB.getLongitude());
        float distance = locationA.distanceTo(locationB);
        System.out.println("distance between = " + distance);
        float maxDist= 5000;
        if(distance<= maxDist){
            System.out.println("attendedEvent");
            Toast.makeText(context, "attended " + title, Toast.LENGTH_LONG).show();
            attendedEvent();
        }
        else{
            System.out.println("missedEvent");
            Toast.makeText(context, "missed " + title, Toast.LENGTH_LONG).show();
            missedEvent();
        }


    }

    public void attendedEvent(){
        Globals variables = Globals.getInstance();
        int updatedStreak = 0;
        updatedStreak = variables.getStreak() + 1;
        variables.setStreak(updatedStreak);


        int updatedPetals = variables.getPetals() + 1;
        //This takes into account that the user has more than 20 petals
        variables.setPetals(updatedPetals);
    }
    public void missedEvent(){
        Globals variables = Globals.getInstance();
        int updatedStreak = 0;
        variables.setStreak(0);


        int updatedPetals = variables.getPetals() -1;
        //this takes into account the user has less than 0 petals
        if(updatedPetals<0){
            updatedPetals=0;
        }
        variables.setPetals(updatedPetals);

    }

}


/*
Things I need to know about geofences
1. Can I set a geofence to last for a certain amount of time?
2. How do I remove a geofence when this time is up?
3. How do I convert a string location into the latitude and longitude coordinates

Things our geofence will do:
1. The geofence will be created when the alarm sounds to last for 20 min
2. When the user enters the geofence it will trigger attendedEvent() and will remove the geofence
3. If the geofence is still up after 20 min the geofence will be removed and will trigger missedEvent()
 */
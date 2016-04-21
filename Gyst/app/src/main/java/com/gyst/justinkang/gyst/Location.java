package com.gyst.justinkang.gyst;

import java.util.List;

/**
 * Created by CaitriFeddeler on 4/20/16.
 */
public class Location {

    //check every 15 min check Utilities.dtstart arraylist to see if that time is between current time and current time+30 min
    //and every 15 min check if there is a fence created for an event that has passed then trigger remove geofence and missed event

    //if there is a event, check to see if the geofence is already there
    //if not create geofence
    //when user enters trigger blah



    //in GYSTCalendar anywhere we hit refreshCalendar
    //every now and then we check the dtstart arraylist in Utilities to see if any events are occuring in next 30 min
    //if an event is occuring in the next 15 min
    //we create the geofence
    //once the user enters the geofence we trigger Sunflower.attendedEvent(); then we remove geofence
    // once it is 5 min after event we remove the geofence and trigger Sunflower.missedEvent();


    public void createGeofence(String location){

    }



}

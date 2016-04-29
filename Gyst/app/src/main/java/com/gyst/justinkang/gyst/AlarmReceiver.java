package com.gyst.justinkang.gyst;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.telephony.SmsManager;

/**
 * Created by CaitriFeddeler on 4/21/16.
 */
public class AlarmReceiver extends BroadcastReceiver
{
    Sunflower sun= new Sunflower();
    @Override
    public void onReceive(Context context, Intent intent) {
        //Currently this should sound an alarm 15 min before an event
        //it should just pop up a Toast with the location of the event
        Bundle bundle = intent.getExtras();
        String location = bundle.getString("event_location");
        sun.attendedEvent();
        Toast.makeText(context, location, Toast.LENGTH_LONG).show();

        //get users

        //TODO make this more functional
        /*

        so in this class I will convert the location to latitude and longitude
        I will then I will create the geofence that lasts:
        a)until the user has entered the geofence
        or
        b) until 5 minutes after the event has started (so if I set the alarms for 15 min before the event
            we create a geofence that lasts for a total of 20 min)
         */

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
package com.gyst.justinkang.gyst;

/**
 * Created by CaitriFeddeler on 4/19/16.
 */
import java.util.ArrayList;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;


public class Utility extends Activity {
    private static Context mContext;



    public static ArrayList<String> nameOfEvent = new ArrayList<String>();

    //startdates should really be an arraylist of arraylists
    //so get(i) returns a list of dates responding to event i
    //startDates.get(i).get(5) returns the date of the 5th occurance of the event i;
    public static ArrayList<String> startDates = new ArrayList<String>();
    public static ArrayList<Long> startTime = new ArrayList<Long>();
    public static ArrayList<String> endDates = new ArrayList<String>();
    public static ArrayList<String> descriptions = new ArrayList<String>();
    public static ArrayList<String> locationOfEvent = new ArrayList<String>();
    public static ArrayList<String> recurringDates = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

    }
    public static ArrayList<String> readCalendarEvent(Context context) {
        Cursor cursor = context.getContentResolver()
                .query(Uri.parse("content://com.android.calendar/events"),
                        new String[] { "calendar_id", "title", "description",
                                "dtstart", "dtend", "eventLocation", "rdate" }, null,
                        null, null);
        cursor.moveToFirst();
        // fetching calendars name
        String CNames[] = new String[cursor.getCount()];

        // fetching calendars id
        nameOfEvent.clear();
        startTime.clear();
        startDates.clear();
        endDates.clear();
        locationOfEvent.clear();
        descriptions.clear();
        for (int i = 0; i < CNames.length; i++) {

            nameOfEvent.add(cursor.getString(1));
            startDates.add(getDate(cursor.getLong(3))); //this gives us the date
            //here I would do more stuff to make startDates a list of lists
            startTime.add(cursor.getLong(3));  //this gives us the time in milliseconds

            endDates.add(getDate(cursor.getLong(4)));
            descriptions.add(cursor.getString(2));
            locationOfEvent.add(cursor.getString(5));
            CNames[i] = cursor.getString(1);
            cursor.moveToNext();

        }

//        setAlarms();

        return nameOfEvent;
    }

    public static String getDate(long milliSeconds) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }


    //Every time the calendar is refereshed or read again to be synced the alarms are re-set to ensure they are up to date
    public void setAlarms() {

        for (int i = 0; i < Utility.nameOfEvent.size(); i++) {
            //the second part of this if statement makes sure we are only creating alarms for future events
            if ((Utility.locationOfEvent.get(i) != null)&& (Utility.startTime.get(i)>System.currentTimeMillis())) {

                long time = Utility.startTime.get(i);  //this is the time in milliseconds of the event
                time= time - (15*60*1000);  //this sets the time to 15 min before start of event
                int id = i;
                String location=Utility.locationOfEvent.get(i);

                Intent intent = new Intent(Utility.this, AlarmReceiver.class);
                intent.putExtra("event_location", location);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                        mContext.getApplicationContext(), id, intent, 0);
                AlarmManager alarmManager = (AlarmManager) mContext.getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, time, pendingIntent);  //creates alarm 15 min before event
                Toast.makeText(mContext, "Alarm set at " + getDate(i), Toast.LENGTH_LONG).show();


            }

        }
    }
}
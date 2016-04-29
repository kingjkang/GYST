package com.example.caitrifeddeler.tabtest;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.CalendarContract;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by CaitriFeddeler on 4/29/16.
 */
public class CalendarActivity  extends Activity
{

    public static ArrayList<String> nameOfEvent = new ArrayList<String>();

    public static ArrayList<String> startDates = new ArrayList<String>();
    public static ArrayList<Long> startTime = new ArrayList<Long>();
    public static ArrayList<String> endDates = new ArrayList<String>();
    public static ArrayList<String> descriptions = new ArrayList<String>();
    public static ArrayList<String> locationOfEvent = new ArrayList<String>();


    public GregorianCalendar month, itemmonth;// calendar instances.

    public CalendarAdapter adapter;// adapter instance
    public Handler handler;// for grabbing some event values for showing the dot marker.
    public ArrayList<String> items; // store calendar items which needs showing the event marker
    ArrayList<String> event;
    LinearLayout rLayout;
    ArrayList<String> date;
    ArrayList<String> desc;
    ArrayList<String> location;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_lay);
        Locale.setDefault(Locale.US);

        rLayout = (LinearLayout) findViewById(R.id.text);
        month = (GregorianCalendar) GregorianCalendar.getInstance();
        itemmonth = (GregorianCalendar) month.clone();

        items = new ArrayList<String>();

        adapter = new CalendarAdapter(this, month);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(adapter);

        handler = new Handler();
        handler.post(calendarUpdater);

        TextView title = (TextView) findViewById(R.id.title);
        title.setText(android.text.format.DateFormat.format("MMMM yyyy", month));

        RelativeLayout previous = (RelativeLayout) findViewById(R.id.previous);

        previous.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setPreviousMonth();
                refreshCalendar();
            }
        });

        RelativeLayout next = (RelativeLayout) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setNextMonth();
                refreshCalendar();

            }
        });

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                // removing the previous view if added
                if (((LinearLayout) rLayout).getChildCount() > 0) {
                    ((LinearLayout) rLayout).removeAllViews();
                }
                desc = new ArrayList<String>();
                date = new ArrayList<String>();
                location = new ArrayList<String>();
                ((CalendarAdapter) parent.getAdapter()).setSelected(v);
                String selectedGridDate = CalendarAdapter.dayString
                        .get(position);
                String[] separatedTime = selectedGridDate.split("-");
                String gridvalueString = separatedTime[2].replaceFirst("^0*",
                        "");// taking last part of date. ie; 2 from 2012-12-02.
                int gridvalue = Integer.parseInt(gridvalueString);
                // navigate to next or previous month on clicking offdays.
                if ((gridvalue > 10) && (position < 8)) {
                    setPreviousMonth();
                    refreshCalendar();
                } else if ((gridvalue < 7) && (position > 28)) {
                    setNextMonth();
                    refreshCalendar();
                }
                ((CalendarAdapter) parent.getAdapter()).setSelected(v);


                for (int i = 0; i < startDates.size(); i++) {

                    if (startDates.get(i).equals(selectedGridDate)) {
                        desc.add(nameOfEvent.get(i));
                        location.add(locationOfEvent.get(i));
                    }
                }

                if (desc.size() > 0) {
                    for (int i = 0; i < desc.size(); i++) {
                        TextView rowTextView = new TextView(CalendarActivity.this);

                        // set some properties of rowTextView or something
                        rowTextView.setText(desc.get(i));
                        rowTextView.setTextColor(Color.BLACK);

                        // add the textview to the linearlayout
                        rLayout.addView(rowTextView);

                    }

                }

                desc = null;
                location = null;

            }

        });

        FloatingActionButton addCalendarEvent = (FloatingActionButton) findViewById(R.id.AddCalendarEvent);
        addCalendarEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



// Insert Event
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setType("vnd.android.cursor.item/event");

                startActivity(intent);

            }
        });

    }
    @Override
    protected void onStart()
    {
        refreshCalendar();


        super.onStart();
    }


    @Override
    protected void onResume()
    {
        refreshCalendar();

        //clear listview
        super.onResume();
    }
    protected void setNextMonth() {
        if (month.get(GregorianCalendar.MONTH) == month
                .getActualMaximum(GregorianCalendar.MONTH)) {
            month.set((month.get(GregorianCalendar.YEAR) + 1),
                    month.getActualMinimum(GregorianCalendar.MONTH), 1);
        } else {
            month.set(GregorianCalendar.MONTH,
                    month.get(GregorianCalendar.MONTH) + 1);
        }
        ((LinearLayout) rLayout).removeAllViews();

    }

    protected void setPreviousMonth() {
        if (month.get(GregorianCalendar.MONTH) == month
                .getActualMinimum(GregorianCalendar.MONTH)) {
            month.set((month.get(GregorianCalendar.YEAR) - 1),
                    month.getActualMaximum(GregorianCalendar.MONTH), 1);
        } else {
            month.set(GregorianCalendar.MONTH,
                    month.get(GregorianCalendar.MONTH) - 1);
        }
        ((LinearLayout) rLayout).removeAllViews();

    }

    protected void showToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();

    }

    public void refreshCalendar() {
        TextView title = (TextView) findViewById(R.id.title);

        adapter.refreshDays();
        adapter.notifyDataSetChanged();
        handler.post(calendarUpdater); // generate some calendar items

        title.setText(android.text.format.DateFormat.format("MMMM yyyy", month));
    }

    public Runnable calendarUpdater = new Runnable() {

        @Override
        public void run() {
            items.clear();

            // Print dates of the current week
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            String itemvalue;
            event = readCalendarEvent(CalendarActivity.this);
            Log.d("=====Event====", event.toString());
            Log.d("=====Date ARRAY====", startDates.toString());

            for (int i = 0; i < startDates.size(); i++) {
                itemvalue = df.format(itemmonth.getTime());
                itemmonth.add(GregorianCalendar.DATE, 1);
                items.add(startDates.get(i).toString());
            }
            adapter.setItems(items);
            adapter.notifyDataSetChanged();
        }
    };
    public String getDate(long milliSeconds) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }
    public ArrayList<String> readCalendarEvent(Context context) {
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
        //eventLat.clear();
        //eventLong.clear();
        String tempLoc;
        GeoPoint tempGeo= new GeoPoint(0,0);
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
        System.out.println("called set alarms");
        setAlarms();

        return nameOfEvent;
    }


    public GeoPoint getLocationFromAddress(String strAddress){
        System.out.println("getLocationFromAddress loc: " + strAddress);
        Geocoder coder = new Geocoder(this);
        List<Address> address;
        GeoPoint p1 = null;

        try {
            address = coder.getFromLocationName(strAddress,1);
            if ((address==null)||(address.size()==0)) {
                return null;
            }

            Address location = address.get(0);
            location.getLatitude();
            location.getLongitude();

            p1 = new GeoPoint((double) (location.getLatitude()),  //removed *1E6
                    (double) (location.getLongitude()));        ////removed *1E6

            return p1;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return p1;
    }




    public void setAlarms() {

        for (int i = 0; i < nameOfEvent.size(); i++) {
            //the second part of this if statement makes sure we are only creating alarms for future events
            if ((!locationOfEvent.get(i).equals(""))&& (startTime.get(i)>System.currentTimeMillis())) {

                long time = startTime.get(i);  //this is the time in milliseconds of the event

                int id = i;
                String location=locationOfEvent.get(i);
                GeoPoint tempGeo=getLocationFromAddress(location);
                if(tempGeo!=null) {
                    Double eventLatitude = tempGeo.getLatitude();
                    Double eventLongitude = tempGeo.getLongitude();
                    Intent intent = new Intent(this, AlarmReceiver.class);
                    intent.putExtra("event_location", location);
                    intent.putExtra("event_title", nameOfEvent.get(i));
                    intent.putExtra("event_latitude", eventLatitude);
                    intent.putExtra("event_longitude", eventLongitude);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(
                            this.getApplicationContext(), id, intent, 0);
                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.set(AlarmManager.RTC_WAKEUP, time, pendingIntent);  //creates alarm 15 min before event
                    System.out.println("alarm set for " + nameOfEvent.get(id) + " at " + getDate(time) + " located at " + location);
                }
                else{
                    System.out.println("Geocoder error, no alarm set");
                    Toast.makeText(this, "Location Error for " + nameOfEvent.get(i), Toast.LENGTH_LONG).show();  //if geocoder cant find lat/lon for address
                }
            }

        }
    }


}

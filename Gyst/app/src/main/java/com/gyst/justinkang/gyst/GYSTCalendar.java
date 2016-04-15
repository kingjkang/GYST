package com.gyst.justinkang.gyst;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Calendar;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.provider.CalendarContract;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.TimeZone;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Calendar.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Calendar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GYSTCalendar extends android.app.Fragment {
    Globals variables = Globals.getInstance();


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar,
                container, false);

        FloatingActionButton addEvent = (FloatingActionButton) view.findViewById(R.id.addEvent);
        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// Construct event details
//                long startMillis = 0;
//                long endMillis = 0;
//                Calendar beginTime = Calendar.getInstance();
//                beginTime.set(2012, 9, 14, 7, 30);
//                startMillis = beginTime.getTimeInMillis();
//                Calendar endTime = Calendar.getInstance();
//                endTime.set(2012, 9, 14, 8, 45);
//                endMillis = endTime.getTimeInMillis();
//
//// Insert Event
//                Intent intent = new Intent(Intent.ACTION_INSERT)
//                        .setType("vnd.android.cursor.item/event")
//                        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
//                        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
//                        .putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY , false) // just included for completeness
//                        .putExtra(CalendarContract.Events.TITLE, "My Awesome Event")
//                        .putExtra(CalendarContract.Events.DESCRIPTION, "Heading out with friends to do something awesome.")
//                        .putExtra(CalendarContract.Events.EVENT_LOCATION, "Earth")
//                        .putExtra(CalendarContract.Events.RRULE, "FREQ=DAILY;COUNT=10")
//                        .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)
//                        .putExtra(CalendarContract.Events.ACCESS_LEVEL, CalendarContract.Events.ACCESS_PRIVATE);
//                        //.putExtra(Intent.EXTRA_EMAIL, "my.friend@example.com");
//                startActivity(intent);
//
//                long CalendarID = getId();
//                System.out.println(CalendarID);

                Intent intent = new Intent(GYSTCalendar.this.getActivity() ,EditEvent.class);
                startActivity(intent);

            }
        });

        CalendarView calendarView=(CalendarView) view.findViewById(R.id.calendarMonth);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                //Toast.makeText(getActivity().getApplicationContext(), "" + dayOfMonth, Toast.LENGTH_SHORT).show();// TODO Auto-generated method stub
                System.err.println("date was clicked " + dayOfMonth);
            }
        });

        String[] myKeys = getResources().getStringArray(R.array.sections);
        ListView list = (ListView)view.findViewById(R.id.eventList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, myKeys);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GYSTCalendar.this.getActivity() ,EditEvent.class);
                startActivity(intent);
            }
        });

        return view;
    }

}

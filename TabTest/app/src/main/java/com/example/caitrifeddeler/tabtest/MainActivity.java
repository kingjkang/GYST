package com.example.caitrifeddeler.tabtest;

import android.app.Fragment;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.*;
public class MainActivity extends TabActivity
{

    Globals variables = Globals.getInstance();
    public static final String storage = "StorageFile";
    public static final String storeStreak = "streakKey";
    public static final String storePetals = "petalsKey";
    static SharedPreferences storageLocker;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        // create the TabHost that will contain the Tabs
        final TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);


        TabSpec tab1 = tabHost.newTabSpec("First Tab");
        TabSpec tab2 = tabHost.newTabSpec("Second Tab");
        TabSpec tab3 = tabHost.newTabSpec("Third tab");

        // Set the Tab name and Activity
        // that will be opened when particular Tab will be selected
        tab1.setIndicator("Home");
        tab1.setContent(new Intent(this, GYSTflower.class));

        tab2.setIndicator("Calendar");

        tab2.setContent(new Intent(this, CalendarActivity.class));

        tab3.setIndicator("Location");
        tab3.setContent(new Intent(this, LocationActivity.class));

        /** Add the tabs  to the TabHost to display. */
        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
        //tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.LTGRAY);
        tabHost.getTabWidget().getChildAt(0)
                .setBackgroundColor(Color.parseColor("#ADD8E6"));
        tabHost.getTabWidget().getChildAt(1)
                .setBackgroundColor(Color.parseColor("#D6EBF2"));
        tabHost.getTabWidget().getChildAt(2)
                .setBackgroundColor(Color.parseColor("#D6EBF2"));


        storageLocker = getSharedPreferences(storage, Context.MODE_PRIVATE);
        int s = storageLocker.getInt(storeStreak, 0);
        int p = storageLocker.getInt(storePetals, 0);
        variables.setStreak(s);
        variables.setPetals(p);

        tabHost.setOnTabChangedListener(new OnTabChangeListener() {

            @Override
            public void onTabChanged(String tabId) {

                for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
                    tabHost.getTabWidget().getChildAt(i)
                            .setBackgroundColor(Color.parseColor("#D6EBF2")); // unselected
                }
                tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab())
                        .setBackgroundColor(Color.parseColor("#ADD8E6")); // selected

            }
        });
    }

    public void onStop(){
        super.onStop();
        storageLocker = getSharedPreferences(storage, Context.MODE_PRIVATE);
        int s = variables.getStreak();
        int p = variables.getPetals();
        SharedPreferences.Editor editor = storageLocker.edit();
        editor.putInt(storeStreak, s);
        editor.putInt(storePetals, p);
        editor.apply();
    }

    public void onStart(){
        super.onStart();
        storageLocker = getSharedPreferences(storage, Context.MODE_PRIVATE);
        int s = storageLocker.getInt(storeStreak, 0);
        int p = storageLocker.getInt(storePetals, 0);
        variables.setStreak(s);
        variables.setPetals(p);
    }
}
package com.gyst.justinkang.gystcomp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GYSTsunflower extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Globals variables = Globals.getInstance();
    int updatedStreak = 0;
    public static final String storage = "StorageFile";
    public static final String storeStreak = "streakKey";
    public static final String storePetals = "petalsKey";
    static SharedPreferences storageLocker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gystsunflower);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        //This is what happens when an event is attended
        Button attendedButton = (Button) findViewById(R.id.attendedEvent);
        attendedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attendedEvent();
            }
        });

        //This is what happens when an event is missed
        Button missedButton = (Button) findViewById(R.id.missedEvent);
        missedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                missedEvent();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        storageLocker = getSharedPreferences(storage, Context.MODE_PRIVATE);
        int s = storageLocker.getInt(storeStreak, 0);
        int p = storageLocker.getInt(storePetals, 0);
        variables.setStreak(s);
        variables.setPetals(p);

        TextView streak = (TextView) findViewById(R.id.streak);
        streak.setText(Integer.toString(variables.getStreak()));
        ImageView flower = (ImageView) findViewById(R.id.sunflower);
        flower.setImageResource(chooseFlower());
    }

    //onViewCreated transfer the info? does that method exist for activities versus fragments

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.gystsunflower, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent = new Intent(GYSTsunflower.this, GYSTcalendar.class);
            GYSTsunflower.this.startActivity(intent);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void attendedEvent(){
        updatedStreak = variables.getStreak() + 1;
        variables.setStreak(updatedStreak);
        TextView streak = (TextView) findViewById(R.id.streak);
        streak.setText(Integer.toString(variables.getStreak()));

        int updatedPetals = variables.getPetals() + 1;
        //This takes into account that the user has more than 20 petals
        if(updatedPetals>20){
            updatedPetals=20;
        }
        variables.setPetals(updatedPetals);
        ImageView flower = (ImageView) findViewById(R.id.sunflower);
        flower.setImageResource(chooseFlower());
    }
    public void missedEvent(){
        variables.setStreak(0);
        TextView streak = (TextView) findViewById(R.id.streak);
        streak.setText(Integer.toString(variables.getStreak()));

        int updatedPetals = variables.getPetals() -1;
        //this takes into account the user has less than 0 petals
        if(updatedPetals<0){
            updatedPetals=0;
        }
        variables.setPetals(updatedPetals);
        ImageView flower = (ImageView) findViewById(R.id.sunflower);
        flower.setImageResource(chooseFlower());
    }
    public int chooseFlower(){
//        String temp = "sunflower" + variables.getPetals();
//        System.out.println(temp);
//        return R.mipmap.temp;
        if (variables.getPetals() == 0){
            return R.mipmap.sunflower0;
        }
        else if (variables.getPetals() == 1){
            return R.mipmap.sunflower1;
        }
        else if (variables.getPetals() == 2){
            return R.mipmap.sunflower2;
        }
        else if (variables.getPetals() == 3){
            return R.mipmap.sunflower3;
        }
        else if (variables.getPetals() == 4){
            return R.mipmap.sunflower4;
        }
        else if (variables.getPetals() == 5){
            return R.mipmap.sunflower5;
        }
        else if (variables.getPetals() == 6){
            return R.mipmap.sunflower6;
        }
        else if (variables.getPetals() == 7){
            return R.mipmap.sunflower7;
        }
        else if (variables.getPetals() == 8){
            return R.mipmap.sunflower8;
        }
        else if (variables.getPetals() == 9){
            return R.mipmap.sunflower9;
        }
        else if (variables.getPetals() == 10){
            return R.mipmap.sunflower10;
        }
        else if (variables.getPetals() == 11){
            return R.mipmap.sunflower11;
        }
        else if (variables.getPetals() == 12){
            return R.mipmap.sunflower12;
        }
        else if (variables.getPetals() == 13){
            return R.mipmap.sunflower13;
        }
        else if (variables.getPetals() == 14){
            return R.mipmap.sunflower14;
        }
        else if (variables.getPetals() == 15){
            return R.mipmap.sunflower15;
        }
        else if (variables.getPetals() == 16){
            return R.mipmap.sunflower16;
        }
        else if (variables.getPetals() == 17){
            return R.mipmap.sunflower17;
        }
        else if (variables.getPetals() == 18){
            return R.mipmap.sunflower18;
        }
        else if (variables.getPetals() == 19){
            return R.mipmap.sunflower19;
        }
        else if (variables.getPetals() == 20){
            return R.mipmap.sunflower20;
        }
        else {
            return R.mipmap.sunflower20;
            //this happens when we reach petal max we can change image later
        }
    }
}

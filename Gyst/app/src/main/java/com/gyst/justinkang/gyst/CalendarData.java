package com.gyst.justinkang.gyst;

import java.util.ArrayList;

/**
 * Created by CaitriFeddeler on 4/26/16.
 */
public class CalendarData {

    private ArrayList<String> nameOfEvent = new ArrayList<String>();

    //startdates should really be an arraylist of arraylists
    //so get(i) returns a list of dates responding to event i
    //startDates.get(i).get(5) returns the date of the 5th occurance of the event i;
    private ArrayList<String> startDates = new ArrayList<String>();
    private ArrayList<Long> startTime = new ArrayList<Long>();
    private ArrayList<String> endDates = new ArrayList<String>();
    private ArrayList<String> descriptions = new ArrayList<String>();
    private ArrayList<String> locationOfEvent = new ArrayList<String>();
    //private ArrayList<String> recurringDates = new ArrayList<String>();

    public ArrayList<String>  getNameOfEvent(){
        return nameOfEvent;
    }
    public ArrayList<String>  getStartDates(){
        return startDates;
    }
    public ArrayList<Long>  getstartTime(){
        return startTime;
    }
    public ArrayList<String>  getEndDates(){
        return endDates;
    }
    public ArrayList<String>  getDescriptions(){
        return descriptions;
    }
    public ArrayList<String>  getLocationOfEvent(){
        return locationOfEvent;
    }


    public void  setNameOfEvent(ArrayList<String> name){
        this.nameOfEvent=name;
    }
    public void setStartDates(ArrayList<String> date){
        this.startDates=date;
    }
    public void  setstartTime(ArrayList<Long> time){
        this.startTime=time;
    }
    public void  setEndDates(ArrayList<String> end){
        this.endDates= end;
    }
    public void  setDescriptions(ArrayList<String> desc){
        this.descriptions=desc;
    }
    public void setLocationOfEvent(ArrayList<String> loc){
        this.locationOfEvent=loc;
    }
}

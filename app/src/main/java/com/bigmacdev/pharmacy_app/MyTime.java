package com.bigmacdev.pharmacy_app;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dev on 4/1/2017.
 */

public class MyTime {
    private int minutes;
    private int hours;

    public MyTime(){
        DateFormat df = new SimpleDateFormat("k");
        Date date = new Date();
        this.hours = Integer.parseInt(df.format(date));
        df = new SimpleDateFormat("m");
        this.minutes = Integer.parseInt(df.format(date));
    }

    public String printTime(){

        return hours+":"+minutes;
    }

    public void addMinutes(int extra){
        minutes+=extra;
        if (minutes>=60){
            hours+=minutes/60;
            minutes=minutes%60;
            if(hours>=24){
                hours=hours%24;
            }
        }
    }

    public void addHours(int extra){
        hours+=extra;
        if(hours>=24){
            hours=hours%24;
        }
    }

    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {

        return this.minutes+hours*60;
    }

    public boolean isEqual(MyTime other){
        if(other.getHours()==this.hours){
            if(other.getMinutes()==this.minutes){
                return true;
            }
        }
        return false;
    }

}

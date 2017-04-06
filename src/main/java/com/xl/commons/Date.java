/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xl.commons;

import java.text.SimpleDateFormat;
import java.util.Calendar;



/**
 *
 * @author anil
 */
public class Date extends java.util.Date {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    

   

    @SuppressWarnings("deprecation")
    public Date(String s) {
        super(s);
    }

    public Date() {
        super();
    }

    public Date(Long l) {
        super(l);
    }

    public Date(int year, int month, int date, int hrs, int min, int sec) {
        super(year, month, date, hrs, min, sec);
        // TODO Auto-generated constructor stub
    }

    public Date(int year, int month, int date, int hrs, int min) {
        super(year, month, date, hrs, min);
        // TODO Auto-generated constructor stub
    }

    public Date(int year, int month, int date) {
        super(year, month, date);
        // TODO Auto-generated constructor stub
    }

    public Date(long date) {
        super(date);
        // TODO Auto-generated constructor stub
    }

    
    public static Boolean isDatesAreEqual(String s1, String s2) {

        java.util.Date d1 = new java.util.Date(s1);
        java.util.Date d2 = new java.util.Date(s2);

        if (d1.compareTo(d2) == 0) {

            return true;
        } else {
            return false;
        }

    }

    public static Boolean isDatesAreEqual(java.util.Date d1, java.util.Date d2) {

        if (d1.compareTo(d2) == 0) {

            return true;
        } else {
            return false;
        }

    }
    
    public Date nextDate(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(this);
        cal.add(Calendar.DATE, 1); //minus number would decrement the days
        
        return toDate(cal.getTime());
        
    }
    
   public String toString(String pattern){
       SimpleDateFormat formatter = new SimpleDateFormat(pattern);
       return formatter.format(this);
   }

public static Date toDate(java.util.Date date){
    return new Date(date.getYear(),date.getMonth(),date.getDate(),date.getHours(),date.getMinutes(),date.getSeconds());
}

public static Date toVizzarioDate(java.util.Date date){
    return new Date(date.getYear(),date.getMonth(),date.getDate());
}

public static Boolean compareDate(Date date1, Date date2) {
    if (date1.getYear() == date2.getYear() &&
        date1.getMonth() == date2.getMonth() &&
        date1.getDate() == date2.getDate()) {
      return true ;
    } 
    return false;
}

public static java.sql.Date toSQLDate(Date d){
    
    java.sql.Date date=new java.sql.Date(d.getTime());
    return date;
}
   
}

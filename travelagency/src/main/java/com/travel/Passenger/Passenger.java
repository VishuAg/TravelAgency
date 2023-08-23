package com.travel.Passenger;

import java.util.ArrayList;

import com.travel.TravelPackage.Activity;

public abstract class Passenger {
    String name;
    String passengerNo;
    ArrayList<Activity> activities;
    public Passenger(String name, String passengerNo){
        this.name=name;
        this.passengerNo=passengerNo;
        this.activities = new ArrayList<>();
    }
    public abstract void bookActivity(Activity a);
    public abstract void viewMyDetails();
    public boolean addActivity(Activity a){
        int capacity = a.getCapacity();
        if(capacity==0){
            System.out.println("Capacity Full");
            return false;
        }
        this.activities.add(a);
        a.reduceCapacity();
        return true;
      }
      public String getPassengerNo() {
          return passengerNo;
      }
}

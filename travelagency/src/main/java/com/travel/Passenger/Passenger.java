package com.travel.Passenger;

import java.util.HashMap;

import com.travel.Passenger.PassengerUtil.PassengerType;
import com.travel.TravelPackage.Activity;

public abstract class Passenger {
    String name;
    String passengerNo;
    HashMap<Integer, Activity> activities;
    public Passenger(String name, String passengerNo){
        this.name=name;
        this.passengerNo=passengerNo;
        this.activities = new HashMap<>();
    }
    public abstract void bookActivity(Activity a);
    public abstract void viewMyDetails();
    public boolean addActivity(Activity a){
        int capacity = a.getCapacity();
        if(capacity==0){
            System.out.println("Capacity Full");
            return false;
        }
        this.activities.put(a.getActivityId(),a);
        a.reduceCapacity();
        System.out.println("Added successfully");
        return true;
      }
      public String getPassengerNo() {
          return passengerNo;
      }
      public String getName() {
          return name;
      }
      public HashMap<Integer, Activity> getActivities() {
          return activities;
      }
      public static PassengerType getPassengerType(String passengerType){
        switch(passengerType){
            case "GOLD": return PassengerType.GOLD;
            case "PREMIUM": return PassengerType.PREMIUM;
            default: return PassengerType.STANDARD;
        }
      }
}

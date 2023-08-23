package com.travel.TravelPackage;
import java.util.HashMap;

import com.travel.Utils.PrintHelper;

public class Destination {
    int destinationId;
    String name;
    HashMap<Integer, Activity> activities;
    public Destination(int destinationId, String name){
        this.name = name;
        this.activities = new HashMap<>();
    }
    public HashMap<Integer,Activity> getActivities() {
        return activities;
    }
    public int getDestinationId() {
        return destinationId;
    }
    public String getName() {
        return name;
    }
    public void addActivities(int activityId, Activity ac){
        this.activities.put(activityId, ac);
    }
    public void showActivites(){
        PrintHelper.printActivities(activities);
        return;
    }
    public Activity getActivityById(int activityId){
        return this.activities.get(activityId);
    }
}

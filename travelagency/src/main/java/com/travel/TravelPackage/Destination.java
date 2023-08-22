package com.travel.TravelPackage;

import java.util.ArrayList;

public class Destination {
    int destinationId;
    String name;
    ArrayList<Acitivity> activities;
    public Destination(int destinationId, String name){
        this.destinationId = destinationId;
        this.name = name;
        this.activities = new ArrayList<>();
    }
    public ArrayList<Acitivity> getActivities() {
        return activities;
    }
    public int getDestinationId() {
        return destinationId;
    }
    public String getName() {
        return name;
    }
    public void addActivities(Acitivity ac){
        this.activities.add(ac);
    }
}

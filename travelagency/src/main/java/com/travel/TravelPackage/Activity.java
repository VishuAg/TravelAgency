package com.travel.TravelPackage;

public class Activity {
    private int activityId;
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private int destinationId;
    public Activity(int activityId, String name, String desc, double cost, int capacity, int destinationId){
        this.activityId = activityId;
        this.name = name;
        this.description = desc;
        this.cost = cost;
        this.capacity = capacity;
        this.destinationId = destinationId;
    }
    public int getActivityId() {
        return activityId;
    }
    public int getCapacity() {
        return capacity;
    }
    public double getCost() {
        return cost;
    }
    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }
    public int getDestinationId() {
        return destinationId;
    }
    public void setDestinationId(int destinationId) {
        if(this.destinationId != 0){
            this.destinationId = destinationId;
        }
        return;
    }
    public void reduceCapacity(){
        this.capacity = this.capacity -1;
    }
    public static void showAvailableActivities(){
        
    }
}

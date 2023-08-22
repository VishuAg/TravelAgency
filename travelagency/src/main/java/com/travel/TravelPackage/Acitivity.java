package com.travel.TravelPackage;

public class Acitivity {
    private int activityId;
    private String name;
    private String description;
    private int cost;
    private int capacity;
    private int destinationId;
    public Acitivity(int activityId, String name, String desc, int cost, int capacity){
        this.activityId = activityId;
        this.name = name;
        this.description = desc;
        this.cost = cost;
        this.capacity = capacity;
    }
    public int getActivityId() {
        return activityId;
    }
    public int getCapacity() {
        return capacity;
    }
    public int getCost() {
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
}

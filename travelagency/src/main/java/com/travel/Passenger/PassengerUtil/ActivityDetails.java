package com.travel.Passenger.PassengerUtil;

import com.travel.TravelPackage.Activity;

public class ActivityDetails {
    private double cost;
    private Activity activity;
    public ActivityDetails(double cost, Activity a){
        this.cost = cost;
        this.activity = a;
    }
    public Activity getActivity() {
        return activity;
    }
    public double getCost() {
        return cost;
    }
    public void setActivity(Activity activity) {
        this.activity = activity;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

}

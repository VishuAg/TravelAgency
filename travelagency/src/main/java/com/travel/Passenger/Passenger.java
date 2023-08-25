package com.travel.Passenger;

import java.util.HashMap;

import com.travel.Passenger.PassengerUtil.ActivityDetails;
import com.travel.Passenger.PassengerUtil.PassengerType;
import com.travel.TravelPackage.Activity;

/**
 * The class Abstract passenger
 */
public abstract class Passenger {
    String name;
    String passengerNo;
    PassengerType passengerType;
    HashMap<Integer, ActivityDetails> activities;

    /**
     *
     * Passenger
     *
     * @param name        the name.
     * @param passengerNo the passenger number.
     */
    public Passenger(String name, String passengerNo) {

        this.name = name;
        this.passengerNo = passengerNo;
        this.activities = new HashMap<>();
    }

    /**
     *
     * Book activity
     *
     * @param a the a.
     * @return boolean
     */
    public abstract boolean bookActivity(Activity a);

    public abstract void viewMyDetails();

    public abstract PassengerType getPassengerType();

    public boolean addActivity(Activity a) {

        int capacity = a.getCapacity();
        if (capacity == 0) {
            System.out.println("\nCapacity Full");
            return false;
        }
        if(this.getActivityById(a.getActivityId())!=null){
            System.out.println("\nAlready registered. Please chose another activity");
            return false;
        }
        a.reduceCapacity();
        System.out.println("Added successfully");
        return true;
    }

    /**
     *
     * Gets the passenger number
     *
     * @return the passenger number
     */
    public String getPassengerNo() {

        return passengerNo;
    }

    /**
     *
     * Gets the name
     *
     * @return the name
     */
    public String getName() {

        return name;
    }

    /**
     *
     * Gets the activities
     *
     * @return the activities
     */
    public HashMap<Integer, ActivityDetails> getActivities() {

        return activities;
    }

    /**
     *
     * Gets the activities by id
     *
     * @return the activity
     */
    public Activity getActivityById(int activitiyId){
        ActivityDetails activityDetails = this.getActivities().get(activitiyId);
        if(activityDetails!=null){
            return activityDetails.getActivity();
        }
        return null;
    }

}

package com.travel.Passenger;

import com.travel.Passenger.PassengerUtil.ActivityDetails;
import com.travel.TravelPackage.Activity;
import com.travel.Utils.PrintHelper;

public class PremiumPassenger extends Passenger {
    private final int discountPercentage = 100;
    private final double balance = Double.MAX_VALUE;
    public PremiumPassenger(String name, String passengerNo){
       super(name, passengerNo);
        
    }
    public boolean bookActivity(Activity a){
        if(addActivity(a)){
             this.activities.put(a.getActivityId(),new ActivityDetails(0, a));
             return true;
        }
        return false;
    }
    public void viewMyDetails(){
       printPassengerDetails();
    }
    public double getBalance() {
        return balance;
    }
    public int getDiscountPercentage() {
        return discountPercentage;
    }
    public void printPassengerDetails(){
        System.out.println("\t\tPassenger Name: "+this.getName() +
                     " Passenger no : " + this.getPassengerNo());
        
        PrintHelper.printActivitiesEnrolledByPassenger(this.getActivities());
    }
}

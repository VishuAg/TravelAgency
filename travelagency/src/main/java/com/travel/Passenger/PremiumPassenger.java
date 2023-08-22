package com.travel.Passenger;

import com.travel.TravelPackage.Activity;

public class PremiumPassenger extends Passenger {
    int discountPercentage = 100;
    public PremiumPassenger(String name, int passengerNo){
       super(name, passengerNo);
        
    }
    public void bookActivity(Activity a){
        addActivity(a);
        return;
    }
    public void viewMyDetails(int passengerNo){

    }
}

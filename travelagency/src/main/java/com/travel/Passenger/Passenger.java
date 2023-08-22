package com.travel.Passenger;

import com.travel.TravelPackage.TravelPackage;

public abstract class Passenger {
    String name;
    int passengerNo;
    public Passenger(String name, int passengerNo){
        this.name=name;
        this.passengerNo=passengerNo;
    }
    public abstract void bookPackage(TravelPackage packageId);
    public abstract void viewMyDetails(int passengerNo);
}

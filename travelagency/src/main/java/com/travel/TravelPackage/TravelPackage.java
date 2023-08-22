package com.travel.TravelPackage;

import java.util.ArrayList;

import com.travel.Passenger.Passenger;
public class TravelPackage {
    int packageId;
    String name;
    int capacity;
    ArrayList<Itinerary> itineraries;
    ArrayList<Passenger> passengers;
    public TravelPackage(int packageId, String name, int capacity){
        this.packageId =packageId;
        this.name= name;
        this.capacity = capacity;
        itineraries = new ArrayList<>();
        passengers = new ArrayList<>();
    }
    public int getCapacity() {
        return capacity;
    }
    public ArrayList<Itinerary> getItineraries() {
        return itineraries;
    }
    public String getName() {
        return name;
    }
    public int getPackageId() {
        return packageId;
    }
    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }
    public void addItinerary(Itinerary it){
        this.itineraries.add(it);
    }
    public void addPassenger(Passenger pass){
        this.passengers.add(pass);
    }

}

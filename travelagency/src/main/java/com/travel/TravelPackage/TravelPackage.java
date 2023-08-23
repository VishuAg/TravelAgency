package com.travel.TravelPackage;

import java.util.ArrayList;
import java.util.HashMap;

import com.travel.Passenger.Passenger;
import com.travel.Utils.PrintHelper;
public class TravelPackage {
    String name;
    int capacity;
    HashMap<Integer,Destination> destination;
    ArrayList<Passenger> passengers;
    public TravelPackage(String name, int capacity){
        this.name= name;
        this.capacity = capacity;
        destination = new HashMap<>();
        passengers = new ArrayList<>();
    }
    public int getCapacity() {
        return capacity;
    }
    public HashMap<Integer, Destination> getAllDestination() {
        return destination;
    }
    public String getName() {
        return name;
    }
    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }
    public void addDestinationToPackage(Integer destinationId, Destination destination){
        this.destination.put(destinationId, destination);
    }
    public void addPassengerToPackage(Passenger pass){
        this.passengers.add(pass);
    }
    public void showDestinations(){
       HashMap<Integer, Destination> destinations =  this.getAllDestination();
       PrintHelper.printDestinations(destinations);
    }
    public Destination getDestinationById(int destinationId){
        return this.getAllDestination().get(destinationId);
    }
}

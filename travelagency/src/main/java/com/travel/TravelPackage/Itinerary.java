package com.travel.TravelPackage;

import java.util.ArrayList;

public class Itinerary {
    int itineraryId;
    ArrayList<Destination> destinations;
    public Itinerary(int itineraryId){
        this.itineraryId = itineraryId;
        this.destinations = new ArrayList<>();
    }
    public int getItineraryId() {
        return itineraryId;
    }
    public ArrayList<Destination> getDestinations() {
        return destinations;
    }
    public void addDestination(Destination dest){
        this.destinations.add(dest);
    }
}

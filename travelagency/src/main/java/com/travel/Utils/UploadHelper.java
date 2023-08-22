package com.travel.Utils;

import java.util.ArrayList;

import com.travel.TravelPackage.Destination;
import com.travel.TravelPackage.Itinerary;
import com.travel.TravelPackage.TravelPackage;

public class UploadHelper {
    public static ArrayList<TravelPackage> getPackages(){
        ArrayList<TravelPackage> travelPackages=new ArrayList<>();
        TravelPackage travelPackage = new TravelPackage(1, "Package 1", 10);
        Itinerary it =new Itinerary(1);
        Destination d =new Destination(1,"Delhi");
        it.addDestination(d);
        travelPackage.addItinerary(it);
        travelPackages.add(travelPackage);
        return travelPackages;
    }
}

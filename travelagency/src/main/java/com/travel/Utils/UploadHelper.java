package com.travel.Utils;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.travel.Passenger.Passenger;
import com.travel.Passenger.StandardPassenger;
import com.travel.Passenger.PassengerUtil.PassengerFactory;
import com.travel.Passenger.PassengerUtil.PassengerType;
import com.travel.TravelPackage.Activity;
import com.travel.TravelPackage.Destination;
import com.travel.TravelPackage.TravelPackage;

public class UploadHelper {
    public static HashMap<Integer, TravelPackage> getPackages() {
        return populateTravelPackages();
    }

    public static HashMap<String, Passenger> getPassengers() {
        HashMap<String, Passenger> registeredPassengers = new HashMap<>();
        StandardPassenger p = (StandardPassenger) PassengerFactory.getPassenger(PassengerType.STANDARD, "Vishnu",
                "9165292821");
        p.addBalance(100);
        registeredPassengers.put(p.getPassengerNo(), p);
        return registeredPassengers;
    }

    public static HashMap<Integer, TravelPackage> populateTravelPackages() {
        JSONParser parser = new JSONParser();
        HashMap<Integer, TravelPackage> travelPackages = new HashMap<>();
        try {
            Object obj = parser.parse(new FileReader("travelagency/src/data/TravelPackages.json"));
            JSONObject packageObject = new JSONObject();
            JSONObject destinationObject = new JSONObject();
            JSONObject activityObject = new JSONObject();
            TravelPackage travelPackage;
            Destination d;
            Activity a;
            JSONArray packages = (JSONArray) obj;
            Iterator packageIterator = packages.iterator();
            Iterator destinationIterator;
            Iterator activityIterator;
            while (packageIterator.hasNext()) {
                packageObject = (JSONObject) (packageIterator.next());
                String packageName = (String) packageObject.get("name");
                int packageCapacity = ((Number) packageObject.get("capacity")).intValue();
                travelPackage = new TravelPackage(packageName,packageCapacity);
                JSONArray destination = (JSONArray) packageObject.get("destination");
                destinationIterator = destination.iterator();
                 while (destinationIterator.hasNext()) {
                    destinationObject = (JSONObject) (destinationIterator.next());
                    int destinationId = ((Number)destinationObject.get("destinationId")).intValue();
                    String name = (String)destinationObject.get("name");
                Destination dest = new Destination(destinationId, name);
                travelPackage.addDestinationToPackage(destinationId, dest);
                JSONArray activity = (JSONArray) destinationObject.get("activities");
                activityIterator = activity.iterator();
                 while (activityIterator.hasNext()) {
                    activityObject = (JSONObject) (activityIterator.next());
                    int activityId = ((Number)activityObject.get("activityId")).intValue();
                    String activityName = (String)activityObject.get("name");
                    String description = (String)activityObject.get("description");
                    double cost = (double)activityObject.get("cost");
                    int capacity = ((Number)activityObject.get("capacity")).intValue();
                    dest.addActivities(activityId, new Activity(activityId, activityName, description, cost, capacity, destinationId));
               
            }
             travelPackage.addDestinationToPackage(destinationId, dest);
           
        }
         travelPackages.put(travelPackages.size(), travelPackage);
    }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return travelPackages;
    }
}

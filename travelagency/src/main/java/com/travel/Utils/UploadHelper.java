package com.travel.Utils;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.travel.Passenger.Passenger;
import com.travel.Passenger.PassengerUtil.PassengerFactory;
import com.travel.Passenger.PassengerUtil.PassengerType;
import com.travel.TravelPackage.Activity;
import com.travel.TravelPackage.Destination;
import com.travel.TravelPackage.TravelPackage;

/**
 * The class Upload helper
 */
public class UploadHelper {

    /**
     *
     * Gets the packages
     *
     * @return the packages
     */
    public static HashMap<Integer, TravelPackage> getPackages() {

        return populateTravelPackages();
    }

    /**
     *
     * Gets the passengers
     *
     * @return the passengers
     */
    public static HashMap<String, Passenger> getPassengers() {

        JSONParser parser = new JSONParser();
        HashMap<String, Passenger> registeredPassengers = new HashMap<>();
        try {
            Object obj = parser.parse(new FileReader("src/main/resources/data/Passengers.json"));
            JSONObject passengerObject = new JSONObject();
            JSONArray passengers = (JSONArray) obj;
            Iterator<JSONObject> passengersIterator = passengers.iterator();
            while (passengersIterator.hasNext()) {
                passengerObject = (JSONObject) (passengersIterator.next());
                String passengerNo = (String) passengerObject.get("passengerNo");
                String name = (String) passengerObject.get("name");
                String passengerType = (String) passengerObject.get("type");
                PassengerType pt = PassengerType.valueOf(passengerType);
                Passenger p = PassengerFactory.getPassenger(pt, name, passengerNo);
                registeredPassengers.put(p.getPassengerNo(), p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return registeredPassengers;
    }

    /**
     *
     * Populate travel packages
     *
     * @return TravelPackage>
     */
    public static HashMap<Integer, TravelPackage> populateTravelPackages() {

        JSONParser parser = new JSONParser();
        HashMap<Integer, TravelPackage> travelPackages = new HashMap<>();
        try {
            Object obj = parser.parse(new FileReader("src/main/resources/data/TravelPackages.json"));
            JSONObject packageObject = new JSONObject();
            JSONObject destinationObject = new JSONObject();
            JSONObject activityObject = new JSONObject();
            TravelPackage travelPackage;
            Destination dest;
            JSONArray packages = (JSONArray) obj;
            Iterator<JSONObject> packageIterator = packages.iterator();
            Iterator<JSONObject> destinationIterator;
            Iterator<JSONObject> activityIterator;
            while (packageIterator.hasNext()) {
                packageObject = packageIterator.next();
                String packageName = (String) packageObject.get("name");
                int packageCapacity = ((Number) packageObject.get("capacity")).intValue();
                travelPackage = new TravelPackage(packageName, packageCapacity);
                JSONArray destination = (JSONArray) packageObject.get("destination");
                destinationIterator = destination.iterator();
                while (destinationIterator.hasNext()) {
                    destinationObject = (JSONObject) (destinationIterator.next());
                    int destinationId = ((Number) destinationObject.get("destinationId")).intValue();
                    String name = (String) destinationObject.get("name");
                    dest = new Destination(destinationId, name);
                    travelPackage.addDestinationToPackage(destinationId, dest);
                    JSONArray activity = (JSONArray) destinationObject.get("activities");
                    activityIterator = activity.iterator();
                    while (activityIterator.hasNext()) {
                        activityObject = (JSONObject) (activityIterator.next());
                        int activityId = ((Number) activityObject.get("activityId")).intValue();
                        String activityName = (String) activityObject.get("name");
                        String description = (String) activityObject.get("description");
                        double cost = (double) activityObject.get("cost");
                        int capacity = ((Number) activityObject.get("capacity")).intValue();
                        dest.addActivities(activityId,
                                new Activity(activityId, activityName, description, cost, capacity, destinationId));

                    }
                    travelPackage.addDestinationToPackage(destinationId, dest);

                }
                travelPackages.put(travelPackages.size() + 1, travelPackage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return travelPackages;
    }
}

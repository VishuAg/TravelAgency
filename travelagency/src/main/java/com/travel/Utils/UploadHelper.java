package com.travel.Utils;
import java.util.HashMap;
import com.travel.Passenger.Passenger;
import com.travel.Passenger.StandardPassenger;
import com.travel.Passenger.PassengerUtil.PassengerFactory;
import com.travel.Passenger.PassengerUtil.PassengerType;
import com.travel.TravelPackage.Destination;
import com.travel.TravelPackage.TravelPackage;

public class UploadHelper {
    public static HashMap<Integer, TravelPackage> getPackages(){
        HashMap<Integer, TravelPackage>  travelPackages=new HashMap<Integer, TravelPackage>();
        TravelPackage travelPackage = new TravelPackage("Package 1", 10);
        Destination d =new Destination(1,"Delhi");
        travelPackage.addDestinationToPackage(1, d);
        travelPackages.put(1, travelPackage);
        return travelPackages;
    }
    public static HashMap<String, Passenger> getPassengers(){
        HashMap<String, Passenger> registeredPassengers=new HashMap<>();
        StandardPassenger p = (StandardPassenger)PassengerFactory.getPassenger(PassengerType.STANDARD, "Vishnu", "9165292821");
        p.addBalance(100);
        registeredPassengers.put(p.getPassengerNo(), p);
        return registeredPassengers;
    }
}

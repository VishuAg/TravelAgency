package com.travel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.travel.Passenger.Passenger;
import com.travel.Passenger.StandardPassenger;
import com.travel.Passenger.PassengerUtil.PassengerFactory;
import com.travel.Passenger.PassengerUtil.PassengerType;
import com.travel.TravelPackage.Activity;
import com.travel.TravelPackage.Destination;
import com.travel.TravelPackage.TravelPackage;
import com.travel.Utils.OperationHelper;
import com.travel.Utils.PrintHelper;
import com.travel.Utils.UploadHelper;

public class TravelAgency {
    private Scanner sc = new Scanner(System.in);
    private HashMap<Integer, TravelPackage> travelPackages;
    private HashMap<String, Passenger> registeredPassengers;

    public TravelAgency() {
        populatePassengers();
        populatePackages();
    }

    private void populatePackages() {
        travelPackages = UploadHelper.getPackages();
    }

    private void populatePassengers() {
        registeredPassengers = UploadHelper.getPassengers();
    }

    public void start() {
        PrintHelper.viewMainMenu();
        int operation = sc.nextInt();
        OperationHelper.execute(this, operation);
    }
    public HashMap<String, Passenger> getAllRegisteredPassengers() {
        return registeredPassengers;
    }

    public HashMap<Integer, TravelPackage> getTravelPackages() {
        return travelPackages;
    }

    public void viewPackages() {
        PrintHelper.printPackages(travelPackages);
        start();
        return;
    }

    public String registerPassengerToTravelAgency() {
        System.out.println("\n Enter Passenger Name");
        String passengerName = sc.next();
        System.out.println("\n Enter Passenger No");
        String passengerNo = sc.next();
        Passenger p = (StandardPassenger) PassengerFactory.getPassenger(PassengerType.STANDARD, passengerName,
                passengerNo);
        registeredPassengers.put(passengerNo, p);
        System.out.println("\nPassenger is registered");
        return passengerNo;
    }

    public Passenger getRegisteredPassengerById(String passengerNo) {
        return this.registeredPassengers.get(passengerNo);
    }
    public TravelPackage getTravelPackage(int packageNo){
        return this.travelPackages.get(packageNo);
    }

    public void showAvailableActivities() {
        HashMap<Integer, Activity> activities = new HashMap<>();
        HashMap<Integer, TravelPackage> travelPackages = this.getTravelPackages();
        for (Map.Entry<Integer, TravelPackage> m : travelPackages.entrySet()) {
            for (Map.Entry<Integer, Destination> dest : m.getValue().getAllDestination().entrySet()) {
                for (Map.Entry<Integer, Activity> act : dest.getValue().getActivities().entrySet()) {
                    if (act.getValue().getCapacity() > 0) {
                        activities.put(act.getKey(), act.getValue());
                    }
                }
            }
        }
        PrintHelper.printActivities(activities);
    }
    public void getPackageDetails(){
        System.out.println("Enter Package no: ");
        int travelPackageNo = sc.nextInt();
        this.getTravelPackage(travelPackageNo).showPackageDetails();
    }
}

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

/**
 * The class Travel agency
 */
public class TravelAgency {
    private Scanner sc = new Scanner(System.in);
    private HashMap<Integer, TravelPackage> travelPackages;
    private HashMap<String, Passenger> registeredPassengers;

    /**
     *
     * It is a constructor.
     *
     */
    public TravelAgency() {

        populatePassengers();
        populatePackages();
    }

    /**
     *
     * Populate packages
     *
     */
    private void populatePackages() {

        travelPackages = UploadHelper.getPackages();
    }

    /**
     *
     * Populate passengers
     *
     */
    private void populatePassengers() {

        registeredPassengers = UploadHelper.getPassengers();
    }

    /**
     *
     * Start
     *
     */
    public void start() {

        PrintHelper.viewMainMenu();
        int operation = sc.nextInt();
        OperationHelper.execute(this, operation);
    }

    /**
     *
     * Gets the all registered passengers
     *
     * @return the all registered passengers
     */
    public HashMap<String, Passenger> getAllRegisteredPassengers() {

        return registeredPassengers;
    }

    /**
     *
     * Gets the travel packages
     *
     * @return the travel packages
     */
    public HashMap<Integer, TravelPackage> getTravelPackages() {

        return travelPackages;
    }

    /**
     *
     * View packages
     *
     */
    public void viewPackages() {

        PrintHelper.printPackages(travelPackages);
        start();
        return;
    }

    /**
     *
     * Register passenger to travel agency
     *
     * @return String
     */
    public String registerPassengerToTravelAgency() {

        System.out.println("\n Enter Passenger Name");
        String passengerName = sc.next();
        System.out.println("\n Enter Passenger No");
        String passengerNo = sc.next();
        if (registeredPassengers.get(passengerNo) != null) {
            System.out.println("\nPassenger is already registered with this passenger No");
            System.out.println("Please Enter valid details");
            registerPassengerToTravelAgency();
        }
        Passenger p = (StandardPassenger) PassengerFactory.getPassenger(PassengerType.STANDARD, passengerName,
                passengerNo);
        registeredPassengers.put(passengerNo, p);
        System.out.println("\nPassenger is registered");
        return passengerNo;
    }

    /**
     *
     * Gets the registered passenger by identifier
     *
     * @param passengerNo the passenger number.
     * @return the registered passenger by identifier
     */
    public Passenger getRegisteredPassengerById(String passengerNo) {

        return this.registeredPassengers.get(passengerNo);
    }

    /**
     *
     * Gets the travel package
     *
     * @param packageNo the package number.
     * @return the travel package
     */
    public TravelPackage getTravelPackage(int packageNo) {

        return this.travelPackages.get(packageNo);
    }

    /**
     *
     * Show available activities
     *
     */
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

    /**
     *
     * Gets the package details
     *
     */
    public void getPackageDetails() {

        System.out.println("Enter Package no: ");
        int travelPackageNo = sc.nextInt();
        this.getTravelPackage(travelPackageNo).showPackageDetails();
    }
}

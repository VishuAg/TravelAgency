package com.travel.Utils;

import java.util.Scanner;

import com.travel.TravelAgency;
import com.travel.Passenger.Passenger;
import com.travel.TravelPackage.Activity;
import com.travel.TravelPackage.Destination;
import com.travel.TravelPackage.TravelPackage;

/**
 * The class Operation helper
 */
public class OperationHelper {
    private static Scanner sc = new Scanner(System.in);

    /**
     *
     * Execute Operations
     *
     * @param travelAgency the travel agency.
     * @param operation    the operation.
     */
    public static void execute(TravelAgency travelAgency, int operation) {

        execute(travelAgency, operation, null);
    }

    /**
     *
     * Execute operations
     *
     * @param travelAgency the travel agency.
     * @param operation    the operation.
     * @param passengerNo  the passenger number.
     */
    public static void execute(TravelAgency travelAgency, int operation, String passengerNo) {

        switch (operation) {
            case 1:
                travelAgency.viewPackages();
                break;
            case 2:
                openPassengerPortal(travelAgency);
                break;
            case 3:
                travelAgency.getRegisteredPassengerById(passengerNo).viewMyDetails();
                openRegisteredPassengersPortal(travelAgency, passengerNo);
                break;

            case 4:
                passengerNo = travelAgency.registerPassengerToTravelAgency();
                openRegisteredPassengersPortal(travelAgency, passengerNo);
                break;
            case 5:
                showPackagesToPassenger(travelAgency, passengerNo);
                break;
            case 6:
                travelAgency.getPackageDetails();
                travelAgency.start();
                break;
            case 7:
                travelAgency.showAvailableActivities();
            case 8:
                travelAgency.start();
                break;
            case 9:
                System.exit(0);
                break;
            default:
                System.out.println("\nEnter valid input");
                travelAgency.start();

        }
    }

    /**
     *
     * Open passenger portal
     *
     * @param travelAgency the travel agency.
     */
    public static void openPassengerPortal(TravelAgency travelAgency) {

        System.out.println("\nEnter Passenger Details");
        System.out.println("\nEnter Passenger No");
        String passengerNo = sc.next();
        if (isRegisteredPassenger(travelAgency, passengerNo)) {
            openRegisteredPassengersPortal(travelAgency, passengerNo);
        } else {
            showMenuToUnRegisteredPassenger(travelAgency);
        }
        return;
    }

    /**
     *
     * Open registered passengers portal
     *
     * @param travelAgency the travel agency.
     * @param passengerNo  the passenger number.
     */
    public static void openRegisteredPassengersPortal(TravelAgency travelAgency, String passengerNo) {

        showMenuToRegisteredPassenger(travelAgency);
        int operation = sc.nextInt();
        execute(travelAgency, operation, passengerNo);
    }

    /**
     *
     * CHeck where passenger Is registered
     *
     * @param travelAgency the travel agency.
     * @param passengerNo  the passenger number.
     * @return boolean
     */
    public static boolean isRegisteredPassenger(TravelAgency travelAgency, String passengerNo) {

        return travelAgency.getAllRegisteredPassengers().containsKey(passengerNo);
    }

    /**
     *
     * Show menu to registered passenger
     *
     * @param travelAgency the travel agency.
     */
    public static void showMenuToRegisteredPassenger(TravelAgency travelAgency) {

        PrintHelper.viewMenuToRegisteredPassenger();
    }

    /**
     *
     * Show menu to un registered passenger
     *
     * @param travelAgency the travel agency.
     */
    public static void showMenuToUnRegisteredPassenger(TravelAgency travelAgency) {

        System.out.println("\nPassenger is not registered. Please register to book");
        PrintHelper.viewMenuToUnRegisteredPassenger();
        int operation = sc.nextInt();
        execute(travelAgency, operation);
    }

    /**
     *
     * Show packages to passenger
     *
     * @param travelAgency the travel agency.
     * @param passengerNo  the passenger number.
     */
    public static void showPackagesToPassenger(TravelAgency travelAgency, String passengerNo) {

        System.out.println("\nEnter Package Number");
        int packageNo = sc.nextInt();
        TravelPackage travelPackage = travelAgency.getTravelPackages().get(packageNo);
        if (travelPackage == null) {
            System.out.println("Enter valid Package Id");
            showPackagesToPassenger(travelAgency, passengerNo);
            return;
        }
        if (travelPackage.getCapacity() == 0) {
            System.out.println("Capacity Full");
            openRegisteredPassengersPortal(travelAgency, passengerNo);
            return;
        }
        Destination destination = getDestinationChosenByPassenger(travelPackage);
        Activity activity = getActivityChosenByPassenger(destination);
        bookActivityChosenByPassenger(travelAgency, passengerNo, travelPackage, activity);
        openRegisteredPassengersPortal(travelAgency, passengerNo);
    }

    /**
     *
     * Gets the destination chosen by passenger
     *
     * @param travelPackage the travel package.
     * @return the destination chosen by passenger
     */
    public static Destination getDestinationChosenByPassenger(TravelPackage travelPackage) {
        if(travelPackage == null){
            return null;
        }
        travelPackage.showDestinations();
        System.out.println("\nSelect Destinations Id");
        int destinationId = sc.nextInt();
        Destination destination = travelPackage.getDestinationById(destinationId);
        if (destination == null) {
            System.out.println("Enter valid Destination Id");
            destination = getDestinationChosenByPassenger(travelPackage);
        }
        return destination;
    }

    /**
     *
     * Gets the activity chosen by passenger
     *
     * @param destination the destination.
     * @return the activity chosen by passenger
     */
    public static Activity getActivityChosenByPassenger(Destination destination) {
        if(destination == null){
            return null;
        }
        System.out.println("\nSelect Activities");
        destination.showActivites();
        int activityId = sc.nextInt();
        Activity activity = destination.getActivityById(activityId);
        if (activity == null) {
            System.out.println("Enter valid Activity Id");
            activity = getActivityChosenByPassenger(destination);
        }
        return activity;
    }

    /**
     *
     * Book activity chosen by passenger
     *
     * @param travelAgency  the travel agency.
     * @param passengerNo   the passenger number.
     * @param travelPackage the travel package.
     * @param activity      the acitity.
     */
    public static void bookActivityChosenByPassenger(TravelAgency travelAgency, String passengerNo,
            TravelPackage travelPackage, Activity activity) {
        if(activity == null){
            return;
        }
        Passenger p = travelAgency.getRegisteredPassengerById(passengerNo);
        if (p.bookActivity(activity)) {
            travelPackage.addPassengerToPackage(p);
        }
    }

}

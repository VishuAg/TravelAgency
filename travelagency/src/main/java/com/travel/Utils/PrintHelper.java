package com.travel.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.travel.Passenger.Passenger;
import com.travel.Passenger.PassengerUtil.ActivityDetails;
import com.travel.TravelPackage.Activity;
import com.travel.TravelPackage.Destination;
import com.travel.TravelPackage.TravelPackage;

/**
 * The class Print helper
 */
public class PrintHelper {

    /**
     *
     * Print packages
     *
     * @param tp the tp.
     */
    public static void printPackages(HashMap<Integer, TravelPackage> tp) {

        for (Map.Entry<Integer, TravelPackage> travelpackage : tp.entrySet()) {
            printPackageDetails(travelpackage);
            for (Map.Entry<Integer, Destination> destination : travelpackage.getValue().getAllDestination()
                    .entrySet()) {
                printDestinationDetails(destination);
                printActivities(destination.getValue().getActivities());
            }
        }
        return;
    }

    /**
     *
     * View main menu
     *
     */
    public static void viewMainMenu() {

        System.out.println("\nMain Menu:");
        System.out.println("1. View Packages");
        System.out.println("2. Book Package");
        System.out.println("6. Show Package Details");
        System.out.println("7. Show Available Activities");
        System.out.println("9. Exit");
        System.out.println("Select an option: ");
    }

    /**
     *
     * View menu to registered passenger
     *
     */
    public static void viewMenuToRegisteredPassenger() {

        System.out.println("\nWELCOME TO TRAVEL AGENCY");
        System.out.println("1. View Packages");
        System.out.println("3. View My Bookings");
        System.out.println("5. Enter package number to book a package");
        System.out.println("8. Go Back to Main Menu");
        System.out.println("9. Exit");
        System.out.println("Select an option: ");
    }

    /**
     *
     * View menu to un registered passenger
     *
     */
    public static void viewMenuToUnRegisteredPassenger() {

        System.out.println("\nWELCOME TO TRAVEL AGENCY");
        System.out.println("1. View Packages");
        System.out.println("4. Register to My Travel Agency");
        System.out.println("8. Go Back to Main Menu");
        System.out.println("9. Exit");
        System.out.println("Select an option: ");
    }

    /**
     *
     * Print destinations
     *
     * @param destinations the destinations.
     */
    public static void printDestinations(HashMap<Integer, Destination> destinations) {

        for (Map.Entry<Integer, Destination> destination : destinations.entrySet()) {
            printDestinationDetails(destination);
        }
    }

    /**
     *
     * Print package details
     *
     * @param travelpackage the travelpackage.
     */
    public static void printPackageDetails(Map.Entry<Integer, TravelPackage> travelpackage) {

        System.out.println("\n Travel Package Id: " + travelpackage.getKey() + " Package Name : "
                + travelpackage.getValue().getName() + " ");
    }

    /**
     *
     * Print package details
     *
     * @param travelpackage the travelpackage.
     */
    public static void printPackageDetails(TravelPackage travelpackage) {

        System.out.println("\n " + " Package Name : "
                + travelpackage.getName() + " Capacity: " + travelpackage.getCapacity() + " Passengers Enrolled: "
                + travelpackage.getPassengers().size());
        printPassengers(travelpackage.getPassengers());
    }

    /**
     *
     * Print destination details
     *
     * @param destination the destination.
     */
    public static void printDestinationDetails(Map.Entry<Integer, Destination> destination) {

        System.out.println(
                "\n\tDestination No: " + destination.getKey() + " Name : " + destination.getValue().getName() + " ");
    }

    /**
     *
     * Print passengers
     *
     * @param passengers the passengers.
     */
    public static void printPassengers(ArrayList<Passenger> passengers) {

        for (Passenger passenger : passengers) {
            printPassengerDetails(passenger);
        }
    }

    /**
     *
     * Print passenger details
     *
     * @param passenger the passenger.
     */
    public static void printPassengerDetails(Passenger passenger) {

        System.out.println(
                "\n\t Passenger No: " + passenger.getPassengerNo() + " Name : " + passenger.getName() + " Passenger Type:- " + passenger.getPassengerType().name());
    }

    /**
     *
     * Print activities
     *
     * @param activities the activities.
     */
    public static void printActivities(HashMap<Integer, Activity> activities) {

        for (Map.Entry<Integer, Activity> activity : activities.entrySet()) {
            System.out.println("\t\tActivity No: " + activity.getKey() +
                    " Name : " + activity.getValue().getName() +
                    " Description : " + activity.getValue().getDescription() +
                    " Capacity : " + activity.getValue().getCapacity() +
                    " Activity Cost : " + activity.getValue().getCost());
        }
    }

    /**
     *
     * Print activities enrolled by passenger
     *
     * @param activities the activities.
     */
    public static void printActivitiesEnrolledByPassenger(HashMap<Integer, ActivityDetails> activities) {

        for (Map.Entry<Integer, ActivityDetails> activity : activities.entrySet()) {
            System.out.println("\t\tActivity No: " + activity.getKey() +
                    " Name : " + activity.getValue().getActivity().getName() +
                    " Destination Id : " + activity.getValue().getActivity().getDestinationId() +
                    " Activity Cost : " + activity.getValue().getCost());
        }
    }

}

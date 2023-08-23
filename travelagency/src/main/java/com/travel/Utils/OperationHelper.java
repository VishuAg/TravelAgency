package com.travel.Utils;

import java.util.Scanner;

import com.travel.TravelAgency;
import com.travel.Passenger.Passenger;
import com.travel.TravelPackage.Activity;
import com.travel.TravelPackage.Destination;
import com.travel.TravelPackage.TravelPackage;

public class OperationHelper{
    private static Scanner sc = new Scanner(System.in);
    public static void execute(TravelAgency travelAgency, int operation){
        execute(travelAgency, operation, null);
    }
    public static void execute(TravelAgency travelAgency, int operation, String passengerNo){
        switch(operation){
            case 1: travelAgency.viewPackages();
            break;
            case 2: openPassengerPortal(travelAgency);
            break;
            case 3: 
            default: System.out.println("\nEnter valid input");
            travelAgency.start();
            case 4:
            String passenger =  travelAgency.registerPassengerToTravelAgency();
            openRegisteredPassengersPortal(travelAgency, passenger);
            break;
            case 5: showDestinationsToPassenger(travelAgency, passengerNo);
            case 6:
            case 7: travelAgency.start();
            case 8: System.exit(0);
            break;

        }
    }
    public static void openPassengerPortal(TravelAgency travelAgency){
        System.out.println("\nEnter Passenger Details");
        System.out.println("\nEnter Passenger No");
        String passengerNo = sc.next();
        if(isRegisteredPassenger( travelAgency, passengerNo)){
           openRegisteredPassengersPortal(travelAgency, passengerNo);
        }
        else{
            showMenuToUnRegisteredPassenger(travelAgency);
        }
            return;
        }
        public static void openRegisteredPassengersPortal(TravelAgency travelAgency, String passengerNo){
            showMenuToRegisteredPassenger(travelAgency);
            int operation = sc.nextInt();
            execute(travelAgency, operation, passengerNo);
            // showDestinationsToPassenger(travelAgency, passengerNo);
        }

    public static boolean isRegisteredPassenger(TravelAgency travelAgency, String passengerNo){
            return travelAgency.getAllRegisteredPassengers().containsKey(passengerNo);
    } 
    public static void showMenuToRegisteredPassenger(TravelAgency travelAgency){
            PrintHelper.viewMenuToRegisteredPassenger();
    }

    public static void showMenuToUnRegisteredPassenger(TravelAgency travelAgency){
            System.out.println("\nPassenger is not registered. Please register to book");
            PrintHelper.viewMenuToUnRegisteredPassenger();
            int operation = sc.nextInt();
            execute(travelAgency, operation);
    }

    public static void showDestinationsToPassenger(TravelAgency travelAgency, String passengerNo){
        System.out.println("\nEnter Package Number");
        int packageNo = sc.nextInt();
        TravelPackage travelPackage = travelAgency.getTravelPackages().get(packageNo);
        travelPackage.showDestinations();
        System.out.println("\nSelect Destinations Id");
        int destinationId = sc.nextInt();
        Destination destination = travelPackage.getDestinationById(destinationId);
        System.out.println("\nSelect Activities");
        destination.showActivites();
        int activityId = sc.nextInt();
        Passenger p = travelAgency.getRegisteredPassengerById(passengerNo);
        Activity a = destination.getActivityById(activityId);
        p.bookActivity(a);
        System.out.println("\nAdded successfully");
        openRegisteredPassengersPortal(travelAgency, passengerNo);
    }

}
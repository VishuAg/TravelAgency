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
            case 3: travelAgency.getRegisteredPassengerById(passengerNo).viewMyDetails();
            openRegisteredPassengersPortal(travelAgency, passengerNo);
            break;
            
            case 4:
            passengerNo =  travelAgency.registerPassengerToTravelAgency();
            openRegisteredPassengersPortal(travelAgency, passengerNo);
            break;
            case 5: showDestinationsToPassenger(travelAgency, passengerNo);
            break;
            case 6: TravelPackage.showPackageDetails();
            break;
            case 7: Activity.showAvailableActivities();
            break;
            case 8: travelAgency.start();
            break;
            case 9: System.exit(0);
            break;
            default: System.out.println("\nEnter valid input");
            travelAgency.start();

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
        openRegisteredPassengersPortal(travelAgency, passengerNo);
    }

}
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
            default: System.out.println("Enter valid input");
            travelAgency.start();
            case 4: travelAgency.registerPassengerToTravelAgency();
            PrintHelper.viewMenuToRegisteredPassenger();
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
        System.out.println("Enter Passenger No");
        String passengerNo = sc.nextLine();
        if(isRegisteredPassenger( travelAgency, passengerNo)){
            showMenuToRegisteredPassenger(travelAgency);
            showDestinationsToPassenger(travelAgency, passengerNo);
        }
        else{
            showMenuToUnRegisteredPassenger(travelAgency);
        }
            
           
            return;
        }

    public static boolean isRegisteredPassenger(TravelAgency travelAgency, String passengerNo){
            return travelAgency.getRegisteredPassengers().containsKey(passengerNo);
    } 
    public static void showMenuToRegisteredPassenger(TravelAgency travelAgency){
            System.out.println("Passenger is registered");
            PrintHelper.viewMenuToRegisteredPassenger();
    }

    public static void showMenuToUnRegisteredPassenger(TravelAgency travelAgency){
            System.out.println("Passenger is not registered. Please register to book");
            PrintHelper.viewMenuToUnRegisteredPassenger();
            int operation = sc.nextInt();
            execute(travelAgency, operation);
    }

    public static void showDestinationsToPassenger(TravelAgency travelAgency, String passengerNo){
        System.out.println("Enter Package Number");
        int packageNo = sc.nextInt();
        TravelPackage travelPackage = travelAgency.getTravelPackages().get(packageNo);
        travelPackage.showDestinations();
        System.out.println("Select Destinations Id");
        int destinationId = sc.nextInt();
        Destination destination = travelPackage.getDestinationById(destinationId);
        System.out.println("Select Activities");
        destination.showActivites();
        Passenger p = travelAgency.getRegisteredPassengers().get(passengerNo);
        p.addActivity(new Activity(1,"bungee jumping", "bungee jumping", 50.0, 1));
        System.out.println("Added successfully");
        showMenuToRegisteredPassenger(travelAgency);
    }

}
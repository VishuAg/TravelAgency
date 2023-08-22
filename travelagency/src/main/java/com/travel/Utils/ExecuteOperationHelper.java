package com.travel.Utils;

import java.util.Scanner;

import com.travel.TravelAgency;
import com.travel.Passenger.Passenger;
import com.travel.TravelPackage.Activity;
import com.travel.TravelPackage.TravelPackage;

public class ExecuteOperationHelper{
    public static void execute(TravelAgency ta, int operation){
        switch(operation){
            case 1: ta.viewPackages();
            break;
            case 2: openPassengerPortal(ta);
            break;
            default: System.out.println("Enter valid input");
            ta.start();
            break;

        }
    }
    public static void openPassengerPortal(TravelAgency ta){
        System.out.println("Enter Passenger Details");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Passenger No");
        String passengerNo = sc.nextLine();
        if(ta.getRegisteredPassengers().containsKey(passengerNo)){
            System.out.println("Passenger is registered");
            System.out.println("Enter Package No");
            int packageNo = sc.nextInt();
            TravelPackage tp = ta.getTravelPackages().get(packageNo);
            tp.getItineraries();
            Passenger p = ta.getRegisteredPassengers().get(passengerNo);
            p.addActivity(new Activity(1,"bungee jumping", "bungee jumping", 50.0, 1));
            System.out.println("Added successfully");
            return;
        }


        return;
    }
}
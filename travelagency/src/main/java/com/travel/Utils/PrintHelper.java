package com.travel.Utils;
import java.util.HashMap;
import java.util.Map;

import com.travel.TravelPackage.Activity;
import com.travel.TravelPackage.Destination;
import com.travel.TravelPackage.TravelPackage;

public class PrintHelper {
    public static void printPackages(HashMap<Integer, TravelPackage> tp ){
        for(Map.Entry<Integer, TravelPackage> m: tp.entrySet()){
            System.out.println(m.getValue().getName());
        }
        return;
    }
    public static void viewMainMenu(){
        System.out.println("\nMain Menu:");
        System.out.println("1. View Packages");
        System.out.println("2. Book Package");
        System.out.println("8. Exit");
        System.out.println("Select an option: ");
    }

    public static void viewMenuToRegisteredPassenger(){
        System.out.println("\nWELCOME TO TRAVEL AGENCY");
        System.out.println("1. View Packages");
        System.out.println("3. View My Bookings");
        System.out.println("5. Enter Package No");
        System.out.println("7. Go Back to Main Menu");
        System.out.println("8. Exit");
        System.out.println("Select an option: ");
    }

    public static void viewMenuToUnRegisteredPassenger(){
        System.out.println("\nWELCOME TO TRAVEL AGENCY");
        System.out.println("1. View Packages");
        System.out.println("4. Register to My Travel Agency");
        System.out.println("7. Go Back to Main Menu");
        System.out.println("8. Exit");
        System.out.println("Select an option: ");
    }
    public static void printDestinations(HashMap<Integer, Destination> destinations){
        for(Map.Entry<Integer, Destination> m: destinations.entrySet()){
            System.out.println(m.getValue().getName());
        }
    }
    public static void printActivities(HashMap<Integer, Activity> activity){
        for(Map.Entry<Integer, Activity> m: activity.entrySet()){
            System.out.println(m.getValue().getName());
        }
    }
}

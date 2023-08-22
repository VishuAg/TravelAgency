package com.travel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.travel.Passenger.Passenger;
import com.travel.TravelPackage.TravelPackage;
import com.travel.Utils.ExecuteOperationHelper;
import com.travel.Utils.PrintHelper;
import com.travel.Utils.UploadHelper;

public class TravelAgency {
    private HashMap<Integer, TravelPackage> travelPackages;
    private HashMap<String, Passenger> registeredPassengers;
    public TravelAgency(){
        populatePassengers();
        populatePackages();
    }
    private void populatePackages(){
        travelPackages = UploadHelper.getPackages();
    }
    private void populatePassengers(){
        registeredPassengers = UploadHelper.getPassengers();
    }
    public HashMap<String, Passenger> getRegisteredPassengers() {
        return registeredPassengers;
    }
    public HashMap<Integer, TravelPackage> getTravelPackages() {
        return travelPackages;
    }
    public void viewPackages(){
        PrintHelper.printPackages(travelPackages);
        return;
    }
    public void start(){
        Scanner sc = new Scanner(System.in);
        while(true){
            PrintHelper.designPage();
            int operation = sc.nextInt();
            ExecuteOperationHelper.execute(this, operation);
        }
       
        
    }
}

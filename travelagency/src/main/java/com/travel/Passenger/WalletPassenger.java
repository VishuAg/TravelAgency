package com.travel.Passenger;

import com.travel.Passenger.PassengerUtil.ActivityDetails;
import com.travel.TravelPackage.Activity;
import com.travel.Utils.PrintHelper;

public abstract class WalletPassenger extends Passenger{
    private double balance = 100;
    public WalletPassenger(String name, String passengerNo){
        super(name, passengerNo);
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void addBalance(double amount){
      this.balance=this.balance + amount;
    }
    public abstract double getDiscountPercentage();
    public boolean bookActivity(Activity activity) {
        double cost = activity.getCost();
        if (!hasSufficientBalance(cost)) {
           System.out.println("Insufficent fund");
           return false;
        }
        if(addActivity(activity)){
             double costToPassenger = deductBalance(cost);
             this.activities.put(activity.getActivityId(),new ActivityDetails(costToPassenger, activity));
             return true;
        }
        return false;
     }
  
     public boolean hasSufficientBalance(double cost) {
        if (cost * (1 - this.getDiscountPercentage() / 100) > this.getBalance()) {
           return false;
        }
        return true;
     }
  
     public double deductBalance(double cost) {
      double costToPassenger =  cost * (1 - this.getDiscountPercentage() / 100);
        this.setBalance(this.getBalance() - costToPassenger);
        return costToPassenger;
     }
     public void viewMyDetails() {
        printPassengerDetails();
     }

     public void printPassengerDetails(){
        System.out.println("\t\tPassenger Name: "+this.getName() +
                     " Passenger no : " + this.getPassengerNo() + " Balance: "+this.getBalance());
        
        PrintHelper.printActivitiesEnrolledByPassenger(this.getActivities());
    }
}

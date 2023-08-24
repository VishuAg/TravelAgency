package com.travel.Passenger;

import com.travel.TravelPackage.Activity;
import com.travel.Utils.PrintHelper;

public abstract class WalletPassenger extends Passenger{
    private double balance = 100;
    private final double discountPercentage = 0;
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
    public void bookActivity(Activity tp) {
        double cost = tp.getCost();
        if (!hasSufficientBalance(cost)) {
           System.out.println("Insufficent fund");
        }
        if(addActivity(tp)){
             deductBalance(cost);
        }
       
     }
  
     public boolean hasSufficientBalance(double cost) {
        if (cost * (1 - this.discountPercentage / 100) > this.getBalance()) {
           return false;
        }
        return true;
     }
  
     public void deductBalance(double cost) {
        this.setBalance(this.getBalance() - cost * (1 - this.discountPercentage / 100));
        return;
     }
     public void viewMyDetails() {
        printPassengerDetails();
     }

     public void printPassengerDetails(){
        System.out.println("\t\tPassenger Name: "+this.getName() +
                     " Passenger no : " + this.getPassengerNo() + " Balance: "+this.getBalance());
        
        PrintHelper.printActivities(this.getActivities());
    }
}

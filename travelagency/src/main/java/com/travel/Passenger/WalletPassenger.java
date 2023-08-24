package com.travel.Passenger;

import com.travel.Passenger.PassengerUtil.ActivityDetails;
import com.travel.TravelPackage.Activity;
import com.travel.Utils.PrintHelper;

/**
 * The class Abstract wallet passenger extends passenger
 */
public abstract class WalletPassenger extends Passenger {
   private double balance = 100;

   /**
    *
    * Wallet passenger
    *
    * @param name        the name.
    * @param passengerNo the passenger number.
    */
   public WalletPassenger(String name, String passengerNo) {

      super(name, passengerNo);
   }

   /**
    *
    * Gets the balance
    *
    * @return the balance
    */
   public double getBalance() {

      return balance;
   }

   /**
    *
    * Sets the balance
    *
    * @param balance the balance.
    */
   public void setBalance(double balance) {

      this.balance = balance;
   }

   /**
    *
    * Add balance
    *
    * @param amount the amount.
    */
   public void addBalance(double amount) {

      this.balance = this.balance + amount;
   }

   /**
    *
    * Gets the discount percentage
    *
    * @param bookActivity the book activity. It is public ;
    * @return the discount percentage
    */
   public abstract double getDiscountPercentage();

   public boolean bookActivity(Activity activity) {

      double cost = activity.getCost();
      if (!hasSufficientBalance(cost)) {
         System.out.println("Insufficent fund");
         return false;
      }
      if (addActivity(activity)) {
         double costToPassenger = deductBalance(cost);
         this.activities.put(activity.getActivityId(), new ActivityDetails(costToPassenger, activity));
         return true;
      }
      return false;
   }

   /**
    *
    * Has sufficient balance
    *
    * @param cost the cost.
    * @return boolean
    */
   public boolean hasSufficientBalance(double cost) {

      if (cost * (1 - this.getDiscountPercentage() / 100) > this.getBalance()) {
         return false;
      }
      return true;
   }

   /**
    *
    * Deduct balance
    *
    * @param cost the cost.
    * @return double
    */
   public double deductBalance(double cost) {

      double costToPassenger = cost * (1 - this.getDiscountPercentage() / 100);
      this.setBalance(this.getBalance() - costToPassenger);
      return costToPassenger;
   }

   /**
    *
    * View my details
    *
    */
   public void viewMyDetails() {

      printPassengerDetails();
   }

   /**
    *
    * Print passenger details
    *
    */
   public void printPassengerDetails() {

      System.out.println("\t\tPassenger Name: " + this.getName() +
            " Passenger no : " + this.getPassengerNo() + " Balance: " + this.getBalance());

      PrintHelper.printActivitiesEnrolledByPassenger(this.getActivities());
   }
}

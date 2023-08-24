package com.travel.Passenger;

public class GoldPassenger extends WalletPassenger {
   private final double discountPercentage = 10.0;
   private double balance = 200;
   public GoldPassenger(String name, String passengerNo) {
      super(name, passengerNo);

   }
   public double getDiscountPercentage() {
      return discountPercentage;
   }
   public double getBalance() {
       return balance;
   }
}

package com.travel.Passenger;

public class GoldPassenger extends WalletPassenger {
   double discountPercentage = 10.0;

   public GoldPassenger(String name, int passengerNo) {
      super(name, passengerNo);

   }
   public double getDiscountPercentage() {
      return discountPercentage;
   }
}

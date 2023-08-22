package com.travel.Passenger;

public class GoldPassenger extends WalletPassenger {
   double discountPercentage = 10.0;

   public GoldPassenger(String name, String passengerNo) {
      super(name, passengerNo);

   }
   public double getDiscountPercentage() {
      return discountPercentage;
   }
}

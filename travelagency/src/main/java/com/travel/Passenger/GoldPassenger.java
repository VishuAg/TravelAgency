package com.travel.Passenger;

import com.travel.Passenger.PassengerUtil.PassengerType;

/**
 * The class Gold passenger extends wallet passenger
 */
public class GoldPassenger extends WalletPassenger {
   private final double discountPercentage = 10.0;
   private final PassengerType passengerType = PassengerType.GOLD;
   private double balance = 200;

   /**
    *
    * Gold passenger
    *
    * @param name        the name.
    * @param passengerNo the passenger number.
    */
   public GoldPassenger(String name, String passengerNo) {
      super(name, passengerNo);

   }

   /**
    *
    * Gets the discount percentage
    *
    * @return the discount percentage
    */
   public double getDiscountPercentage() {
      return discountPercentage;
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
    * get Passenger Type
    * 
    * @return passengerType
    */
   public PassengerType getPassengerType() {
      return passengerType;
   }
}

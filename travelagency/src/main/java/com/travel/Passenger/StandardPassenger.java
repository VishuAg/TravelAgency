package com.travel.Passenger;
public class StandardPassenger extends WalletPassenger{
    double discountPercentage = 0.0;
    double balance = 0;
    public StandardPassenger(String name, String passengerNo){
       super(name, passengerNo);
    }
    public double getDiscountPercentage() {
        return discountPercentage;
    }
    
}

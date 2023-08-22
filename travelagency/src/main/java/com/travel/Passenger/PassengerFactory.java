package com.travel.Passenger;

public class PassengerFactory{

    public Passenger getPassenger(PassengerType pt, String name, int passengerNo){
        if(pt == PassengerType.GOLD){
            return new GoldPassenger(name, passengerNo);
        }
        else if(pt == PassengerType.PREMIUM){
            return new PremiumPassenger(name, passengerNo);
        }
        else return new StandardPassenger(name, passengerNo);
    }
    
}

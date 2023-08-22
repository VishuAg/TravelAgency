package com.travel.Passenger.PassengerUtil;

import com.travel.Passenger.GoldPassenger;
import com.travel.Passenger.Passenger;
import com.travel.Passenger.PremiumPassenger;
import com.travel.Passenger.StandardPassenger;

public class PassengerFactory{

    public static Passenger getPassenger(PassengerType pt, String name, String passengerNo){
        if(pt == PassengerType.GOLD){
            return new GoldPassenger(name, passengerNo);
        }
        else if(pt == PassengerType.PREMIUM){
            return new PremiumPassenger(name, passengerNo);
        }
        else return new StandardPassenger(name, passengerNo);
    }
    
}

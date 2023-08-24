package com.travel.Passenger.PassengerUtil;

import com.travel.Passenger.GoldPassenger;
import com.travel.Passenger.Passenger;
import com.travel.Passenger.PremiumPassenger;
import com.travel.Passenger.StandardPassenger;

/**
 * The class Passenger factory
 */
public class PassengerFactory {

    /**
     *
     * Gets the passenger
     *
     * @param pt          the passenger Type.
     * @param name        the name.
     * @param passengerNo the passenger number.
     * @return the passenger
     */
    public static Passenger getPassenger(PassengerType pt, String name, String passengerNo) {

        if (pt == PassengerType.GOLD) {
            return new GoldPassenger(name, passengerNo);
        } else if (pt == PassengerType.PREMIUM) {
            return new PremiumPassenger(name, passengerNo);
        } else
            return new StandardPassenger(name, passengerNo);
    }

}

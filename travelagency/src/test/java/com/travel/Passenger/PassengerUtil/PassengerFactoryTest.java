package com.travel.Passenger.PassengerUtil;

import com.travel.Passenger.GoldPassenger;
import com.travel.Passenger.PremiumPassenger;
import com.travel.Passenger.StandardPassenger;
import com.travel.Passenger.Passenger;
import org.junit.Test;
import static org.junit.Assert.*;

public class PassengerFactoryTest {

    @Test
    public void testGetGoldPassenger() {
        Passenger passenger = PassengerFactory.getPassenger(PassengerType.GOLD, "Vishnu", "123");
        assertTrue(passenger instanceof GoldPassenger);
        assertEquals("Vishnu", passenger.getName());
        assertEquals("123", passenger.getPassengerNo());
    }

    @Test
    public void testGetPremiumPassenger() {
        Passenger passenger = PassengerFactory.getPassenger(PassengerType.PREMIUM, "Karan", "456");
        assertTrue(passenger instanceof PremiumPassenger);
        assertEquals("Karan", passenger.getName());
        assertEquals("456", passenger.getPassengerNo());
    }

    @Test
    public void testGetStandardPassenger() {
        Passenger passenger = PassengerFactory.getPassenger(PassengerType.STANDARD, "Shubham", "789");
        assertTrue(passenger instanceof StandardPassenger);
        assertEquals("Shubham", passenger.getName());
        assertEquals("789", passenger.getPassengerNo());
    }
}
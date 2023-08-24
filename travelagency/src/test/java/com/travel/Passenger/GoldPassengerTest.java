package com.travel.Passenger;

import org.junit.Test;
import static org.junit.Assert.*;

public class GoldPassengerTest {

    @Test
    public void testConstructorAndGetters() {
        GoldPassenger goldPassenger = new GoldPassenger("Vishnu", "123");

        assertEquals("Vishnu", goldPassenger.getName());
        assertEquals("123", goldPassenger.getPassengerNo());
        assertEquals(10.0, goldPassenger.getDiscountPercentage(), 0.001);
        assertEquals(200.0, goldPassenger.getBalance(), 0.001);
    }

    @Test
    public void testGetDiscountPercentage() {
        GoldPassenger goldPassenger = new GoldPassenger("Vishnu", "123");
        assertEquals(10.0, goldPassenger.getDiscountPercentage(), 0.001);
    }

    @Test
    public void testGetBalance() {
        GoldPassenger goldPassenger = new GoldPassenger("Vishnu", "123");
        assertEquals(200.0, goldPassenger.getBalance(), 0.001);
    }
}
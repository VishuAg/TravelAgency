package com.travel.Passenger;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StandardPassengerTest {

    private StandardPassenger standardPassenger;

    @Before
    public void setUp() {
        standardPassenger = new StandardPassenger("Vishnu", "789");
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Vishnu", standardPassenger.getName());
        assertEquals("789", standardPassenger.getPassengerNo());
        assertEquals(0.0, standardPassenger.getDiscountPercentage(), 0.001);
    }
}

package com.travel.Passenger;

import com.travel.Passenger.PassengerUtil.ActivityDetails;
import com.travel.Utils.PrintHelper;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;

public class WalletPassengerTest {

    private StandardPassenger standardPassenger;
    @Before
    public void setUp() {
        standardPassenger = new StandardPassenger("Vishnu", "A123");
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Vishnu", standardPassenger.getName());
        assertEquals("A123", standardPassenger.getPassengerNo());
        assertEquals(100.0, standardPassenger.getBalance(), 0.001);
    }

    @Test
    public void testAddBalance() {
        standardPassenger.addBalance(70.0);
        assertEquals(170.0, standardPassenger.getBalance(), 0.001);
    }

    @Test
    public void testHasSufficientBalance() {
        assertFalse(standardPassenger.hasSufficientBalance(120.0)); // Considering discount
        assertTrue(standardPassenger.hasSufficientBalance(80.0));  // Considering discount
    }

    @Test
    public void testDeductBalance() {
        double costToDeduct = standardPassenger.deductBalance(50.0);
        assertEquals(50.0, standardPassenger.getBalance(), 0.001);
        assertEquals(50.0, costToDeduct, 0.001);
    }
}

package com.travel.Utils;

import com.travel.Passenger.Passenger;
import com.travel.TravelPackage.TravelPackage;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class PrintHelperTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testPrintPackageDetails() {
        TravelPackage travelPackage = mock(TravelPackage.class);
        when(travelPackage.getName()).thenReturn("Vacation Package");
        when(travelPackage.getCapacity()).thenReturn(10);
        when(travelPackage.getPassengers()).thenReturn(new ArrayList<Passenger>());

        PrintHelper.printPackageDetails(travelPackage);
    }

    @Test
    public void testPrintPassengerDetails() {
        Passenger passenger = mock(Passenger.class);
        when(passenger.getPassengerNo()).thenReturn("P123");
        when(passenger.getName()).thenReturn("Alice Johnson");

        PrintHelper.printPassengerDetails(passenger);
    }
}

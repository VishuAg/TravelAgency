package com.travel.TravelPackage;

import com.travel.Passenger.Passenger;
import com.travel.Passenger.PassengerUtil.PassengerType;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TravelPackageTest {

    @Mock
    private Destination mockDestination;

    @Mock
    private Passenger mockPassenger;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddDestinationToPackage() {
        TravelPackage travelPackage = new TravelPackage("Sample Package", 10);
        travelPackage.addDestinationToPackage(1, mockDestination);

        HashMap<Integer, Destination> destinations = travelPackage.getAllDestination();
        assertEquals(1, destinations.size());
        assertEquals(mockDestination, destinations.get(1));
    }

    @Test
    public void testAddPassengerToPackage() {
        TravelPackage travelPackage = new TravelPackage("Sample Package", 10);
        travelPackage.addPassengerToPackage(mockPassenger);

        ArrayList<Passenger> passengers = travelPackage.getPassengers();
        assertEquals(1, passengers.size());
        assertEquals(mockPassenger, passengers.get(0));
    }

    @Test
    public void testReduceCapacity() {
        TravelPackage travelPackage = new TravelPackage("Sample Package", 10);
        int initialCapacity = travelPackage.getCapacity();
        travelPackage.reduceCapacity();

        assertEquals(initialCapacity - 1, travelPackage.getCapacity());
    }

    @Test
    public void testShowPackageDetails() {
        TravelPackage travelPackage = new TravelPackage("Sample Package", 10);
        travelPackage.addDestinationToPackage(1, mockDestination);
        travelPackage.addPassengerToPackage(mockPassenger);
        when(mockPassenger.getPassengerType()).thenReturn(PassengerType.STANDARD);
        travelPackage.showPackageDetails();
        verify(mockPassenger).getName();
    }

    @Test
    public void testShowDestinations() {
        TravelPackage travelPackage = new TravelPackage("Sample Package", 10);
        travelPackage.addDestinationToPackage(1, mockDestination);

        travelPackage.showDestinations();

        verify(mockDestination).getName();
    }
}

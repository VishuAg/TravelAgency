package com.travel.Passenger.PassengerUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.travel.TravelPackage.Activity;

public class ActivityDetailsTest {
    private ActivityDetails activityDetails;
    @Before
    public void setUp() {
        // Creating a sample Activity object for testing
        Activity sampleActivity = new Activity(1, "Sightseeing", "Explore the city", 50.0, 10, 1);

        // Creating an ActivityDetails object for testing
        activityDetails = new ActivityDetails(20.0, sampleActivity);
    }

    @Test
    public void testGetActivity() {
        Activity result = activityDetails.getActivity();
        assertNotNull(result);
        assertEquals("Sightseeing", result.getName());
    }

    @Test
    public void testGetCost() {
        double result = activityDetails.getCost();
        assertEquals(20.0, result, 0.001);
    }

    @Test
    public void testSetActivity() {
        Activity newActivity = new Activity(2, "Adventure", "Explore the mountains", 20.0, 10, 1);
        activityDetails.setActivity(newActivity);

        Activity result = activityDetails.getActivity();
        assertNotNull(result);
        assertEquals("Adventure", result.getName());
    }

    @Test
    public void testSetCost() {
        activityDetails.setCost(75.0);
        double result = activityDetails.getCost();
        assertEquals(75.0, result, 0.001);
    }
}

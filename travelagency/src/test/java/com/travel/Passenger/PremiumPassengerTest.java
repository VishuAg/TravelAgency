package com.travel.Passenger;

import com.travel.Passenger.PassengerUtil.ActivityDetails;
import com.travel.TravelPackage.Activity;
import com.travel.Utils.PrintHelper;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;

public class PremiumPassengerTest {

    private PremiumPassenger premiumPassenger;

    @Before
    public void setUp() {
        premiumPassenger = new PremiumPassenger("Vishnu", "123");
    }

    @Test
    public void testBookActivity() {
        Activity mockActivity = mock(Activity.class);
        when(mockActivity.getActivityId()).thenReturn(1);
        when(mockActivity.getCapacity()).thenReturn(1);
        assertTrue(premiumPassenger.bookActivity(mockActivity));

        ActivityDetails activityDetails = premiumPassenger.getActivities().get(1);
        assertNotNull(activityDetails);
        assertEquals(0.0, activityDetails.getCost(), 0.001);
        assertSame(mockActivity, activityDetails.getActivity());
    }

    @Test
    public void testViewMyDetails() {
        PrintHelper mockPrintHelper = mock(PrintHelper.class);
        HashMap<Integer, ActivityDetails> mockHashMap = spy(new HashMap<Integer, ActivityDetails>());
        premiumPassenger.viewMyDetails();
        PrintHelper.printActivitiesEnrolledByPassenger(mockHashMap);
        verify(mockPrintHelper, times(1));
    }

    @Test
    public void testGetBalance() {
        assertEquals(Double.MAX_VALUE, premiumPassenger.getBalance(), 0.001);
    }

    @Test
    public void testGetDiscountPercentage() {
        assertEquals(100, premiumPassenger.getDiscountPercentage());
    }
}

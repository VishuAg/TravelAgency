package com.travel.TravelPackage;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class DestinationTest {

    @Mock
    private Activity mockActivity;

    private Destination destination;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        destination = new Destination(1, "Sample Destination");
    }

    @Test
    public void testAddActivities() {
        destination.addActivities(1, mockActivity);

        HashMap<Integer, Activity> activities = destination.getActivities();
        assertEquals(1, activities.size());
        assertEquals(mockActivity, activities.get(1));
    }

    @Test
    public void testGetActivityById() {
        when(mockActivity.getName()).thenReturn("Mock Activity");
        destination.addActivities(1, mockActivity);

        Activity retrievedActivity = destination.getActivityById(1);

        assertEquals(mockActivity.getName(), retrievedActivity.getName());
    }

    @Test
    public void testShowActivities() {
        Activity mockActivity1 = mock(Activity.class);
        Activity mockActivity2 = mock(Activity.class);
        when(mockActivity1.getName()).thenReturn("Mock Activity 1");
        when(mockActivity2.getName()).thenReturn("Mock Activity 2");

        destination.addActivities(1, mockActivity1);
        destination.addActivities(2, mockActivity2);

        destination.showActivites();

        verify(mockActivity1).getName();
        verify(mockActivity2).getName();
    }
}

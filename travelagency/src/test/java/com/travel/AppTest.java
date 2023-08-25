package com.travel;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldCheckForStart()
    {
        TravelAgency mockTravelAgency = mock(TravelAgency.class);
        doNothing().when(mockTravelAgency).start();
        mockTravelAgency.start();
        verify(mockTravelAgency, times(1)).start();
    }
}

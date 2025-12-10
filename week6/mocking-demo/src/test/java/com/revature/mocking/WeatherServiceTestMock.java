package com.revature.mocking;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WeatherServiceTestMock {

    @Test
    public void testMockDemo(){
        WeatherApiClient client = Mockito.mock(WeatherApiClient.class);
        WeatherService service = new WeatherService(client);

        service.refresh("Frisco");

        Mockito.verify(client, Mockito.times(1)).fetchTemperature("Frisco");

    }
}

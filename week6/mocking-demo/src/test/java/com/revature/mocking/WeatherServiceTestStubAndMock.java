package com.revature.mocking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WeatherServiceTestStubAndMock {
    
    @Test
    public void testWeatherServiceStubAndMock(){
        WeatherApiClient weatherApi = Mockito.mock(WeatherApiClient.class);

        //STUBBING
        Mockito.when(weatherApi.fetchTemperature("Plano")).thenReturn(35.0);

        WeatherService service = new WeatherService(weatherApi);
        String message=service.getWeatherMessage("Plano");
        Assertions.assertEquals("It's hot in Plano", message);

        Mockito.verify(weatherApi, Mockito.times(1)).fetchTemperature("Plano");
    }
}

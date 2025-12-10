package  com.revature.mocking;
public class WeatherService {

    private final WeatherApiClient weatherApiClient;

    
    public WeatherService(WeatherApiClient weatherApiClient) {
        this.weatherApiClient = weatherApiClient;
    }
    public String getWeatherMessage(String city){
        double temp = weatherApiClient.fetchTemperature(city);
        if(temp > 30){
            return "It's hot in " + city;
        } else if(temp>15){
            return "It's warm in" + city;
        }
        return "It's cold in "+ city;
    }
    public void refresh(String city){
        weatherApiClient.fetchTemperature(city);
    }
}

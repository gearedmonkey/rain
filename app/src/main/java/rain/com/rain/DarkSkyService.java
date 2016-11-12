package rain.com.rain;

public class DarkSkyService extends WeatherService {

    /**
     * Obtain the weather for the (latitude,longitude)
     *
     * @param latitude  degrees latitude where the current weather should be retrieved
     * @param longitude degrees longitude where the current weather should be retrieved
     * @return A weather object
     */
    @Override
    public Weather getWeather(double latitude, double longitude) {
        Weather retVal = null;

        // TODO do work

        this.updateLocation(latitude, longitude);
        return retVal;
    }

}

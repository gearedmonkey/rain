package rain.com.rain;

public class DarkSkyService implements WeatherService {
    private double prevLongitude, prevLatitude;
    /**
     * Obtain the weather for the longitude/latitude
     *
     * @param longitude oh really?
     * @param latitude  oh yes
     * @return A weather object
     */
    @Override
    public Weather getWeather(double longitude, double latitude) {
        Weather retVal = null;
        return retVal;
    }

    /**
     * Deteremines weather an API call should be made. We don't want to make all these calls if
     * that person be moving 2 feet.
     *
     * @param longitude You'll get it
     * @param latitude  Don't worry
     * @return true iff api is necessary false otherwise
     */
    @Override
    public boolean shouldUpdate(double longitude, double latitude) {
        return false;
    }
}

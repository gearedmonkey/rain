package rain.com.rain;

/**
 * Created by Jordan on 11/9/2016.
 */

public interface WeatherService {
    /**
     * Obtain the weather for the longitude/latitude
     * @param longitude oh really?
     * @param latitude oh yes
     * @return A weather object
     */
    public Weather getWeather(double longitude, double latitude);

    /**
     * Deteremines weather an API call should be made. We don't want to make all these calls if
     * that person be moving 2 feet.
     * @param longitude You'll get it
     * @param latitude Don't worry
     * @return true iff api is necessary false otherwise
     */
    public boolean shouldUpdate(double longitude, double latitude);
}

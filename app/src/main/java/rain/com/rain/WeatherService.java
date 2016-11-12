package rain.com.rain;

import org.jetbrains.annotations.Contract;

public abstract class WeatherService {
    static final double DISTANCE_TOLERANCE = 4; /* kilometers */
    static final double EARTH_RADIUS = 6378.137; /* kilometers */
    protected double prevLongitude, prevLatitude;

    @Contract(pure = true)
    private static double haversine(double lat1, double long1,
                                    double lat2, double long2) {
        lat1 = degToRad(lat1);
        long1 = degToRad(long1);
        lat2 = degToRad(lat2);
        long2 = degToRad(long2);

        return 2 * EARTH_RADIUS * Math.asin(
                Math.sqrt(
                        Math.pow(Math.sin((lat1 - lat2) / 2), 2) +
                        Math.cos(lat1) *
                        Math.cos(lat2) *
                        Math.pow(Math.sin((long1 - long2) / 2), 2)
                )
        );
    }

    @Contract(pure = true)
    private static double degToRad(double degrees) {
        return degrees * Math.PI / 180.0;
    }

    protected void updateLocation(double latitude, double longitude) {
        this.prevLatitude = latitude;
        this.prevLongitude = longitude;
    }

    /**
     * Obtain the weather for the (latitude,longitude)
     *
     * @param latitude  degrees latitude where the current weather should be retrieved
     * @param longitude degrees longitude where the current weather should be retrieved
     * @return A weather object
     */
    public abstract Weather getWeather(double latitude, double longitude);

    /**
     * Determines weather an API call should be made. We don't want to make all these calls if
     * that person be moving 2 feet.
     *
     * @param latitude  degrees latitude of current location
     * @param longitude degrees longitude of current location
     * @return true iff api is necessary false otherwise
     */
    public boolean shouldUpdate(double latitude, double longitude) {
        return haversine(latitude, longitude, prevLatitude, prevLongitude) <= DISTANCE_TOLERANCE;
    }
}

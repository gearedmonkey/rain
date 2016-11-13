package rain.com.rain;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

import java.util.Random;
import java.util.concurrent.ExecutionException;


public class Controller extends WeatherService implements LocationListener {
    private final String TAG = "Controller";
    private WeatherService weatherService;
    private RainActivity rainActivity;
    private Random rGen;

    public Controller(RainActivity rainAcitivty) {
        this.rainActivity = rainAcitivty;
        rGen = new Random();
    }

    @Override
    public void onLocationChanged(Location location) {
        double lat = location.getLatitude();
        double longitude = location.getLongitude();
        this.weatherService = new DarkSkyService(rainActivity);
        if (weatherService.shouldUpdate(lat, longitude)) {
            try {
                Weather weather = weatherService.execute(location).get();
                if (weather != null) {
                    rainActivity.setTVTempDescription(weather.getDescription());
                    rainActivity.setTVTemperature(weather.getTemperature() + "°F");
                    rainActivity.setTvWindspeed(
                            "Windspeed: " + weather.getWindSpeed() + "mph");
                    rainActivity.setBackground(RainActivity.SNOW_BACKGROUND);
                }
            } catch (InterruptedException | ExecutionException e) {
                Log.e(TAG,
                      "Something bad happened while trying to download weather information",
                      e);
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public Weather getWeather(double latitude, double longitude) {
        logEvent("obtaining weather");
        return new Weather(rGen.nextInt(100), 1, 70, 1, 0, "rain", "IT'S DOING SOMETHING");
    }


    @Override
    public boolean shouldUpdate(double latitude, double longitude) {
        return true;
    }

    private void logEvent(String s) {
        Log.d(TAG, s);
    }

}

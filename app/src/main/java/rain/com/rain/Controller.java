package rain.com.rain;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

import java.util.Random;


public class Controller implements LocationListener, WeatherService {
    private final String TAG = "Controller";
    private WeatherService weatherService;
    private RainActivity rainActivity;
    private Random rGen;
    public Controller(RainActivity rainAcitivty) {
        this.rainActivity = rainAcitivty;
        this.weatherService = this;//todo why is this even legal???
        rGen = new Random();
    }

    @Override
    public void onLocationChanged(Location location) {
        double lat = location.getLatitude();
        double longitude = location.getLongitude();
        if(weatherService.shouldUpdate(lat, longitude)) {
            Weather weather = weatherService.getWeather(lat, longitude);
            rainActivity.setTVTempDescription(weather.getDescription());
            rainActivity.setTVTemperature(weather.getTemperature().toString() + "°F");
            rainActivity.setTvWindspeed("Windspeed: " + weather.getWindSpeed().toString() + "MPH");
            rainActivity.setBackground(RainActivity.SNOW_BACKGROUND);
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

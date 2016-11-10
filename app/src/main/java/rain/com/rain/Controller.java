package rain.com.rain;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

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
        if(weatherService.shouldUpdate(longitude, lat)) {
            Weather weather = weatherService.getWeather(longitude, lat);
            rainActivity.setTVTempDescription(weather.getDescription());
            rainActivity.setTVTemperature(weather.getTemperature().toString() + "°F");
            rainActivity.setTvWindspeed("Windspeed: " + weather.getWindSpeed().toString() + "MPH");
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
    public Weather getWeather(double longitude, double latitude) {
        logEvent("obtaining weather");
        return new Weather(rGen.nextInt(100), 1, 70, 1, 0, "rain", "IT'S DOING SOMETHING");
    }


    @Override
    public boolean shouldUpdate(double longitude, double latitude) {
        return true;
    }
    private void logEvent(String s) {
        Log.d(TAG, s);
    }
}

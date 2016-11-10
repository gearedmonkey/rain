package rain.com.rain;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class RainActivity extends AppCompatActivity {
    TextView tvTempDescription, tvTemperature, tvWindspeed;
    private final String TAG = "MAIN";
    private Controller t;
    final static int MY_PERMISSIONS_REQUEST_READ_LOCATION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = new Controller(this);
        initializeLocationListener();
        tvTempDescription = (TextView) findViewById(R.id.tvTempDescription);
        tvTemperature = (TextView) findViewById(R.id.tvTemperature);
        tvWindspeed = (TextView) findViewById(R.id.tvWindspeed);
    }

    private void initializeLocationListener() {
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, t);
    }

    public void setTVTempDescription(String description) {
        tvTempDescription.setText(description);
    }

    public void setTVTemperature(String temperature) {
        tvTemperature.setText(temperature);
    }

    public void setTvWindspeed(String windspeed) {
        tvWindspeed.setText(windspeed);
    }
}
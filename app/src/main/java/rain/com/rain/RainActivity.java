package rain.com.rain;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class RainActivity extends AppCompatActivity {
    public static final String SNOW_BACKGROUND = "SNOW";
    TextView tvTempDescription, tvTemperature, tvWindspeed;
    Button btnSpeech;
    private final String TAG = "MAIN";
    private Controller t;
    TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = new Controller(this);
        initializeLocationListener();
        tvTempDescription = (TextView) findViewById(R.id.tvTempDescription);
        tvTemperature = (TextView) findViewById(R.id.tvTemperature);
        tvWindspeed = (TextView) findViewById(R.id.tvWindspeed);
        btnSpeech = (Button) findViewById(R.id.btnTextSpeech);

    }

    @Override
    protected void onStart() {
        super.onStart();
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });
        btnSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = tvTempDescription.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null, "RainAcitivty");
            }
        });
    }

    @Override
    protected void onPause() {
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }

    private void initializeLocationListener() {
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
            Log.d(TAG, "Needs permissions");
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

    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
            Log.d(TAG, "Needs permissions");
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, t);
    }


    public void setBackground(String type) {
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_main);
        if(type.equalsIgnoreCase(SNOW_BACKGROUND)) {
            layout.setBackgroundResource(R.drawable.snow);

        }
    }
}
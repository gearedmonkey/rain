package rain.com.rain;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;

import okhttp3.HttpUrl;
import rain.com.rain.darksky.DarkSkyApiInterface;
import rain.com.rain.darksky.models.CurrentlyDataBlock;
import rain.com.rain.darksky.models.WeatherResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DarkSkyService extends WeatherService {
    private static HttpUrl HTTP_URL;


    public DarkSkyService(Context context) {
        HTTP_URL = new HttpUrl.Builder()
                .scheme("https")
                .host("api.darksky.net")
                .addPathSegment("forecast")
                .addPathSegment(context.getResources().getString(R.string.dark_sky_key))
                .build();
    }

    /**
     * Obtain the weather for the (latitude,longitude)
     *
     * @param latitude  degrees latitude where the current weather should be retrieved
     * @param longitude degrees longitude where the current weather should be retrieved
     * @return A weather object, or null if an error occurred
     */
    @Nullable
    @Override
    protected Weather getWeather(double latitude, double longitude) {
        Weather retVal = null;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HTTP_URL.toString() + "/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DarkSkyApiInterface service = retrofit.create(DarkSkyApiInterface.class);

        Call<WeatherResponse> weatherResponse = service.getCurrentWeather(latitude, longitude);
        try {
            Response<WeatherResponse> response = weatherResponse.execute();
            if (response.isSuccessful()) {
                WeatherResponse wr = response.body();
                CurrentlyDataBlock currently = wr.getCurrently();
                retVal = new Weather(currently.getApparentTemperature(),
                                     currently.getWindSpeed(),
                                     currently.getVisibility(),
                                     currently.getPrecipProbability(),
                                     currently.getCloudCover(),
                                     "",
                                     currently.getSummary());
            }
        } catch (IOException e) {
            Log.e(this.getClass().getSimpleName(), "Could not connect to the API endpoint", e);
        }

        this.updateLocation(latitude, longitude);
        return retVal;
    }

}

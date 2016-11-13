package rain.com.rain.darksky;

import rain.com.rain.darksky.models.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DarkSkyApiInterface {
    @GET("{latitude},{longitude}")
    Call<WeatherResponse> getWeather(@Path("latitude") double latitude,
                                     @Path("longitude") double longitude);

    @GET("{latitude},{longitude}?exclude=minutely,hourly,daily,alerts,flags")
    Call<WeatherResponse> getCurrentWeather(@Path("latitude") double latitude,
                                            @Path("longitude") double longitude);
}

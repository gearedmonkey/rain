package rain.com.rain.darksky.models;

public class WeatherResponse {
    private String timezone;
    private int offset;
    private double latitude, longitude;
    private CurrentlyDataBlock currently;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public CurrentlyDataBlock getCurrently() {
        return currently;
    }

    public void setCurrently(CurrentlyDataBlock currently) {
        this.currently = currently;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}

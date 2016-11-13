package rain.com.rain;


public class Weather {

    private double windSpeed, visibility, temperature, precipProbability, cloudCover;
    private String precipType;
    private String description;

    public Weather(double temperature,double windSpeed, double visibility,  double precipProbability, double cloudCover, String precipType, String description) {
        this.windSpeed = windSpeed;
        this.visibility = visibility;
        this.temperature = temperature;
        this.precipProbability = precipProbability;
        this.cloudCover = cloudCover;
        this.precipType = precipType;
        this.description = description;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }
    public double getTemperature(){
        return temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(double precipProbability) {
        this.precipProbability = precipProbability;
    }

    public double getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public String getPrecipType() {
        return precipType;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

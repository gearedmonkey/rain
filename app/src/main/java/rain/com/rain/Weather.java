package rain.com.rain;


public class Weather {

    public Integer windSpeed, visibility,temperature, precipProbability, cloudCover;
    public String precipType;
    public String description;

    public Weather(Integer temperature,Integer windSpeed, Integer visibility,  Integer precipProbability, Integer cloudCover, String precipType, String description) {
        this.windSpeed = windSpeed;
        this.visibility = visibility;
        this.temperature = temperature;
        this.precipProbability = precipProbability;
        this.cloudCover = cloudCover;
        this.precipType = precipType;
        this.description = description;
    }

    public Integer getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }
    public Integer getTemperature(){
        return temperature;
    }
    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(Integer precipProbability) {
        this.precipProbability = precipProbability;
    }

    public Integer getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(Integer cloudCover) {
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

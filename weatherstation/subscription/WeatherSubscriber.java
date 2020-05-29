package weatherstation.subscription;

public interface WeatherSubscriber {
    public void inform(float temperature, int wind_speed, int pressure);
    public String getSubscriberName();   
}
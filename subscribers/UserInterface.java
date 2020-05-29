package subscribers;

import weatherstation.subscription.WeatherSubscriber;
import weatherstation.subscription.WeatherSubscription;

public class UserInterface implements WeatherSubscriber{
    private WeatherSubscription weatherStation;
    private String name;

    public UserInterface(){
        this.weatherStation = null;
        this.name = "UserInterface";
    }
    public void finalize(){
        if (this.weatherStation != null){
            this.weatherStation.unsubscribeWeatherNotification(this);
        }
    }
    public void unsubscribeToWeatherStation(){
        if (this.weatherStation != null){
            this.weatherStation.unsubscribeWeatherNotification(this);
            System.out.println("Successfully unsubscribed !!!");
        } else {
            System.out.println("Not subscribed to any station");
        }
    }
    public void subscribeToWeatherStation(WeatherSubscription station){
        if (this.weatherStation != null){
            unsubscribeToWeatherStation();
        }
        this.weatherStation = station;
        this.weatherStation.subscribeWeatherNotification(this);

    }
    public String getSubscriberName(){
        return this.name;
    }
    public void inform(float temperature, int wind_speed, int pressure){
        System.out.println("Notification received from Weather station: Display to UI");
        System.out.printf("temperature=%f wind_speed=%d, pressure=%d\n",
            temperature, wind_speed, pressure);
    }
    
}
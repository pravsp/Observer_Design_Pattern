package subscribers;

import weatherstation.subscription.WeatherSubscriber;
import weatherstation.subscription.WeatherSubscription;

public class Logger implements WeatherSubscriber {
    WeatherSubscription station;
    String name;
    public Logger(){
        this.station = null;
        this.name = "Logger";
    }
    public void unsubscribeToWeatherStation(){
        if (this.station != null){
            this.station.unsubscribeWeatherNotification(this);
            System.out.println("Successfully unsubscribed !!!");
        } else {
            System.out.println("Not subscribed to any station");
        }
    }
    public void subscribeToWeatherStation(WeatherSubscription station){
        if (this.station != null){
            unsubscribeToWeatherStation();
        }
        this.station = station;
        this.station.subscribeWeatherNotification(this);

    }
    public void inform(float temperature, int wind_speed, int pressure){
        System.out.println("Notification Received from Weather station: Log the notification");
        System.out.printf("temperature = %f wind_speed = %d, pressure = %d\n",
            temperature, wind_speed, pressure);
    }
    public String getSubscriberName(){
        return this.name;
    }
    public void finalize(){
        if (this.station != null){
            this.station.unsubscribeWeatherNotification(this);
        }
    }
}
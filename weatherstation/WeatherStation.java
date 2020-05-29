package weatherstation;

import java.util.ArrayList;

import weatherstation.subscription.WeatherSubscriber;
import weatherstation.subscription.WeatherSubscription;

public class WeatherStation implements WeatherSubscription{
    private float temperature;
    private int wind_speed;
    private int pressure;
    private static int  inst_id = 1;
    private String station_name;
    private ArrayList<WeatherSubscriber> subscribers;

    public WeatherStation(){
        subscribers = new ArrayList<WeatherSubscriber>();
        station_name = "WeatherStation-" + WeatherStation.inst_id;
        WeatherStation.inst_id += 1;
    }

    public void subscribeWeatherNotification(WeatherSubscriber subscriber){
        subscribers.add(subscriber);
    }

    public void unsubscribeWeatherNotification(WeatherSubscriber subscriber){
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(){
        for (WeatherSubscriber weatherSubscriber : subscribers) {
            weatherSubscriber.inform(temperature, wind_speed, pressure);
        }
    }
    public void listSubscribers(){
        System.out.println("");
        System.out.println("Current list of subscribers for " + station_name + " :");
        System.out.println("====================================================");
        for (WeatherSubscriber weatherSubscriber : subscribers) {
            System.out.println(weatherSubscriber.getSubscriberName());
        }
    }
    public void setTemperature(float d){
        System.out.println("Temperature update received at station: " + station_name);
        this.temperature = d;
        notifySubscribers();
    }

    public void setWindSpeed(int windSpeed){
        System.out.println("wind speed update received at station: " + station_name);
        this.wind_speed = windSpeed;
        notifySubscribers();
    }

    public void setPressure(int pressure){
        System.out.println("Pressure update received at station: " + station_name);
        this.pressure = pressure;
        notifySubscribers();
    }
    
}
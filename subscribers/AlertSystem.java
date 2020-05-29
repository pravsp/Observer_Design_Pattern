package subscribers;

import weatherstation.subscription.WeatherSubscriber;
import weatherstation.subscription.WeatherSubscription;

public class AlertSystem implements WeatherSubscriber{
    private WeatherSubscription weatherStation;
    private String name;

    public AlertSystem(){
        this.weatherStation = null;
        this.name="AlertSystem";
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
    public void alertTemperatureIncrease(float temperature){
        System.out.printf("High Temperature Alert %f\n", temperature);
    }
    public void alertHighWinds(int wind_speed){
        System.out.printf("High winds alert %d\n", wind_speed);
    }
    public void inform(float temperature, int wind_speed, int pressure){
        System.out.println("Notification received from Weather station");
        if (temperature > 100){
            alertTemperatureIncrease(temperature);
        }

        if (wind_speed > 150){
            alertHighWinds(wind_speed);
        }
    }
    public String getSubscriberName(){
        return this.name;
    }
    public void finalize(){
        if (this.weatherStation != null){
            this.weatherStation.unsubscribeWeatherNotification(this);
        }
    }
    
}
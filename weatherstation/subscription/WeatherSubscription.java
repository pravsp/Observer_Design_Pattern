package weatherstation.subscription;


public interface WeatherSubscription {
    public void notifySubscribers();
    public void subscribeWeatherNotification(WeatherSubscriber subscriber);
    public void unsubscribeWeatherNotification(WeatherSubscriber subscriber);
}
import subscribers.AlertSystem;
import subscribers.Logger;
import subscribers.UserInterface;
import weatherstation.WeatherStation;

public class WeatherSimulator {
    public static void main(String[] args) {
        WeatherStation station1 = new WeatherStation();
        WeatherStation station2 = new WeatherStation();
        Logger l_subscriber = new Logger();
        AlertSystem a_subscriber = new AlertSystem();
        UserInterface u_subscriber = new UserInterface();
        System.out.println("Register Observer notification to weather station");
        l_subscriber.subscribeToWeatherStation(station1);
        a_subscriber.subscribeToWeatherStation(station2);
        u_subscriber.subscribeToWeatherStation(station1);
        station1.listSubscribers();
        station2.listSubscribers();
        System.out.println();
        station1.setTemperature(101.0f);
        System.out.println();
        System.out.println("switch the weather station subcription of ui from station1 to station2");
        u_subscriber.subscribeToWeatherStation(station2);
        System.out.println();
        station1.setPressure(80);
        station1.listSubscribers();
        station2.listSubscribers();
        System.out.println();
        System.out.println("Deregister logger module");
        l_subscriber.unsubscribeToWeatherStation();
        l_subscriber = null;
        System.out.println();
        station1.setTemperature(120.0f);
        station2.setWindSpeed(200);

        station1.listSubscribers();
        System.out.println();
        System.out.println("Deregister UI module");
        u_subscriber.unsubscribeToWeatherStation();
        u_subscriber=null;
        station2.listSubscribers();
        
        
    }
    
}
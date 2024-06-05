package com.example.lab11;

import java.util.Observable;
import java.util.Observer;

public class ConsoleObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            System.out.println("Console Observer:");
            System.out.println("Temperature: " + weatherData.getTemperature());
            System.out.println("Humidity: " + weatherData.getHumidity());
            System.out.println("Pressure: " + weatherData.getPressure());
        }
    }
}


package com.example.lab11;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Observer;

public class FileObserver implements Observer {
    private String filename;

    public FileObserver(String filename) {
        this.filename = filename;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
                out.println("File Observer:");
                out.println("Temperature: " + weatherData.getTemperature());
                out.println("Humidity: " + weatherData.getHumidity());
                out.println("Pressure: " + weatherData.getPressure());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


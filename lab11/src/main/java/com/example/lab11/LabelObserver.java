package com.example.lab11;

import javafx.scene.control.Label;
import java.util.Observable;
import java.util.Observer;

public class LabelObserver implements Observer {
    private Label label;

    public LabelObserver(Label label) {
        this.label = label;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            label.setText("Label Observer:\n" +
                    "Temperature: " + weatherData.getTemperature() + "\n" +
                    "Humidity: " + weatherData.getHumidity() + "\n" +
                    "Pressure: " + weatherData.getPressure());
        }
    }
}


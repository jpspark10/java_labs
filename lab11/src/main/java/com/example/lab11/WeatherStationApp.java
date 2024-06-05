package com.example.lab11;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WeatherStationApp extends Application {
    private WeatherData weatherData;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        weatherData = new WeatherData();

        Label tempLabel = new Label("Temperature:");
        TextField tempField = new TextField();
        Label humLabel = new Label("Humidity:");
        TextField humField = new TextField();
        Label presLabel = new Label("Pressure:");
        TextField presField = new TextField();

        CheckBox consoleCheckBox = new CheckBox("Console");
        CheckBox labelCheckBox = new CheckBox("Label");
        CheckBox fileCheckBox = new CheckBox("File");

        Label outputLabel = new Label();

        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> {
            float temperature = Float.parseFloat(tempField.getText());
            float humidity = Float.parseFloat(humField.getText());
            float pressure = Float.parseFloat(presField.getText());

            if (consoleCheckBox.isSelected()) {
                weatherData.addObserver(new ConsoleObserver());
            }
            if (labelCheckBox.isSelected()) {
                weatherData.addObserver(new LabelObserver(outputLabel));
            }
            if (fileCheckBox.isSelected()) {
                weatherData.addObserver(new FileObserver("weatherData.txt"));
            }

            weatherData.setMeasurements(temperature, humidity, pressure);
        });

        VBox root = new VBox(10, tempLabel, tempField, humLabel, humField, presLabel, presField,
                consoleCheckBox, labelCheckBox, fileCheckBox, sendButton, outputLabel);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 300, 400);
        primaryStage.setTitle("Weather Station");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


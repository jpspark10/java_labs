package com.example.lab122.SecondTask;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GUIBlocking extends Application {

    @Override
    public void start(Stage stage) {
        Button button = new Button("Запустить");
        button.setOnAction(event -> {
            // Бесконечный цикл в главном потоке (GUI)
            while (true) {
                System.out.println("Нажата кнопка!");
            }
        });

        Scene scene = new Scene(new StackPane(button), 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

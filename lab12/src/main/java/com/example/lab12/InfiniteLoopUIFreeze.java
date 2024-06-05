package com.example.lab12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class InfiniteLoopUIFreeze extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Start Infinite Loop");
        btn.setOnAction(event -> infiniteLoop());

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("UI Freeze Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void infiniteLoop() {
        while (true) {
            // бесконечный цикл
        }
    }
}


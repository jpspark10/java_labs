package SecondTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.*;

public class ProgressClient extends Application {
    private volatile boolean running = false;

    @Override
    public void start(Stage primaryStage) {
        ProgressBar progressBar = new ProgressBar();
        Button startButton = new Button("Старт");
        Button stopButton = new Button("Стоп");

        VBox vbox = new VBox(10, progressBar, startButton, stopButton);
        Scene scene = new Scene(vbox, 300, 200);

        startButton.setOnAction(event -> {
            running = true;
            new Thread(() -> {
                try {
                    Socket socket = new Socket("localhost", 7777);
                    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                    while (running) {
                        String progressStr = input.readLine();
                        if (progressStr == null) break;
                        int progress = Integer.parseInt(progressStr);
                        Platform.runLater(() -> progressBar.setProgress(progress / 100.0));
                    }

                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        });

        stopButton.setOnAction(event -> running = false);

        primaryStage.setTitle("ProgressBar Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


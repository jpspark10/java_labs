package com.example.lab12;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProgressBarExample extends Application {
    private volatile boolean running = false;
    private volatile boolean paused = false;
    private volatile int currentIteration = 0;
    private final Object lock = new Object();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ProgressBar progressBar = new ProgressBar(0);
        Button startButton = new Button("Старт");
        Button pauseButton = new Button("Пауза");
        Button stopButton = new Button("Стоп");

        VBox vbox = new VBox(10, progressBar, startButton, pauseButton, stopButton);
        Scene scene = new Scene(vbox, 300, 200);

        Thread workerThread = createWorkerThread(progressBar);

        startButton.setOnAction(event -> {
            if (workerThread.getState() == Thread.State.NEW) {
                workerThread.start();
            } else {
                synchronized (lock) {
                    running = true;
                    paused = false;
                    lock.notify();
                }
            }
        });

        pauseButton.setOnAction(event -> {
            if (!paused) {
                paused = true;
                pauseButton.setText("Продолжить");
            } else {
                paused = false;
                pauseButton.setText("Пауза");
                synchronized (lock) {
                    lock.notify();
                }
            }
        });

        stopButton.setOnAction(event -> {
            running = false;
            currentIteration = 0;
            progressBar.setProgress(0);
            synchronized (lock) {
                lock.notify();
            }
        });

        primaryStage.setTitle("ProgressBar Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Thread createWorkerThread(ProgressBar progressBar) {
        return new Thread(() -> {
            running = true;
            while (true) {
                synchronized (lock) {
                    while (!running) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    if (currentIteration >= 1000) {
                        running = false;
                        currentIteration = 0;
                        progressBar.setProgress(0);
                        continue;
                    }

                    if (paused) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    currentIteration++;
                    double progress = currentIteration / 1000.0;
                    Platform.runLater(() -> progressBar.setProgress(progress));
                }
            }
        });
    }
}


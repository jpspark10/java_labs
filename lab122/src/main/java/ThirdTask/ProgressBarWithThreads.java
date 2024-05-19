package ThirdTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProgressBarWithThreads extends Application {

    private ProgressBar progressBar;
    private Button startButton, pauseButton, stopButton;
    private Thread backgroundThread;
    private boolean isRunning = false;
    private boolean isStopped = false;
    private int progress = 0;
    private int pausedProgress = 0;

    public void start(Stage stage) {
        progressBar = new ProgressBar();
        progressBar.setProgress(0);

        startButton = new Button("Старт");
        startButton.setOnAction(event -> {
            if (!isRunning) {
                startBackgroundThread();
                isRunning = true;
            }
        });

        pauseButton = new Button("Пауза");
        pauseButton.setOnAction(event -> {
            if (isRunning) {
                synchronized (this) {
                    isRunning = false;
                    notify();
                }
            }
        });

        stopButton = new Button("Стоп");
        stopButton.setOnAction(event -> {
            if (isRunning) {
                synchronized (this) {
                    isRunning = false;
                    isStopped = true;
                    notify();
                    progress = 0;
                    backgroundThread.interrupt();
                }
            }
        });

        VBox layout = new VBox(10, progressBar, startButton, pauseButton, stopButton);
        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    private void startBackgroundThread() {
        backgroundThread = new Thread(() -> {
            try {
                while (isRunning) {
                    synchronized (this) {
                        while (!isRunning) {

                            wait();
                        }
                        if (isStopped) {
                            break;
                        }
                    }

                    progress++;
                    Platform.runLater(() -> {
                        progressBar.setProgress((double) progress / 1000);
                    });

                    Thread.sleep(20);

                    if (progress == 1000) {
                        progress = 0;
                        Platform.runLater(() -> {
                            progressBar.setProgress(0);
                        });
                    }
                }
            } catch (InterruptedException e) {
                // Thread interrupted
            } finally {
                // Очистка ProgressBar после остановки
                Platform.runLater(() -> {
                    progressBar.setProgress(0);
                    isStopped = false;
                });
            }
        });
        backgroundThread.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}



package com.example.snakegame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import static java.lang.Math.max;

public class SnakeGame extends Application {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int TILE_SIZE = 20;

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    private Direction direction = Direction.RIGHT;
    private boolean running = true;
    private List<int[]> snake = new ArrayList<>();
    private int[] food = new int[2];
    private int score = 0;
    private int highestScore = 0;
    private UUID clientId;

    private Socket socket;
    private PrintWriter out;

    private Canvas canvas;
    private GraphicsContext gc;

    @Override
    public void start(Stage primaryStage) {
        clientId = UUID.randomUUID();
        try {
            socket = new Socket("localhost", 12345);
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Client connected ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        canvas = new Canvas(WIDTH, HEIGHT);
        gc = canvas.getGraphicsContext2D();

        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(new Scene(new StackPane(canvas)));
        primaryStage.getScene().setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP && direction != Direction.DOWN) {
                direction = Direction.UP;
            } else if (event.getCode() == KeyCode.DOWN && direction != Direction.UP) {
                direction = Direction.DOWN;
            } else if (event.getCode() == KeyCode.LEFT && direction != Direction.RIGHT) {
                direction = Direction.LEFT;
            } else if (event.getCode() == KeyCode.RIGHT && direction != Direction.LEFT) {
                direction = Direction.RIGHT;
            }
        });
        Platform.runLater(() -> {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Game Menu");
            alert.setHeaderText("Game Menu");
            alert.setContentText("Start game");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                startGame();
                out.println("Game start" );
            } else {
                try {
                    out.println("Client disconnected: " + clientId);
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Platform.exit();
            }
        });

        primaryStage.setOnCloseRequest(event -> {
            try {
                out.println("Client disconnected ");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        primaryStage.show();
    }

    private void startGame(){
        initGame();
        new Thread(() -> {
            while (true) {
                if (running) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Platform.runLater(() -> update(gc));
                }
            }
        }).start();
    }

    private void initGame() {
        snake.clear();
        snake.add(new int[]{WIDTH / 2, HEIGHT / 2});
        placeFood();
        score = 0;
        direction = Direction.RIGHT;
        running = true;  // Ensure the game loop is running
        draw(gc);
    }

    private void update(GraphicsContext gc) {
        if (!running) return;

        int[] head = snake.get(0);
        int[] newHead = {head[0], head[1]};

        switch (direction) {
            case UP:
                newHead[1] -= TILE_SIZE;
                break;
            case DOWN:
                newHead[1] += TILE_SIZE;
                break;
            case LEFT:
                newHead[0] -= TILE_SIZE;
                break;
            case RIGHT:
                newHead[0] += TILE_SIZE;
                break;
        }

        if (newHead[0] < 0 || newHead[0] >= WIDTH || newHead[1] < 0 || newHead[1] >= HEIGHT || snake.stream().anyMatch(s -> s[0] == newHead[0] && s[1] == newHead[1])) {
            gameOver();
            return;
        }

        snake.add(0, newHead);
        if (newHead[0] == food[0] && newHead[1] == food[1]) {
            score += 10;
            placeFood();
        } else {
            snake.remove(snake.size() - 1);
        }

        draw(gc);
    }

    private void placeFood() {
        Random random = new Random();
        food[0] = random.nextInt(WIDTH / TILE_SIZE) * TILE_SIZE;
        food[1] = random.nextInt(HEIGHT / TILE_SIZE) * TILE_SIZE;
    }

    private void draw(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, WIDTH, HEIGHT);

        gc.setFill(Color.GREEN);
        for (int[] s : snake) {
            gc.fillRect(s[0], s[1], TILE_SIZE, TILE_SIZE);
        }

        gc.setFill(Color.RED);
        gc.fillRect(food[0], food[1], TILE_SIZE, TILE_SIZE);

        gc.setFill(Color.WHITE);
        gc.fillText("Score: " + score, 10, 20);
        gc.fillText("Top score:" + highestScore,10,40);
    }

    private void gameOver() {
        running = false;
        highestScore = max(score,highestScore);
        out.println("Score: " + score);

        Platform.runLater(() -> {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Game Over");
            alert.setHeaderText("Game Over");
            alert.setContentText("Score: " + score + "\nPlay again?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                startGame();
                out.println("Game restart" );
            } else {
                try {
                    out.println("Client disconnected: " + clientId);
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Platform.exit();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}

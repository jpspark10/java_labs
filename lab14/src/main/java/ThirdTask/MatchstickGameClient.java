package ThirdTask;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.*;

public class MatchstickGameClient extends Application {
    private boolean gameEnded = false;

    @Override
    public void start(Stage primaryStage) {
        TextField textField = new TextField();
        Label label = new Label();
        Button button = new Button("Сделать ход");

        VBox vbox = new VBox(10, textField, button, label);
        Scene scene = new Scene(vbox, 300, 200);

        Socket socket;
        try {
            socket = new Socket("localhost", 7777);
        } catch (IOException e) {
            label.setText("Ошибка подключения к серверу");
            button.setDisable(true);
            return;
        }

        BufferedReader input;
        PrintWriter output;
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            label.setText("Ошибка установки потоков ввода-вывода");
            button.setDisable(true);
            return;
        }

        button.setOnAction(event -> {
            if (!gameEnded) {
                try {
                    int matchsticksTaken = Integer.parseInt(textField.getText());
                    output.println(matchsticksTaken);

                    String response = input.readLine();
                    label.setText(response);

                    if (response.contains("победил")) {
                        gameEnded = true;
                        button.setDisable(true);
                    }
                } catch (NumberFormatException e) {
                    label.setText("Введите число от 1 до 5");
                } catch (IOException e) {
                    label.setText("Ошибка отправки хода на сервер");
                }
            }
        });

        primaryStage.setTitle("Matchstick Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


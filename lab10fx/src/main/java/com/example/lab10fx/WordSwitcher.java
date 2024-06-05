package com.example.lab10fx;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class WordSwitcher extends Application {

    private boolean isSwitched = false;

    @Override
    public void start(Stage primaryStage) {
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        Button switchButton = new Button("→");

        switchButton.setOnAction(event -> {
            if (isSwitched) {
                textField1.setText(textField2.getText());
                textField2.clear();
                switchButton.setText("→");
            } else {
                textField2.setText(textField1.getText());
                textField1.clear();
                switchButton.setText("←");
            }
            isSwitched = !isSwitched;
        });

        HBox hBox = new HBox(10, textField1, switchButton, textField2);
        Scene scene = new Scene(hBox, 400, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Word Switcher");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


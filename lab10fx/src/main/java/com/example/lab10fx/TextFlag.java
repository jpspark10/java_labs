package com.example.lab10fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextFlag extends Application {

    private String[] colors = {"Red", "Green", "Blue", "Yellow", "White"};

    @Override
    public void start(Stage primaryStage) {
        ToggleGroup group1 = new ToggleGroup();
        ToggleGroup group2 = new ToggleGroup();
        ToggleGroup group3 = new ToggleGroup();

        HBox hBox1 = createRadioButtons(group1);
        HBox hBox2 = createRadioButtons(group2);
        HBox hBox3 = createRadioButtons(group3);

        Label flagLabel = new Label("Select colors and press Draw");

        Button drawButton = new Button("Draw");
        drawButton.setOnAction(event -> {
            RadioButton selected1 = (RadioButton) group1.getSelectedToggle();
            RadioButton selected2 = (RadioButton) group2.getSelectedToggle();
            RadioButton selected3 = (RadioButton) group3.getSelectedToggle();

            if (selected1 != null && selected2 != null && selected3 != null) {
                flagLabel.setText(selected1.getText() + ", " + selected2.getText() + ", " + selected3.getText());
            }
        });

        VBox vBox = new VBox(10, hBox1, hBox2, hBox3, drawButton, flagLabel);
        vBox.setPadding(new Insets(10));
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Text Flag");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private HBox createRadioButtons(ToggleGroup group) {
        HBox hBox = new HBox(10);
        for (String color : colors) {
            RadioButton radioButton = new RadioButton(color);
            radioButton.setToggleGroup(group);
            hBox.getChildren().add(radioButton);
        }
        return hBox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

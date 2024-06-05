package com.example.lab10fx;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WidgetToggler extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Label Widget");
        TextField textField = new TextField("TextField Widget");
        CheckBox checkBoxLabel = new CheckBox("Show/Hide Label");
        CheckBox checkBoxTextField = new CheckBox("Show/Hide TextField");

        checkBoxLabel.setSelected(true);
        checkBoxTextField.setSelected(true);

        checkBoxLabel.setOnAction(event -> label.setVisible(checkBoxLabel.isSelected()));
        checkBoxTextField.setOnAction(event -> textField.setVisible(checkBoxTextField.isSelected()));

        VBox vBox = new VBox(10, checkBoxLabel, label, checkBoxTextField, textField);
        Scene scene = new Scene(vBox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Widget Toggler");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

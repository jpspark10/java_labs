package com.example.lab10fx;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {

    private TextField display = new TextField();
    private double firstOperand = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        display.setEditable(false);
        display.setAlignment(Pos.CENTER_RIGHT);
        grid.add(display, 0, 0, 4, 1);

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        int row = 1;
        int col = 0;
        for (String label : buttonLabels) {
            Button button = new Button(label);
            button.setOnAction(e -> buttonPressed(label));
            grid.add(button, col, row);
            col++;
            if (col == 4) {
                col = 0;
                row++;
            }
        }

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void buttonPressed(String label) {
        if ("0123456789.".contains(label)) {
            if (startNewNumber) {
                display.setText("");
                startNewNumber = false;
            }
            display.setText(display.getText() + label);
        } else if (label.equals("=")) {
            calculate(Double.parseDouble(display.getText()));
            operator = "";
        } else {
            if (!operator.isEmpty()) {
                calculate(Double.parseDouble(display.getText()));
            } else {
                firstOperand = Double.parseDouble(display.getText());
            }
            operator = label;
            startNewNumber = true;
        }
    }

    private void calculate(double secondOperand) {
        switch (operator) {
            case "+" -> firstOperand += secondOperand;
            case "-" -> firstOperand -= secondOperand;
            case "*" -> firstOperand *= secondOperand;
            case "/" -> {
                if (secondOperand == 0) {
                    display.setText("Error");
                    startNewNumber = true;
                    return;
                }
                firstOperand /= secondOperand;
            }
        }
        display.setText(String.valueOf(firstOperand));
        startNewNumber = true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
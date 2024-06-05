package com.example.lab10fx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class RestaurantOrder extends Application {

    private Map<CheckBox, Integer> prices = new HashMap<>();
    private Map<CheckBox, Spinner<Integer>> spinners = new HashMap<>();
    private Label totalLabel = new Label("Total: $0");

    @Override
    public void start(Stage primaryStage) {
        CheckBox dish1 = new CheckBox("Dish 1");
        CheckBox dish2 = new CheckBox("Dish 2");
        CheckBox dish3 = new CheckBox("Dish 3");

        prices.put(dish1, 10);
        prices.put(dish2, 15);
        prices.put(dish3, 20);

        Spinner<Integer> spinner1 = createSpinner();
        Spinner<Integer> spinner2 = createSpinner();
        Spinner<Integer> spinner3 = createSpinner();

        spinners.put(dish1, spinner1);
        spinners.put(dish2, spinner2);
        spinners.put(dish3, spinner3);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.add(dish1, 0, 0);
        gridPane.add(spinner1, 1, 0);
        gridPane.add(dish2, 0, 1);
        gridPane.add(spinner2, 1, 1);
        gridPane.add(dish3, 0, 2);
        gridPane.add(spinner3, 1, 2);

        VBox vBox = new VBox(10, gridPane, totalLabel);
        vBox.setPadding(new Insets(10));

        dish1.selectedProperty().addListener((observable, oldValue, newValue) -> updateTotal());
        dish2.selectedProperty().addListener((observable, oldValue, newValue) -> updateTotal());
        dish3.selectedProperty().addListener((observable, oldValue, newValue) -> updateTotal());

        spinner1.valueProperty().addListener((observable, oldValue, newValue) -> updateTotal());
        spinner2.valueProperty().addListener((observable, oldValue, newValue) -> updateTotal());
        spinner3.valueProperty().addListener((observable, oldValue, newValue) -> updateTotal());

        Scene scene = new Scene(vBox, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Restaurant Order");
        primaryStage.show();
    }

    private Spinner<Integer> createSpinner() {
        Spinner<Integer> spinner = new Spinner<>();
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1));
        return spinner;
    }

    private void updateTotal() {
        int total = 0;
        for (CheckBox dish : prices.keySet()) {
            if (dish.isSelected()) {
                total += prices.get(dish) * spinners.get(dish).getValue();
            }
        }
        totalLabel.setText("Total: $" + total);
    }

    public static void main(String[] args) {
        launch(args);
    }
}


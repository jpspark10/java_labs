module com.example.lab10fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab10fx to javafx.fxml;
    exports com.example.lab10fx;

}
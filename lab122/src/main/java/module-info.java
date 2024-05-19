module com.example.lab122 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.lab122 to javafx.fxml;
    exports com.example.lab122;
    exports com.example.lab122.FirstTask;
    opens com.example.lab122.FirstTask to javafx.fxml;
    exports com.example.lab122.SecondTask;
    opens com.example.lab122.SecondTask to javafx.fxml;
    exports ThirdTask;
    opens ThirdTask to javafx.fxml;
}
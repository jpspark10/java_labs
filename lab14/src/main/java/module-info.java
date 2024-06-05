module com.example.lab14 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab14 to javafx.fxml;

    exports FirstTask;
    opens FirstTask to javafx.fxml;
    exports SecondTask;
    opens SecondTask to javafx.fxml;
    exports ThirdTask;
    opens ThirdTask to javafx.fxml;
}
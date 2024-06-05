module com.example.lab12 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab12 to javafx.fxml;
    exports com.example.lab12;
}
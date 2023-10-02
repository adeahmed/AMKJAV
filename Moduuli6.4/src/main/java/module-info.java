module com.example.moduuli64 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.moduuli64 to javafx.fxml;
    exports com.example.moduuli64;
}
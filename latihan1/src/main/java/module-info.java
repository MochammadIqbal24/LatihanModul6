module com.example.latihan1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.latihan1 to javafx.fxml;
    exports com.example.latihan1;
}
module com.example.latihan2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.latihan2 to javafx.fxml;
    exports com.example.latihan2;
}
module com.example.Calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;



    opens com.example.demo3 to javafx.fxml;
    exports com.example.demo3;
}
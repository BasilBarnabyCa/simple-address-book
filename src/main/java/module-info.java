module com.example.simpleaddressbook {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.simpleaddressbook to javafx.fxml;
    exports com.example.simpleaddressbook;
}
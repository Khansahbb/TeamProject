module com.example.teamproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens com.example.teamproject to javafx.fxml;
    exports com.example.teamproject;
    opens com.example.teamproject.controller to javafx.fxml;
    exports com.example.teamproject.util;
    opens com.example.teamproject.util to javafx.fxml;
    exports com.example.teamproject.model;
    opens com.example.teamproject.model to javafx.fxml;
    exports com.example.teamproject.controller;
}
module com.example.loginsytem {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires java.sql;
    requires java.security.jgss;


    opens com.example.loginsytem to javafx.fxml;
    exports com.example.loginsytem;
}
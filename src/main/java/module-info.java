module org.example.calkulaterdima228 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens org.example.calkulaterdima228 to javafx.fxml;
    exports org.example.calkulaterdima228;
}
module com.example.animacaocombsort {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.animacaocombsort to javafx.fxml;
    exports com.example.animacaocombsort;
}
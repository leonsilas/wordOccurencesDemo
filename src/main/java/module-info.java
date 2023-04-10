module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens WordOccurences to javafx.fxml;
    exports WordOccurences;
}

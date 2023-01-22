module capteur.capteurjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    exports launcher;
    opens launcher to javafx.fxml;
    exports view;
    opens view to javafx.fxml;
    exports model;
    opens model to javafx.fxml;
}
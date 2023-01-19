module capteur.capteurjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    exports launch;
    opens launch to javafx.fxml;
    exports view;
    opens view to javafx.fxml;
    exports model;
    opens model to javafx.fxml;
}
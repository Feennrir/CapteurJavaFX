module capteur.capteurjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens capteur.capteurjavafx to javafx.fxml;
    exports capteur.capteurjavafx;
}
package view;

import model.Capteur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SpinnerWindow extends Visu{

    @FXML
    private Spinner spinner;
    protected Capteur capteur;
    private GridPane gridPane;

    public SpinnerWindow(Capteur capteur) throws IOException {
        this.capteur = capteur;
        Stage stage = new Stage();
        gridPane = new GridPane();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SpinnerWindow.fxml"));
        loader.setRoot(this.gridPane);
        loader.setController(this);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Spinner");
        stage.show();
    }

    @FXML
    public void initialize() {
        spinner.getValueFactory().valueProperty().bindBidirectional(this.capteur.getValue());
    }

    @Override
    public void update() {
        spinner.getValueFactory().valueProperty().bindBidirectional(this.capteur.getValue());
    }
}

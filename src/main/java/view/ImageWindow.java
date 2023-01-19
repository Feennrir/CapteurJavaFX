package view;

import model.Capteur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;

public class ImageWindow extends Visu {

    private Capteur capteur;
    private GridPane gridPane;

    @FXML
    private Label labelTemperature;

    public ImageWindow(Capteur capteur) throws IOException {
        this.capteur = capteur;
        Stage stage = new Stage();
        gridPane = new GridPane();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ImageWindow.fxml"));
        loader.setRoot(this.gridPane);
        loader.setController(this);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Image");
        stage.show();
    }

    @FXML
    private void initialize() {
        labelTemperature.textProperty().bindBidirectional(this.capteur.getValue(), new NumberStringConverter());
    }

    @Override
    public void update() {
        labelTemperature.textProperty().bindBidirectional(this.capteur.getValue(), new NumberStringConverter());
    }
}

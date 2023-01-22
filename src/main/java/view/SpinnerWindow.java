package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import model.Visualisation;
import model.Capteur;

public class SpinnerWindow extends Visualisation {

    @FXML
    private Slider slider;

    @FXML
    private Label temperature;

    public SpinnerWindow(Capteur c) {
        super(c);
    }

    public void initialize(){
        super.initialize();
    }

    @FXML
    private void changeTemperature(){
        Capteur.setTemperature(slider.getValue());
    }

    @Override
    public void update() {
        slider.setValue(Capteur.getTemperature());
        temperature.setText(String.valueOf(Capteur.getTemperature()));
    }

    @FXML
    public void Close(){
        Stage stage = (Stage) slider.getScene().getWindow();
        stage.close();
    }
}

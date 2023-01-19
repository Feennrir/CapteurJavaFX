package view;

import model.Capteur;
import model.GenerateurAleatoire;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindow {

    @FXML
    private Button buttonSpinner;

    @FXML
    private Button buttonImage;

    @FXML
    private Button buttonFermerPage;

    protected Capteur capteur;

    public void initialize() {
        this.capteur = new Capteur("1", new GenerateurAleatoire(-5,40));
    }

    @FXML
    private void clickButtonFermerPage() {
        Stage stage = (Stage) buttonFermerPage.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void clickButtonImage() throws IOException {
        ImageWindow imageWindow = new ImageWindow(this.capteur);
    }

    @FXML
    private void clickButtonSpinner() throws IOException {
        SpinnerWindow spinnerWindow = new SpinnerWindow(this.capteur);
    }

}

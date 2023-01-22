package view;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Capteur;
import model.Visualisation;

public class ImageWindow extends Visualisation {

    @FXML
    private ImageView imageView;

    public ImageWindow(Capteur c) {
        super(c);
    }

    @Override
    public void initialize(){
        super.initialize();
        imageView.setImage(new Image("file:src/main/resources/images/cloudy.jpg"));
    }
    @Override
    public void update() {

        if(Capteur.getTemperature() < 0) {
            imageView.setImage(new Image("file:src/main/resources/images/olaf.png"));
        }
        else if( Capteur.getTemperature() < 22){
            imageView.setImage(new Image("file:src/main/resources/images/cloudy.jpg"));
        }
        else {
            imageView.setImage(new Image("file:src/main/resources/images/sun.jpg"));
        }
    }

    @FXML
    public void Close(){
        Stage stage = (Stage) imageView.getScene().getWindow();
        stage.close();
    }
}

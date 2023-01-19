package view;

import model.Capteur;
import model.Observateur;

public abstract class Visu implements Observateur {

    private void clickFermer() {

    }

    private void initialize(Capteur capteur) {
        capteur.addObserver(this);
    }
}

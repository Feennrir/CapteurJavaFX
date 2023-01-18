package capteur.capteurjavafx.view;

import capteur.capteurjavafx.model.Capteur;
import capteur.capteurjavafx.model.Observateur;

public class SaisisseurTemperature implements Observateur {

    private String nom;
    private Capteur capteur;

    public SaisisseurTemperature(String nom, Capteur capteur) {
        this.nom = nom;
        this.capteur = capteur;
    }

    public void sasir(double temperature) {
        this.capteur.setValue(temperature);
    }

    @Override
    public void update() {
        System.out.println("["+this.nom+"] "+this.capteur.getNom() + " : " + this.capteur.getTemperature() + " °C");
    }
}

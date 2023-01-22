package model;

import javafx.application.Platform;

import java.util.ArrayList;
import java.util.List;

public class CompositeCapteur extends Capteur {

    private List<Capteur> listCapteur = new ArrayList<Capteur>();
    private StrategyGenerator genTemp;

    public CompositeCapteur(String nom) {
        super(nom);
    }
    @Override
    public double getTemperature(){
        double temperature = 0;
        int nbCapteur = 0;
        for (Capteur capt : listCapteur){
            temperature = capt.getTemperature();
            nbCapteur++;
        }
        temperature = temperature/nbCapteur;
        return temperature;
    }

    public void ajouterCapteur(Capteur c){
        listCapteur.add(c);
    }

    public List<Capteur> getListCapteur()
    {
        return listCapteur;
    }

    @Override
    public void run() {
        while(true){
            Platform.runLater(()->setTemperature(this.getTemperature()));
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    @Override
    public String toString() {
        return getNom();
    }
}

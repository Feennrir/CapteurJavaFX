package model;

import javafx.application.Platform;

public class CapteurAlone  extends Capteur{

    private final StrategyGenerator genTemp;

    public CapteurAlone(String nom, StrategyGenerator genTemp) {
        super(nom);
        this.genTemp = genTemp;
    }

    @Override
    public void run() {
        while(true){
            Platform.runLater(()->setTemperature(this.genTemp.genererTemperature()));
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

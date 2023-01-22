package model;

public abstract class Visualisation implements Observator {

    protected Capteur Capteur;

    public void clickFermer(){}

    public Visualisation(Capteur c){
        this.Capteur = c;
    }

    public void initialize(){
        Capteur.ajouterObservable(this);
    }
}

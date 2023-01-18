package capteur.capteurjavafx.model;


import java.util.ArrayList;
import java.util.List;

public abstract class Sujet {

    private List<Observateur> observers = new ArrayList<Observateur>();

    public void attach(Observateur observer){
        observers.add(observer);
    }

    public void notifier() {
        for (Observateur observateur : observateurs) {
            observateur.update();
        }
    }
}

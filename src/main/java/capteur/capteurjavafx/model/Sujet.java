package capteur.capteurjavafx.model;


import java.util.ArrayList;
import java.util.List;

public abstract class Sujet {

    private List<Observateur> observers = new ArrayList<Observateur>();

    public void addObserver(Observateur o) {
        observers.add(o);
    }

    public void removeObserver(Observateur o) {
        observers.remove(o);
    }

    public void notifier() {
        for (Observateur observateur : observateurs) {
            observateur.update();
        }
    }
}

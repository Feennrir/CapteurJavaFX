package model;


import java.util.ArrayList;
import java.util.List;

public abstract class Sujet {

    private List<Observateur> observers = new ArrayList<>();

    public void addObserver(Observateur o) {
        this.observers.add(o);
    }

    public void removeObserver(Observateur o) {
        this.observers.remove(o);
    }

    public void notifier() {
        for (Observateur observateur : observers) {
            observateur.update();
        }
    }
}

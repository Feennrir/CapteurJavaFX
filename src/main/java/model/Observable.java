package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Observable {

    private List<Observator> observateursList = new ArrayList<Observator>();

    public void ajouterObservable(Observator obs){
        observateursList.add(obs);
    }

    public void supprimerObservable(Observator obs){
        observateursList.remove(obs);
    }

    public void notifier(){
        for (Observator obs: observateursList) {
            obs.update();
        }
    }

    public List<Observator> getObservateursList() {
        return Collections.unmodifiableList(observateursList);
    }
}

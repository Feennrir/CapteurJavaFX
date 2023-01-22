package model;


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;


public abstract class Capteur extends Observable implements Runnable{
    private final int id;
    public static int currentId = 1;
    private String nom;
    private Thread thread;
    private final DoubleProperty temperature;

    public Capteur(String nom){
        this.id = currentId++;
        this.setNom(nom);
        this.temperature = new SimpleDoubleProperty(0);
    }

    public void setTemperature(double temperature) {
        this.temperature.set(temperature);
        notifier();
    }

    public double getTemperature() {
        return this.temperature.get();
    }

    public DoubleProperty getTemperatureProperty() {
        return this.temperature;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public abstract void run();

    @Override
    public String toString() {
        return this.nom + ' ' + this.id;
    }
}
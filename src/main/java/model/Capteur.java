package model;


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;


public class Capteur extends Sujet implements Runnable {

    private int id;
    private static int currentId = 0;
    private String name;
    private DoubleProperty value;
    private GenerateurStrategy strategy;

    public Capteur(String name, GenerateurStrategy strategy) {
        this.id = currentId;
        currentId++;
        this.name = name;
        this.value = new SimpleDoubleProperty(strategy.genererValeur());
        this.strategy = strategy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DoubleProperty getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = new SimpleDoubleProperty(value);
        this.notifier();
    }

    public GenerateurStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(GenerateurStrategy strategy) {
        this.strategy = strategy;
    }



    @Override
    public void run() {
//        while (true) {
//            setValue(GenerateurStrategy.genererValeur());
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            Platform.runLater(() -> {
//                this.value = Math.random();
//                System.out.println("Capteur " + this.name + " : " + this.value);
//            });
//        }
    }
}

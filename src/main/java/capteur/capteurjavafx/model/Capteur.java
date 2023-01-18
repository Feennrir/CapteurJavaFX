package capteur.capteurjavafx.model;


import javafx.application.Platform;


public class Capteur implements Runnable {

    private int id;
    private static int currentId = 0;
    private String name;
    private double value;

    public Capteur(String name) {
        this.id = currentId++;
        this.name = name;
        this.value = 0;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public void run() {
        while (true) {
            setValue(generateurStrategie.genererValeur());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(() -> {
                this.value = Math.random();
                System.out.println("Capteur " + this.name + " : " + this.value);
            });
        }
    }
}

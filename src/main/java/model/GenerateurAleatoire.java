package model;

import java.util.Random;

public class GenerateurAleatoire implements GenerateurStrategy {

    private double min;
    private double max;

    public GenerateurAleatoire(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public GenerateurAleatoire() {
        this.min = Double.MIN_VALUE;
        this.max = Double.MAX_VALUE;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    @Override
    public double genererValeur() {
        Random random = new Random();
        double temperature;
        temperature = min + random.nextDouble(max - min);
        return temperature;
    }
}

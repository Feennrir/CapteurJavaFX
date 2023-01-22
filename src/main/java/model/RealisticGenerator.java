package model;

public class RealisticGenerator implements StrategyGenerator {
    private double BASE = 0;
    private final int MAX_VALUE = 5;
    private final int MIN_VALUE = -5;
    private int RANGE = MAX_VALUE - MIN_VALUE + 1;

    @Override
    public double genererTemperature() {
        BASE = BASE + (Math.random()* RANGE) + MIN_VALUE;
        return BASE;
    }
    @Override
    public String toString() {
        return "Réaliste";
    }
}

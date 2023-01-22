package model;


public class RandomGenerator implements StrategyGenerator {

    private int MAX_VALUE = 100;
    private int MIN_VALUE = -272;

    @Override
    public double genererTemperature() {
        double value = genererTemperatureLimit(MIN_VALUE, MAX_VALUE);
        return value;
    }
    public double genererTemperatureLimit(int min, int max){
        double value = (Math.random() * (max - min)) + max;
        return value;
    }

    @Override
    public String toString() {
        return "Aléatoire";
    }
}

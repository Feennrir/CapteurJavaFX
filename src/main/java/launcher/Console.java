package launcher;


import model.Capteur;
import model.GenerateurAleatoire;
import view.AfficheurTemperature;
import view.SaisisseurTemperature;


public class Console {
    public static void main(String[] args) {
        GenerateurAleatoire ga = new GenerateurAleatoire(-5,40);
        Capteur C001 = new Capteur("C001", ga);
        AfficheurTemperature a1 = new AfficheurTemperature("a1", C001);
        AfficheurTemperature a2 = new AfficheurTemperature("a2", C001);
        SaisisseurTemperature s1 = new SaisisseurTemperature("s1", C001);
        C001.addObserver(a1);
        C001.addObserver(a2);
        C001.addObserver(s1);
        s1.sasir(C001.getStrategy().genererValeur());
    }
}
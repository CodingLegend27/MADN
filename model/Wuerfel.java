package model;

import java.util.Random;

public class Wuerfel {
    
    private int maxZahl;

    private Random random;

    public Wuerfel(int maxZahl) {
        this.maxZahl = maxZahl;

        random = new Random();
        
    }

    /**
     * Würfelt eine zufällige Zahl im Bereich von 1 bis maxZahl
     * @return gewürfelte Zahl
     */
    public int wuerfeln() {
        int zufallszahl = random.nextInt(maxZahl) + 1;
        return zufallszahl;
    }

    /**
     * Methode zum Setzen der maximalen Zahl
     * @param maxZahl neue maximale Zahl
     */
    public void setMaxZahl(int maxZahl) {
        this.maxZahl = maxZahl;
    }

    /**
     * Methode zum Ermitteln der maximalen Zahl
     * @return maximale Zahl
     */
    public int getMaxZahl() {
        return maxZahl;
    }
}
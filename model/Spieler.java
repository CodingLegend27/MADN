package model;

public class Spieler {
    
    // Anzahl der insgesamten Figuren
    private int numFigurenGesamt;

    // Anzahl der Figuren, die sich noch nicht auf dem Spielfeld befinden
    private int numFigurenAusserhalb;

    // Anzahl der Figuren, die bereits in der Mitte in einer Reihe eingeparkt sind 
    private int numFigurenInReihe;

    private String name;
    private String farbe;

    public Spieler(int anzahlFiguren, String name, String farbe) {
        numFigurenGesamt = anzahlFiguren;
        numFigurenAusserhalb = numFigurenGesamt;
        numFigurenInReihe = 0;
        this.name = name;
        this.farbe = farbe;
    }




    /**
     * Methode zum Ermitteln der Anzahl aller Figuren, die diesem Spieler gehören.
     * @return Anzahl aller Figuren
     */
    public int getAnzahlFigurenGesamt() {
        return numFigurenGesamt;
    }

    /**
     * Methode zum Ermitteln der Anzahl der Figuren, die sich außerhalb des Spielfelds befinden.
     * @return Anzahl aller außenstehender Figuren
     */
    public int getAnzahlFigurenAusserhalb() {
        return numFigurenAusserhalb;
    }
    
    /**
     * Methode zum Ermitteln der Anzahl der Figuren, die bereits in der Mitte in einer Reihe eingeparkt sind. 
     * @return Anzahl aller Figuren in der Mitte
     */
    public int getAnzahlFigurenInReihe() {
        return numFigurenInReihe;
    }

    /**
     * Methode zum Setzen der Anzahl der Figuren in Reihe 
     * @param anzahl Anzahl der Figuren in der Mitte, in einer Reihe
     */
    public void setFigurenInReihe(int anzahl) {
        numFigurenInReihe = anzahl;
    }  

    /**
     * Methode zum Setzten der Anzahl der Figuren außerhalb
     * @param anzahl Anzahl der Figuren, die nicht auf dem Spielfeld sind
     */
    public void setFigurenAusserhalb(int anzahl) {
        numFigurenAusserhalb = anzahl;
    }

    /**
     * Methode zum Ermitteln des Namen des Spielers
     * @return Name des Spielers
     */
    public String getName() {
        return name;
    }

    /**
     * Methode zum Setzten eines neuen Namen des Spielers
     * @param name neuer Name des Spielers
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Methode zum Ermitteln der Farbe des Spielers
     * @return Farbe des Spielers
     */
    public String getFarbe() {
        return farbe;
    }
}
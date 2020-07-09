package model;

import java.util.Arrays;
import java.util.InputMismatchException;


public class Model {
    
    private final Spieler[] spieler;

    private final int numFiguren;
    private final int numMaxSpieler;

    private int numAktSpieler;

    // jeder Spieler hat in der Mitte 4 Zielfelder, in denen er seine Spieler am Ende parken muss
    private boolean[][] zielfelder;

    // die 40 Spielpunkte im Feld außenrum werden durch ein Array modelliert
    private Spieler[] felder;

    private Wuerfel w;

    /**
     * Konstruktor für die Klasse Model
     * @param anzahlSpieler Anzahl der maximalen Spieler, die aktiv am Spielgeschehen teilnehmen können. (bedingt durch Spielfeldaufbau)
     * @param anzahlFiguren Anzahl der Figuren, die ein Spieler besitzt
     */
    public Model(final int anzahlSpieler, final int anzahlFiguren) {
        numFiguren = anzahlFiguren;
        numMaxSpieler = anzahlSpieler;
        
        spieler = new Spieler[numMaxSpieler];
        numAktSpieler = 0;

        zielfelder = new boolean[numFiguren][numFiguren];
        for (int i = 0; i < numFiguren; i++) {
            for (int j = 0; j < numFiguren; j++) {
                zielfelder[i][j] = false;
            }
        }

        felder = new Spieler[40];

        w = new Wuerfel(6);
    }

    /**
     * Methode zum Erstellen eines neuen Spielers
     * @param name gegebener Name des Spielers
     * @param farbe gegebene Farbe des Spielers
     */
    public void neuerSpieler(final String name, final String farbe) {
        final Spieler s = new Spieler(numFiguren, name, farbe);
        spieler[numAktSpieler] = s;
        numAktSpieler ++;
    }


    /**
     * Methode zur Abfrage der Anzahl der aktuellen Spieler
     * @return Anzahl der Spieler
     */
    public int getAnzahlAktuellerSpieler() {
        return numAktSpieler;
    }

    /**
     * Methode zum Ermitteln der Anzahl der Figuren eines Spielers außerhalb des Spielfelds 
     * @param nameSpieler Name des Spielers
     * @return Anzahl der Figuren oder -1 falls Name nicht gefunden
     */
    public int getAnzahlFigurenAusserhalb(final String nameSpieler) {
        for (final Spieler s : spieler) {
            if (s.getName().equals(nameSpieler)) {
                return s.getAnzahlFigurenAusserhalb();
            }
        }
        return -1;
    }

    /**
     * Methode zur Abfrage der aktuellen Spielsituation des Spielfelds (außerhalb)
     * @return Array mit den Spielfiguren der jeweiligen Spielern
     */
    public Spieler[] getAktuellesSpielfeld() {
        return felder;
    }

    /**
     * Methode zum Ermitteln der internen Reihenfolge der Spieler 
     * @return ein Array mit den gespeicherten Spielern
     */
    public Spieler[] getReihenfolgeSpieler() {
        return spieler;
    }

    /**
     * Methode zum Ermitteln der internen Nummer des Spielers
     * @param s gegebener Spieler
     * @return Nummer der internen Reihenfolge der gespeicherten Spieler
     */
    public int getNummerSpieler(Spieler s) {
        return Arrays.asList(spieler).indexOf(s); 
    }

    /**
     * Methode zur Abfrage der Nummer der Startposition im Array 'felder'
     * @param s gegebener Spieler 
     * @return Nummer des Startfeldes im Array 'felder'
     */
    public int getNummerStartFeld(Spieler s) {
        int indexSpieler = getNummerSpieler(s);
        int startPosition = indexSpieler * 11;
        return startPosition;
    }

    /**
     * Methode zur Abfrage der Nummer des letztmöglichen befahrbaren Feldes eines Spielers
     * @param s gegebener Spieler
     * @return Nummer des letztmöglich befahrbaren Spielfelds im Array 'felder'
     */
    public int getNummerLetztesFeld(Spieler s) {
        int startPosition = getNummerStartFeld(s);
        int letztesFeld = startPosition-1;
        return letztesFeld;
    }

    /**
     * Methode zum Schicken einer Figur eines Spielers auf seine Startposition
     * @param s gegebener Spieler 
     */
    public void neueFigurAufStart(Spieler s) {
        int startPosition = getNummerStartFeld(s);
        felder[startPosition] = s;
    }


    /**
     * Methode zum Weiterschicken einer Spielfigur eines Spielers nachdem er eine Zahl gewürfelt hat.
     * @param aktuellesFeld aktuelles Feld auf dem seine Spielfigur steht
     * @param s Spieler der seine Figur weiter schicken will
     * @param weiter Anzahl der Felder, die die Figur weitergehen soll
     */
    public void schickeFigureWeiter(int aktuellesFeld, Spieler s, int weiter) {
        felder[aktuellesFeld] = null;

        if (felder[aktuellesFeld] == s) {
            int zielfeld = aktuellesFeld + weiter;

            // falls eine Figur bereits auf dem Spielfeld ist
            // wird diese wieder auf die Startposition gestellt
            if (felder[zielfeld] != null) {
                neueFigurAufStart(felder[zielfeld]);
            }

            // über 40 --> beginnt wieder bei 0
            if (zielfeld >= 40) {
                zielfeld -= 40;
            }

            // falls das Zielfeld weiter liegen würde, als der Spieler erreichen könnte
            int letztesFeld = getNummerLetztesFeld(s);
            if (zielfeld > letztesFeld) {
                int ueberschuss = zielfeld - letztesFeld;

                // der Überschuss ist größer als 4 und der Spieler geht sozusagen wieder zurück
                if (ueberschuss > 4) {
                    zielfeld = ueberschuss - 4;
                    felder[zielfeld] = s;
                }

                // Figur kann eingeparkt werden
                else {
                    zielfelder[getNummerSpieler(s)][ueberschuss] = true;
                }
                
            }

            //  Figur wird auf das Zielfeld bewegt
            else {
                felder[zielfeld] = s;
            }

            

        }
    }

    public boolean[] getZielfeldSpieler(Spieler s) {
        return zielfelder[getNummerSpieler(s)];
    }
    
    /**
     * Methode zum Weiterschicken einer Figur, die bereits im Zielfeld eingeparkt ist, weitergefahren
     * @param aktuellesFeld aktuelles Feld im Zielfeld
     * @param s Figur des Spielers
     * @param weiter Anzahl der Felder, die die Figur weitergehen soll 
     */
    public void schickeZielFigurenWeiter(int aktuellesFeld, Spieler s, int weiter) {
        if (aktuellesFeld > 0) {
            throw new InputMismatchException("Die Position einer Figur im Zielfeld kann nicht größer als 4 sein");
        }

        boolean[] aktZielfeld = getZielfeldSpieler(s);
        // TODO hier weiter machen :)

    }  

    /**
     * Methode zur Abfrage eines zufälligen Würfelergebnisses
     * @return gewürfelte Zahl
     */
    public int wuerfeln() {
        return w.wuerfeln();
    }

}
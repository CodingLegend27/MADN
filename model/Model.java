package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.stream.IntStream;
import java.util.stream.Stream;


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
    public int getAnzahlFigurenAusserhalb(String nameSpieler) {
        for (final Spieler s : spieler) {
            if (s.getName().equals(nameSpieler)) {
                return s.getAnzahlFigurenAusserhalb();
            }
        }
        return -1;
    }
    
    /**
     * Methode zum Ermitteln der Feldnummern der Figuren, die der Spieler auf dem Spielfeld hat
     * @param s gegebener Spieler 
     * @return Array mit den Feldnummer der Figuren
     */
    public ArrayList<Integer> getNumFelderFiguren(Spieler s) {
        ArrayList<Integer> numFelderFiguren = new ArrayList<Integer>();
        for (Spieler feld : felder) {
            if (feld == s) {
                numFelderFiguren.add(Arrays.asList(felder).indexOf(feld));
            }
        }
        Collections.reverse(numFelderFiguren);
        return numFelderFiguren;
    }

    /**
     * Methode zur Abfrage der aktuellen Spielsituation des Spielfelds
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
        int startPosition = indexSpieler * 10;
        return startPosition;
    }

    /**
     * Methode zur Abfrage der Nummer des letztmöglichen befahrbaren Feldes eines Spielers
     * @param s gegebener Spieler
     * @return Nummer des letztmöglich befahrbaren Spielfelds im Array 'felder'
     */
    public int getNummerLetztesFeld(Spieler s) {
        int startPosition = getNummerStartFeld(s);
        // falls das Startfeld jenes Feld mit Index 0 ist,
        // so ist das letztmöglich befahrbare Spielfeld jenes mit Index 40
        int letztesFeld;
        
        // TODO Bug Fix #1
        // if (startPosition == 0){
        //     letztesFeld = 40;
        // }
        // else {
        //     letztesFeld = startPosition-1;
        // }
            
        // return letztesFeld;


        return startPosition-1;
    }

    /**
     * Methode zum Schicken einer Figur eines Spielers auf seine Startposition
     * @param s gegebener Spieler 
     */
    public void neueFigurAufStart(Spieler s) {
        int startPosition = getNummerStartFeld(s);
        felder[startPosition] = s;
        s.lowerNumFigurenAusserhalb();
    }


    /**
     * Methode zum Weiterschicken einer Spielfigur eines Spielers nachdem er eine Zahl gewürfelt hat.
     * @param aktuellesFeld aktuelles Feld auf dem seine Spielfigur steht
     * @param s Spieler der seine Figur weiter schicken will
     * @param weiter Anzahl der Felder, die die Figur weitergehen soll
     * @return gibt die Nummer des Zielfelds zurück
     */
    public int schickeFigureWeiter(int aktuellesFeld, Spieler s, int weiter) {
        

        // hier wird .equals() benötigt statt '=='
        if (felder[aktuellesFeld].equals(s)) {
            felder[aktuellesFeld] = null;
            int zielfeld = aktuellesFeld + weiter;

            
            // TODO Test ob benötigt wird
            // // über 40 --> beginnt wieder bei 0
            if (zielfeld >= 40) {
                zielfeld -= 40;
            }

            // falls eine Figur bereits auf dem Spielfeld ist
            // wird diese wieder auf die Startposition gestellt
            // TODO check Bug fix '&& zielfeld < 40'
            if (felder[zielfeld] != null && zielfeld < 40) {
                neueFigurAufStart(felder[zielfeld]);
            }

            // falls das Zielfeld weiter liegen würde, als der Spieler erreichen könnte
            int letztesFeld = getNummerLetztesFeld(s);

            int startFeld = getNummerStartFeld(s);
            
            // Überprüfung, ob die Figur in die mittlere Reihe eingeparkt werden kann
            // Vereinfachung von 
            // if (startFeld != 0) {
            //     if (aktuellesFeld < letztesFeld && zielfeld > letztesFeld)
            // --> zu:
            if ((startFeld != 0 && aktuellesFeld < letztesFeld && zielfeld > letztesFeld) || (startFeld == 0 && aktuellesFeld < letztesFeld && zielfeld < letztesFeld))
            {
            
        
            // if (zielfeld > letztesFeld) {
                int ueberschuss = zielfeld - letztesFeld;

                // der Überschuss ist größer als 4 und der Spieler geht sozusagen wieder zurück
                if (ueberschuss > 4) {
                    zielfeld = ueberschuss - 4;
                    felder[zielfeld] = s;
                }

                // Figur kann eingeparkt werden
                else {
                    zielfelder[getNummerSpieler(s)][ueberschuss] = true;
                    return 
                    s.raiseNumFigurenInReihe();
                }
            }

            //  Figur wird auf das Zielfeld bewegt
            else {
                felder[zielfeld] = s;
            }

            return zielfeld;
        }
        
        else {
            System.out.println("Fehler im Model bei schickeFigureWeiter");

            return -1;
        }

        
    }

    /**
     * Methode zur Abfrage der Zielfelder eines Spielers
     * @param s gegebener Spieler
     * @return boolesches Array, das die Zielfelder wiederspiegelt
     */
    public boolean[] getZielfelderSpieler(Spieler s) {
        return zielfelder[getNummerSpieler(s)];
    }
    
    /**
     * Methode zum Setzen neuer Zielfelder eines Spielers
     * @param zielfelder boolesches Array, das die Zielfelder wiederspiegelt
     * @param s gegebener Spieler
     */
    public void setZielfelderSpieler(boolean[] zielfelder, Spieler s) {
        this.zielfelder[getNummerSpieler(s)] = zielfelder;
        int anzahl = 0;
        for (boolean b : zielfelder) {
            if (b) {
                anzahl++;
            }
        }
        s.setFigurenInReihe(anzahl);
    }

    /**
     * Methode zum Weiterschicken einer Figur, die bereits im Zielfeld eingeparkt ist, weitergefahren
     * @param aktuellesFeld aktuelles Feld im Zielfeld
     * @param s Figur des Spielers
     * @param weiter Anzahl der Felder, die die Figur weitergehen soll 
     */
    public void schickeZielFigurenWeiter(int aktuellesFeld, Spieler s, int weiter) {
        if (aktuellesFeld > 4) {
            throw new InputMismatchException("Die Position einer Figur im Zielfeld kann nicht größer als 4 sein");
        }

        boolean[] aktZielfelder = getZielfelderSpieler(s);
        aktZielfelder[aktuellesFeld] = false;
        
        int summe = aktuellesFeld + weiter;
        
        if (summe > 4) {
            int neuesFeld = 4 - (summe - 4);
            if (neuesFeld > 4) {
                throw new Error("Fataler Error in der Programmierung");
            }
            
            // Figur wird aus dem Feld rausgefahren
            else if (neuesFeld < 1) {
                int letztesFeld = getNummerLetztesFeld(s);
                int neuePosition = letztesFeld - neuesFeld;
                felder[neuePosition] = s;
                s.lowerNumFigurenInReihe();
            }

            // Spieler wird im Häuschen bewegt
            else {
                aktZielfelder[neuesFeld] = true;
            }
        }
        else {
            aktZielfelder[summe] = true;
        }

        // die Zielfelder des Spielers werden neu gesetzt
        setZielfelderSpieler(aktZielfelder, s);
    }  

    public void updateAnzahlenSpieler() {
        for (Spieler s : spieler) {
            int numSpieler = getNummerSpieler(s);
            int anzahlSpielerInZiel = 0;
            for (boolean wert : zielfelder[numSpieler]) {
                if (wert) {
                    anzahlSpielerInZiel ++;
                }
            }       
            s.setFigurenInReihe(anzahlSpielerInZiel);
            
            
            


        }
    }

    /**
     * Methode zur Abfrage eines zufälligen Würfelergebnisses
     * @return gewürfelte Zahl
     */
    public int wuerfeln() {
        return w.wuerfeln();
    }

}
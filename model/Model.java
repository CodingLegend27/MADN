package model;

import java.util.ArrayList;
import java.util.Arrays;

import sun.security.provider.ConfigFile.Spi;
import sun.security.util.ArrayUtil;

public class Model {
    
    private final Spieler[] spieler;

    private final int numFiguren;
    private final int numMaxSpieler;

    private int numAktSpieler;

    // jeder Spieler hat in der Mitte 4 Zielfelder, in denen er seine Spieler am Ende parken muss
    private boolean[][] zielfelder;

    // die 40 Spielpunkte im Feld außenrum werden durch ein Array modelliert
    private Spieler[] felder;

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
    }

    public void neuerSpieler(final String name, final String farbe) {
        final Spieler s = new Spieler(numFiguren, name, farbe);
        spieler[numAktSpieler] = s;
        numAktSpieler ++;
    }



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

    public Spieler[] getAktuellesSpielfeld() {
        return felder;
    }

    public Spieler[] getReihenfolgeSpieler() {
        return spieler;
    }

    public void neueFigurAufStart(Spieler s) {
        int indexSpieler = Arrays.asList(spieler).indexOf(s);
        int startPosition = indexSpieler * 10;
    }

}
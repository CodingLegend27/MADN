package controller;

import model.*;
import view.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CONTROLLER {

    private VIEW view;
    private Model model;

    private Spieler[] reihenfolge;

    // public int getPlayerPosition(){
    //     return 0;

    // }



    public CONTROLLER() {

        view = new VIEW();
        // damit der Canvas von View sichtbar wird
        view.setPlayer("", 1);

        model = new Model(4, 4);

        // TODO: Erweiterung möglich mit eigenem Fenster:
        // Spieler können ihre Namen eingeben, diese werden dann gespeichert
        model.neuerSpieler("Gelb", "gelb");
        model.neuerSpieler("Grün", "grün");
        model.neuerSpieler("Rot", "rot");
        model.neuerSpieler("Blau", "blau");


        reihenfolge = model.getReihenfolgeSpieler();
    }

    public int wuerfeln() {
        int ergebnis = model.wuerfeln();
        
        // TODO umändern in View
        System.out.println(" > Gewürfelte Zahl: " + ergebnis);

        return ergebnis;
    }

    public int getSpielerNummer(Spieler s) {
        int anzahlFigurenAufFeld = s.getAnzahlFigurenAufSpielfeld();
        System.out.println(">> Welche Figur soll bewegt werden (von " + anzahlFigurenAufFeld + " bis 1) ?" );
        Scanner sc = new Scanner(System.in);
        String eingabe = sc.next();

        int numFigur = 0;
        try {
            numFigur = Integer.valueOf(eingabe);
        } catch (Exception e) {
            System.out.println("> Bitte eine Zahl eingeben! \n");
            getSpielerNummer(s);
        }

        if (numFigur > anzahlFigurenAufFeld || numFigur == 0) {
            System.out.println("Bitte eine gültige Figur eingeben! \n");
            getSpielerNummer(s);
        }

        return numFigur;
    }

    public void main() {
        while (true) {
            for (Spieler spieler : reihenfolge) {
                // aktualisiereSpielfeld();

                System.out.println("\n\nJetzt an der Reihe: " + spieler.getName());

                if (spieler.getAnzahlFigurenAufSpielfeld() == 0) {
                    
                    // Spieler hat 3 Versuche
                    for (int i = 0; i < 3; i++) {
                        System.out.println("> Keine Figur auf dem Feld --> 6 wird benötigt");
                        if (wuerfeln() == 6) {
                            System.out.println(">> 6 wurde gewürfelt --> Spieler wird auf das Feld bewegt");
                            model.neueFigurAufStart(spieler);
                            aktualisiereSpielfeld();
                            break;
                        }
                        else {
                            System.out.println(" >> das hat leider nicht funktioniert ☹️\n");
                            wait(3000);
                        }
                    }
                    
                    
                }
                else {
                    int wuerfelErgebnis = wuerfeln();

                    // Anmerkung: Da noch kein MouseListener implementiert wurde,
                    // und somit nicht auf ein spezifisches Feld geklickt werden kann,
                    // kann der Benutzer eine Zahl eingeben und somit eine seiner Figuren auswählen.
                    int numFigur = getSpielerNummer(spieler);
                    int feldNummer = model.getNumFelderFiguren(spieler).get(numFigur-1);
                    
                    int zielfeld = model.schickeFigureWeiter(feldNummer, spieler, wuerfelErgebnis);
                    view.movePlayer(spieler.getFarbe(), feldNummer, zielfeld);
                    wait(3000);

                }

            }
            
        }
    }

    public void aktualisiereSpielfeld() {
        deleteAktuellesSpielfeld();
        Spieler[] felder = model.getAktuellesSpielfeld();
            
            for (Spieler feld : felder) {
                if (feld != null) {
                    String farbeSpieler = feld.getFarbe();
                    view.setPlayer(farbeSpieler, Arrays.asList(felder).indexOf(feld));
                }
            }
    }

    private void deleteAktuellesSpielfeld() {
        Spieler[] felder = model.getAktuellesSpielfeld();

        for (Spieler feld : felder) {
            if (feld != null) {
                // System.out.println(Arrays.asList(felder).indexOf(feld));
                view.deletePlayer(Arrays.asList(felder).indexOf(feld));
            }
        }
    }
 
    private void wait(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        CONTROLLER c = new CONTROLLER();
        c.main();
    }


}

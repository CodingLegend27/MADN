package view;
import java.awt.*;

import javax.swing.*;
import controller.*;
import java.util.*;

public class VIEW extends JFrame
{
    ArrayList <int[]> felder;
    ArrayList <int[]> blaueshaus;
    ArrayList <int[]> gelbeshaus;
    ArrayList <int[]> grüneshaus;
    ArrayList <int[]> roteshaus;
    ArrayList <int[]> blauebase;
    ArrayList <int[]> gelbebase;
    ArrayList <int[]> grünebase;
    ArrayList <int[]> rotebase;
    ArrayList <int[]> extrafelder;
    private CONTROLLER controller;
    private int[] feld1,feld2,feld3,feld4,feld5,feld6,feld7,feld8,feld9,feld10,feld11,feld12,feld13,feld14,feld15,feld16,feld17,feld18,feld19,feld20,feld21,feld22,feld23,feld24,feld25,feld26,feld27,feld28,feld29,feld30,feld31,feld32,feld33,feld34,feld35,feld36,feld37,feld38,feld39,feld40;
    private int[] rotbase1,rotbase2,rotbase3,rotbase4,gelbbase1,gelbbase2,gelbbase3,gelbbase4,blaubase1,blaubase2,blaubase3,blaubase4,grünbase1,grünbase2,grünbase3,grünbase4;
    private int[] grünhaus1,grünhaus2,grünhaus3,grünhaus4, rothaus1, rothaus2, rothaus3, rothaus4, blauhaus1, blauhaus2, blauhaus3, blauhaus4, gelbhaus1, gelbhaus2, gelbhaus3, gelbhaus4;
    
    public VIEW(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,1000);
        this.setVisible(true);

        
        //Felder für die Koordinaten und ob sich eine figur darauf befindet(in drittem platz)
        felder = new ArrayList <int[]>();
        blaueshaus = new ArrayList <int[]>();
        gelbeshaus = new ArrayList <int[]>();
        roteshaus = new ArrayList <int[]>();
        grüneshaus = new ArrayList <int[]>();
        blauebase = new ArrayList <int[]>();
        gelbebase = new ArrayList <int[]>();
        grünebase = new ArrayList <int[]>();
        rotebase = new ArrayList <int[]>();
        extrafelder = new ArrayList <int[]>();
        feld1 = new int[3];
        feld2 = new int[3];
        feld3 = new int[3];
        feld4 = new int[3];
        feld5 = new int[3];
        feld6 = new int[3];
        feld7 = new int[3];
        feld8 = new int[3];
        feld9 = new int[3];
        feld10 = new int[3];
        feld11 = new int[3];
        feld12 = new int[3];
        feld13 = new int[3];
        feld14 = new int[3];
        feld15 = new int[3];
        feld16 = new int[3];
        feld17 = new int[3];
        feld18 = new int[3];
        feld19 = new int[3];
        feld20 = new int[3];
        feld21 = new int[3];
        feld22 = new int[3];
        feld23 = new int[3];
        feld24 = new int[3];
        feld25 = new int[3];
        feld26 = new int[3];
        feld27 = new int[3];
        feld28 = new int[3];
        feld29 = new int[3];
        feld30 = new int[3];
        feld31 = new int[3];
        feld32 = new int[3];
        feld33 = new int[3];
        feld34 = new int[3];
        feld35 = new int[3];
        feld36 = new int[3];
        feld37 = new int[3];
        feld38 = new int[3];
        feld39 = new int[3];
        feld40 = new int[3];
        grünhaus1 = new int[3];
        grünhaus2 = new int[3];
        grünhaus3 = new int[3];
        grünhaus4 = new int[3];
        blauhaus1 = new int[3];
        blauhaus2 = new int[3];
        blauhaus3 = new int[3];
        blauhaus4 = new int[3];
        gelbhaus1 = new int[3];
        gelbhaus2 = new int[3];
        gelbhaus3 = new int[3];
        gelbhaus4 = new int[3];
        rothaus1 = new int[3];
        rothaus2 = new int[3];
        rothaus3 = new int[3];
        rothaus4 = new int[3];
        grünbase1 = new int[3];
        grünbase2 = new int[3];
        grünbase3 = new int[3];
        grünbase4 = new int[3];
        blaubase1 = new int[3];
        blaubase2 = new int[3];
        blaubase3 = new int[3];
        blaubase4 = new int[3];
        gelbbase1 = new int[3];
        gelbbase2 = new int[3];
        gelbbase3 = new int[3];
        gelbbase4 = new int[3];
        rotbase1 = new int[3];
        rotbase2 = new int[3];
        rotbase3 = new int[3];
        rotbase4 = new int[3];
        
        felderzuordnen();
       
    }
    //speichert Koordinaten zu allen Feldern
    public void felderzuordnen(){

        feld1[0] =  100 ;
        feld1[1] =  380 ;
        feld2[0] =  170 ;
        feld2[1] =  380 ;
        feld3[0] =  240;
        feld3[1] =  380 ;
        feld4[0] =  310;
        feld4[1] =  380 ;
        feld5[0] =  380;
        feld5[1] =  380 ;
        feld6[0] =  380;
        feld6[1] =  310;
        feld7[0] =  380;
        feld7[1] =  240;
        feld8[0] =  380;
        feld8[1] =  170;
        feld9[0] =  380;
        feld9[1] =  100;
        feld10[0] = 450;
        feld10[1] = 100;
        feld11[0] = 520 ;
        feld11[1] = 100;
        feld12[0] = 520 ;
        feld12[1] = 170;
        feld13[0] = 520 ;
        feld13[1] = 240;
        feld14[0] = 520 ;
        feld14[1] = 310;
        feld15[0] = 520 ;
        feld15[1] = 380 ;
        feld16[0] = 590;
        feld16[1] = 380 ;
        feld17[0] = 660;
        feld17[1] = 380 ;
        feld18[0] = 730;
        feld18[1] = 380 ;
        feld19[0] = 800;
        feld19[1] = 380 ;
        feld20[0] = 800;
        feld20[1] = 450;
        feld21[0] = 800;
        feld21[1] = 520;
        feld22[0] = 730;
        feld22[1] = 520;
        feld23[0] = 660;
        feld23[1] = 520;
        feld24[0] = 590;
        feld24[1] = 520;
        feld25[0] = 520;
        feld25[1] = 520;
        feld26[0] = 520;
        feld26[1] = 590;
        feld27[0] = 520;
        feld27[1] = 660;
        feld28[0] = 520;
        feld28[1] = 730;
        feld29[0] = 520;
        feld29[1] = 800;
        feld30[0] = 450;
        feld30[1] = 800;
        feld31[0] = 380;
        feld31[1] = 800;
        feld32[0] = 380;
        feld32[1] = 730;
        feld33[0] = 380;
        feld33[1] = 660;
        feld34[0] = 380;
        feld34[1] = 590;
        feld35[0] = 380;
        feld35[1] = 520;
        feld36[0] = 310;
        feld36[1] = 520;
        feld37[0] = 240;
        feld37[1] = 520;
        feld38[0] = 170 ;
        feld38[1] = 520;
        feld39[0] = 100;
        feld39[1] = 520;
        feld40[0] = 100;
        feld40[1] = 450;
        //base
        gelbbase1[0] = 100;
        gelbbase1[1] = 100;
        gelbbase2[0] = 100;
        gelbbase2[1] = 170;
        gelbbase3[0] = 170;
        gelbbase3[1] = 100;
        gelbbase4[0] = 170;
        gelbbase4[1] = 170;
        
        blaubase1[0] = 100;
        blaubase1[1] = 730;
        blaubase2[0] = 100;
        blaubase2[1] = 800;
        blaubase3[0] = 170;
        blaubase3[1] = 730;
        blaubase4[0] = 170;
        blaubase4[1] = 800;
        
        rotbase1[0] = 730;
        rotbase1[1] = 730;
        rotbase2[0] = 730;
        rotbase2[1] = 800;
        rotbase3[0] = 800;
        rotbase3[1] = 730;
        rotbase4[0] = 800;
        rotbase4[1] = 800;
        
        grünbase1[0] = 730;
        grünbase1[1] = 100;
        grünbase2[0] = 730;
        grünbase2[1] = 170;
        grünbase3[0] = 800;
        grünbase3[1] = 100;
        grünbase4[0] = 800;
        grünbase4[1] = 170;
        //haus
        gelbhaus1[0] = 170;
        gelbhaus1[1] = 450;
        gelbhaus2[0] = 170+70;
        gelbhaus2[1] = 450;
        gelbhaus3[0] = 170+140;
        gelbhaus3[1] = 450;
        gelbhaus4[0] = 170+210;
        gelbhaus4[1] = 450;
        
        blauhaus1[0] = 450;
        blauhaus1[1] = 520+210;
        blauhaus2[0] = 450;
        blauhaus2[1] = 520+140;
        blauhaus3[0] = 450;
        blauhaus3[1] = 520+70;
        blauhaus4[0] = 450;
        blauhaus4[1] = 520;
        
        rothaus1[0] = 520+210;
        rothaus1[1] = 450;
        rothaus2[0] = 520+140;
        rothaus2[1] = 450;
        rothaus3[0] = 520+70;
        rothaus3[1] = 450;
        rothaus4[0] = 520;
        rothaus4[1] = 450;
        
        grünhaus1[0] = 450;
        grünhaus1[1] = 170;
        grünhaus2[0] = 450;
        grünhaus2[1] = 170+70;
        grünhaus3[0] = 450;
        grünhaus3[1] = 170+140;
        grünhaus4[0] = 450;
        grünhaus4[1] = 170+210;
        

        felder.add(feld1);
        felder.add(feld2);
        felder.add(feld3);
        felder.add(feld4);
        felder.add(feld5);
        felder.add(feld6);
        felder.add(feld7);
        felder.add(feld8);
        felder.add(feld9);
        felder.add(feld10);
        felder.add(feld11);
        felder.add(feld12);
        felder.add(feld13);
        felder.add(feld14);
        felder.add(feld15);
        felder.add(feld16);
        felder.add(feld17);
        felder.add(feld18);
        felder.add(feld19);
        felder.add(feld20);
        felder.add(feld21);
        felder.add(feld22);
        felder.add(feld23);
        felder.add(feld24);
        felder.add(feld25);
        felder.add(feld26);
        felder.add(feld27);
        felder.add(feld28);
        felder.add(feld29);
        felder.add(feld30);
        felder.add(feld31);
        felder.add(feld32);
        felder.add(feld33);
        felder.add(feld34);
        felder.add(feld35);
        felder.add(feld36);
        felder.add(feld37);
        felder.add(feld38);
        felder.add(feld39);
        felder.add(feld40);

        rotebase.add(rotbase1);
        rotebase.add(rotbase2);
        rotebase.add(rotbase3);
        rotebase.add(rotbase4);
        grünebase.add(grünbase1);
        grünebase.add(grünbase2);
        grünebase.add(grünbase3);
        grünebase.add(grünbase4);
        gelbebase.add(gelbbase1);
        gelbebase.add(gelbbase2);
        gelbebase.add(gelbbase3);
        gelbebase.add(gelbbase4);
        blauebase.add(blaubase1);
        blauebase.add(blaubase2);
        blauebase.add(blaubase3);
        blauebase.add(blaubase4);

        blaueshaus.add(blauhaus1);
        blaueshaus.add(blauhaus2);
        blaueshaus.add(blauhaus3);
        blaueshaus.add(blauhaus4);
        grüneshaus.add(grünhaus1);
        grüneshaus.add(grünhaus2);
        grüneshaus.add(grünhaus3);
        grüneshaus.add(grünhaus4);
        gelbeshaus.add(gelbhaus1);
        gelbeshaus.add(gelbhaus2);
        gelbeshaus.add(gelbhaus3);
        gelbeshaus.add(gelbhaus4);
        roteshaus.add(rothaus1);
        roteshaus.add(rothaus2);
        roteshaus.add(rothaus3);
        roteshaus.add(rothaus4);

        extrafelder.add(rotbase1);
        extrafelder.add(rotbase2);
        extrafelder.add(rotbase3);
        extrafelder.add(rotbase4);
        extrafelder.add(grünbase1);
        extrafelder.add(grünbase2);
        extrafelder.add(grünbase3);
        extrafelder.add(grünbase4);
        extrafelder.add(gelbbase1);
        extrafelder.add(gelbbase2);
        extrafelder.add(gelbbase3);
        extrafelder.add(gelbbase4);
        extrafelder.add(blaubase1);
        extrafelder.add(blaubase2);
        extrafelder.add(blaubase3);
        extrafelder.add(blaubase4);

        extrafelder.add(blauhaus1);
        extrafelder.add(blauhaus2);
        extrafelder.add(blauhaus3);
        extrafelder.add(blauhaus4);
        extrafelder.add(grünhaus1);
        extrafelder.add(grünhaus2);
        extrafelder.add(grünhaus3);
        extrafelder.add(grünhaus4);
        extrafelder.add(gelbhaus1);
        extrafelder.add(gelbhaus2);
        extrafelder.add(gelbhaus3);
        extrafelder.add(gelbhaus4);
        extrafelder.add(rothaus1);
        extrafelder.add(rothaus2);
        extrafelder.add(rothaus3);
        extrafelder.add(rothaus4);
    }

    public void paint(Graphics g){
        //hintergrund
        g.setColor(Color.black);
        g.fillRect(0, 0, 1000, 1000);

        //breitere Kreise
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));

        //zeichnet die Felder
        g.setColor(Color.white);
         for(int i = 0; i < 40 ; i++){
                int[] feld = felder.get(i);
                g.drawOval( feld[0],feld[1], 50 ,50);
         }
         //rote base
         g.setColor(Color.red);
         for (int i =0; i<4; i++ ){
             int[] feld = rotebase.get(i);
             g.drawOval( feld[0],feld[1], 50 ,50);
         }
         //grün base
         g.setColor(Color.green);
         for (int i =0; i<4; i++ ){
             int[] feld = grünebase.get(i);
             g.drawOval( feld[0],feld[1], 50 ,50);
         }
         //gelb base
         g.setColor(Color.yellow);
         for (int i =0; i<4; i++ ){
             int[] feld = gelbebase.get(i);
             g.drawOval( feld[0],feld[1], 50 ,50);
         }
         //blau base
         g.setColor(Color.blue);
         for (int i =0; i<4; i++ ){
             int[] feld = blauebase.get(i);
             g.drawOval( feld[0],feld[1], 50 ,50);
         }
         
         //blaues haus
         g.setColor(Color.blue);
         for (int i =0; i<4; i++ ){
             int[] feld = blaueshaus.get(i);
             g.drawOval( feld[0],feld[1], 50 ,50);
         }
         //grünes haus
         g.setColor(Color.green);
         for (int i =0; i<4; i++ ){
             int[] feld = grüneshaus.get(i);
             g.drawOval( feld[0],feld[1], 50 ,50);
         }
         //gelbes haus
         g.setColor(Color.yellow);
         for (int i =0; i<4; i++ ){
             int[] feld = gelbeshaus.get(i);
             g.drawOval( feld[0],feld[1], 50 ,50);
         }
         //rotes haus
         g.setColor(Color.red);
         for (int i =0; i<4; i++ ){
             int[] feld = roteshaus.get(i);
             g.drawOval( feld[0],feld[1], 50 ,50);
         }
        //Startpunkte
        g.setColor(Color.yellow);
        g.drawOval(100,380,50,50);
        g.setColor(Color.blue);
        g.drawOval(380,800,50,50);
        g.setColor(Color.red);
        g.drawOval(800,520,50,50);
        g.setColor(Color.green);
        g.drawOval(520,100,50,50);

        
         // 1 == blau , 2 == gelb, 3 == grün, 4 == rot
         //get alle felder durch ob eine Figur drau steht(in feld[2] wird die farbe gespeichert)
         for(int i = 0; i< 40 ;i++){
                int[] feld = felder.get(i);
                if(feld[2] == 0){
                    g.setColor(Color.black);
                    g.fillOval(feld[0], feld[1],50,50 );
                }
                else if(feld[2] == 1){
                    g.setColor(Color.blue);
                    g.fillOval(feld[0], feld[1],50,50 );
                }
                else if(feld[2] == 2){
                    g.setColor(Color.yellow);
                    g.fillOval(feld[0], feld[1],50,50 );
                }
                else if(feld[2] == 3){
                    g.setColor(Color.green);
                    g.fillOval(feld[0], feld[1],50,50 );
                }
                else if(feld[2] == 4){
                    g.setColor(Color.red);
                    g.fillOval(feld[0], feld[1],50,50 );

                }
         }
        for(int i= 0 ; i<32; i++){
            int[] feld = extrafelder.get(i);
            if(feld[2] == 0){
                g.setColor(Color.black);
                g.fillOval(feld[0], feld[1],50,50 );
            }
            else if(feld[2] == 1){
                g.setColor(Color.blue);
                g.fillOval(feld[0], feld[1],50,50 );
            }
            else if(feld[2] == 2){
                g.setColor(Color.yellow);
                g.fillOval(feld[0], feld[1],50,50 );
            }
            else if(feld[2] == 3){
                g.setColor(Color.green);
                g.fillOval(feld[0], feld[1],50,50 );
            }
            else if(feld[2] == 4){
                g.setColor(Color.red);
                g.fillOval(feld[0], feld[1],50,50 );

            }
        } 

        }
    //übersetzt den String "farbe" in farben
    public void setPlayer(String farbe, int feld){
        // Change von Chrissi
        // int[] feld_ = felder.get(feld-1);
        int[] feld_ = felder.get(feld);
        switch(farbe){
            case "blau":feld_[2]= 1;
                        break;
            case "gelb":feld_[2] =2;
                        break;
            case "grün":feld_[2] =3;
                        break;
            case"rot":  feld_[2] =4;
                        break;
            default:    feld_[2] = 0;
                        break;
        }
        
        felder.set( feld, feld_);
        // felder.set( feld-1, feld_);
        this.repaint();
    }
    //setzt feld[2] auf 0 also befindet sich dann keine Figur mehr darauf   
    public void deletePlayer(int feld){
        // Change von Chrissi
        // int[] feld_ = felder.get(feld-1);
        int[] feld_ = felder.get(feld);
        feld_[2] = 0; 
        this.repaint();
    }
    public void movePlayer(String farbe, int feldAlt, int feldNeu){
        deletePlayer(feldAlt);
        setPlayer(farbe, feldNeu);
    }

    public void setPlayerBase(String farbe){
        switch(farbe){
            case "blau":if(blaubase1[2] == 0){
                            blaubase1[2] = 1;                    
                        }
                        else if(blaubase2[2]== 0){
                            blaubase2[2] =1;
                        }
                        else if(blaubase3[2] == 0){
                            blaubase3[2] = 1;
                        }
                        else if(blaubase4[2] == 0){
                            blaubase4[2] = 1;
                        } 
                        break;
            case "gelb":if(gelbbase1[2] == 0){
                            gelbbase1[2] = 2;                    
                        }
                        else if(gelbbase2[2]== 0){
                            gelbbase2[2] =2;
                        }
                        else if(gelbbase3[2] == 0){
                            gelbbase3[2] = 2;
                        }
                        else if(gelbbase4[2] == 0){
                            gelbbase4[2] = 2;
                        }
                        break;
            case "grün":if(grünbase1[2] == 0){
                            grünbase1[2] = 3;                    
                        }
                        else if(grünbase2[2]== 0){
                            grünbase2[2] =3;
                        }
                        else if(grünbase3[2] == 0){
                            grünbase3[2] = 3;
                        }
                        else if(grünbase4[2] == 0){
                            grünbase4[2] = 3;
                        }
                        break;
            case"rot":  if(rotbase1[2] == 0){
                            rotbase1[2] = 4;                    
                        }
                        else if(rotbase2[2]== 0){
                            rotbase2[2] =4;
                        }
                        else if(rotbase3[2] == 0){
                            rotbase3[2] = 4;
                        }
                        else if(rotbase4[2] == 0){
                            rotbase4[2] = 4;
                        }
                        break;
            default:    System.out.println("falsche farbeingabe");
        }
        this.repaint();
    }
    public void deletePlayerBase(String farbe){
        switch(farbe){
            case "blau":if(blaubase1[2] == 1){
                            blaubase1[2] = 0;                    
                        }
                        else if(blaubase2[2]== 1){
                            blaubase2[2] =0;
                        }
                        else if(blaubase3[2] == 1){
                            blaubase3[2] = 0;
                        }
                        else if(blaubase4[2] == 1){
                            blaubase4[2] = 0;
                        } 
                        break;
            case "gelb":if(gelbbase1[2] == 2){
                            gelbbase1[2] = 0;                    
                        }
                        else if(gelbbase2[2]== 2){
                            gelbbase2[2] =0;
                        }
                        else if(gelbbase3[2] == 2){
                            gelbbase3[2] = 0;
                        }
                        else if(gelbbase4[2] == 2){
                            gelbbase4[2] = 0;
                        }
                        break;
            case "grün":if(grünbase1[2] == 3){
                            grünbase1[2] = 0;                    
                        }
                        else if(grünbase2[2]== 3){
                            grünbase2[2] =0;
                        }
                        else if(grünbase3[2] == 3){
                            grünbase3[2] = 0;
                        }
                        else if(grünbase4[2] == 3){
                            grünbase4[2] = 0;
                        }
                        break;
            case"rot":  if(rotbase1[2] == 4){
                            rotbase1[2] = 0;                    
                        }
                        else if(rotbase2[2]== 4){
                            rotbase2[2] =0;
                        }
                        else if(rotbase3[2] == 4){
                            rotbase3[2] = 0;
                        }
                        else if(rotbase4[2] == 4){
                            rotbase4[2] = 0;
                        }
                        break;
            default:    System.out.println("falsche farbeingabe");
        }
        this.repaint();

    }
    public static void main(String[] args){
        
        VIEW v = new VIEW();
        v.setPlayer("gelb", 4);
        v.setPlayer("blau" , 10);
        v.setPlayer("blau", 12);
        v.setPlayerBase("blau");
        v.setPlayerBase("blau");


        Scanner sc = new Scanner(System.in);
        String eingabe = sc.next();
        if(eingabe != "aaaaa"){
            v.deletePlayerBase("blau");
            v.deletePlayerBase("blau");
            // v.setPlayer("rot",30);
        }
    }
}
package view;
import java.awt.*;
import java.lang.reflect.Array;

import javax.swing.*;
import controller.*;
import java.util.*;


public class VIEW extends JFrame
{
    ArrayList <int[]> felder;
    private Canvas canvas;
    private CONTROLLER controller;
    private int[] feld1,feld2,feld3,feld4,feld5,feld6,feld7,feld8,feld9,feld10,feld11,feld12,feld13,feld14,feld15,feld16,feld17,feld18,feld19,feld20,feld21,feld22,feld23,feld24,feld25,feld26,feld27,feld28,feld29,feld30,feld31,feld32,feld33,feld34,feld35,feld36,feld37,feld38,feld39,feld40;
    public VIEW(){

        JPanel panel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,1000);
        this.setVisible(true);
        felder = new ArrayList <int[]>();
        
        Graphics g = canvas.getGraphics();
        paint(g);


    }
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
        feld31[1] = 730;
        feld32[0] = 380;
        feld32[1] = 660;
        feld33[0] = 380;
        feld33[1] = 590;
        feld34[0] = 380;
        feld34[1] = 520;
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

    }


    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, 1000, 1000);
        g.setColor(Color.GRAY);
        //mittlere Reihe oben
        g.fillOval(100,380,50,50);
        g.fillOval(170,380,50,50);
        g.fillOval(240,380,50,50);
        g.fillOval(310,380,50,50);
        g.fillOval(380,380,50,50);
        g.fillOval(520,380,50,50);
        g.fillOval(590,380,50,50);
        g.fillOval(660,380,50,50);
        g.fillOval(730,380,50,50);
        g.fillOval(800,380,50,50);
        
        //mittlere Reige mitte
        g.fillOval(100,450,50,50);
        g.fillOval(800,450,50,50);
        g.setColor(Color.yellow);
        g.drawOval(175,455,40,40);
        g.drawOval(175+70,455,40,40);
        g.drawOval(175+140,455,40,40);
        g.drawOval(175+210,455,40,40);
        g.setColor(Color.red);
        g.drawOval(520,455,40,40);
        g.drawOval(520+70,455,40,40);
        g.drawOval(520+140,455,40,40);
        g.drawOval(520+210,455,40,40);
        g.setColor(Color.GRAY);
        

        //mittlere Reihe unten
        g.fillOval(100,520,50,50);
        g.fillOval(170,520,50,50);
        g.fillOval(240,520,50,50);
        g.fillOval(310,520,50,50);
        g.fillOval(380,520,50,50);
        g.fillOval(520,520,50,50);
        g.fillOval(590,520,50,50);
        g.fillOval(660,520,50,50);
        g.fillOval(730,520,50,50);
        g.fillOval(800,520,50,50);

        //obenlinks nach unten
        g.fillOval(380,100,50,50);
        g.fillOval(380,170,50,50);
        g.fillOval(380,240,50,50);
        g.fillOval(380,310,50,50);
            //g.fillOval(380,380,50,50);
            //g.fillOval(380,520,50,50);
        g.fillOval(380,590,50,50);
        g.fillOval(380,660,50,50);
        g.fillOval(380,730,50,50);
        g.fillOval(380,800,50,50);

        //obenrechts nach unten
        g.fillOval(520,100,50,50);
        g.fillOval(520,170,50,50);
        g.fillOval(520,240,50,50);
        g.fillOval(520,310,50,50);
            //g.fillOval(520,380,50,50);
            //g.fillOval(520,520,50,50);
        g.fillOval(520,590,50,50);
        g.fillOval(520,660,50,50);
        g.fillOval(520,730,50,50);
        g.fillOval(520,800,50,50);

        //obenmitte
        g.fillOval(450,100,50,50);
        g.fillOval(450,800,50,50);
        g.setColor(Color.green);
        g.drawOval(455,175,40,40);
        g.drawOval(455,175+70,40,40);
        g.drawOval(455,175+140,40,40);
        g.drawOval(455,175+210,40,40);
        g.setColor(Color.blue);
        g.drawOval(455,595-70,40,40);
        g.drawOval(455,595,40,40);
        g.drawOval(455,595+70,40,40);
        g.drawOval(455,595+140,40,40);

    
        //Häuser und Startpunkte
        g.setColor(Color.yellow);
        g.drawOval(100,380,50,50);
        g.drawOval(100, 100, 52, 52);
        g.drawOval(100, 170, 50, 50);
        g.drawOval(170, 100, 50, 50);
        g.drawOval(170, 170, 50, 50);
        g.setColor(Color.blue);
        g.drawOval(380,800,50,50);
        g.drawOval(100, 730, 52, 52);
        g.drawOval(100, 800, 50, 50);
        g.drawOval(170, 730, 50, 50);
        g.drawOval(170, 800, 50, 50);
        g.setColor(Color.red);
        g.drawOval(800,520,50,50);
        g.drawOval(730, 730, 52, 52);
        g.drawOval(730, 800, 50, 50);
        g.drawOval(800, 730, 50, 50);
        g.drawOval(800, 800, 50, 50);
        g.setColor(Color.green);
        g.drawOval(520,100,50,50);
        g.drawOval(730, 100, 52, 52);
        g.drawOval(730, 170, 50, 50);
        g.drawOval(800, 100, 50, 50);
        g.drawOval(800, 170, 50, 50);

        
    }

    public int getPlayerposition(){
            return controller.getPlayerPosition();

    }
    public static void main(String[] args){
        VIEW v = new VIEW();
        
    }
}


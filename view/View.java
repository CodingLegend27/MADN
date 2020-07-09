package view;
import java.awt.*;
import javax.swing.*;
import controller.*;



public class VIEW extends JFrame
{
    private Canvas canvas;
    private CONTROLLER controller;

    public VIEW(){

        JPanel panel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,1000);
        this.setVisible(true);

        
        Graphics g = canvas.getGraphics();
        paint(g);


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
        

        //mittlere Reihe oben
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

        //Spieler









    }

    public void getPlayerposition(){
            controller.getPlayerPosition());

    }
    public static void main(String[] args){
        VIEW v = new VIEW();
        
    }
}


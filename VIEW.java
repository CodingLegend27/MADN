import java.awt.Color;
import java.awt.event.ActionListener;


import javax.swing.*;
public class VIEW extends JFrame
{
    private JTextField text = new JTextField(10);

    public VIEW(){

        JPanel panel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,1000);

        text.setForeground(Color.black);
        panel.add(text);

        this.add(panel);
        
        this.show();
    }

    public static void main(String[] args){
        VIEW v = new VIEW();
        
    }
}
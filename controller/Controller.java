package controller;

import model.*;
import view.*;
import java.awt.event.ActionListener;


public class Controller {

    private VIEW view;
    private Model model;

    public int getPlayerPosition(){
        return 0;

    }

    public Controller() {

        view = new VIEW();
        model = new Model(4, 4);
        
    }


    public static void main(String[] args) {
        Controller c = new Controller();
    }


}
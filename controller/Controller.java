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

    public Controller(VIEW view, Model model){

        this.view = new VIEW();
        this.model = new Model(4, 4);
    }

}
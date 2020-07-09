package controller;

import model.*;
import view.*;
import java.awt.event.ActionListener;


public class CONTROLLER {

    private VIEW view;
    private Model model;

    public int getPlayerPosition(){
        return 0;

    }

    public CONTROLLER(VIEW view, Model model){

        this.view = view;
        this.model = model;
    }

}
package controller;

import model.*;
import view.*;
import java.awt.event.ActionListener;


public class CONTROLLER {

    private VIEW view;
    private Model model;

    // public int getPlayerPosition(){
    //     return 0;

    // }

    public CONTROLLER() {

        view = new VIEW();
        model = new Model(4, 4);
        
    }


    public static void main(String[] args) {
        CONTROLLER c = new CONTROLLER();
    }


}
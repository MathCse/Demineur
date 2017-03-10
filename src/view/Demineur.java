/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.lang.System;
import java.util.Scanner;

import controller.Init;
import model.Grid;

/**
 *
 * @author pa
 */
public class Demineur {

    public static void main(String[] args) {
        Init initialisation = new Init(); 
        Grid grid = new Grid(initialisation.getLine(), initialisation.getRow(), initialisation.getPercent());
        
        //grid.printInit();
        grid.printDebug();
    }
    
}
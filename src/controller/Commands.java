/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Grid;
import model.Marks;

/**
 *
 * @author mathieu
 */
public class Commands {

    private char action;
    private int i, j;
    private char argument;

    public Commands() {

    }

    public Commands(char action, int i, int j, char argument) {
        this.action = action;
        this.i = i;
        this.j = j;
        this.argument = argument;
    }

    public char getAction() {
        return action;
    }

    public void DoAction(Grid grid) {
        try {
            if (i < 0 || j < 0) {
                throw new Exception("Les coordonnées doivent être positives");
            } else if (i > grid.getPlate().length - 1 || j > grid.getPlate()[0].length - 1) {
                throw new Exception("Les coordonnées doivent être inférieur à la taille max du plateau");
            } else {
                switch (action) {

                    case 'd':
                        grid.getPlate()[i][j].setMasked(false);
                        break;

                    case 'm':
                        switch (argument) {
                            // On marque la case
                            case 'x':
                                grid.getPlate()[i][j].setMark(Marks.MARKED_MINE);
                                break;

                            case '?':
                                grid.getPlate()[i][j].setMark(Marks.MARKED_UNKNOWN);
                                break;

                            case '#':
                                grid.getPlate()[i][j].setMark(Marks.NOT_MARKED);
                                break;

                        }
                        break;

                    case 'q':
                        // On quitte le jeu
                        
                        break;

                }
            }
        } catch (Exception e) {
            System.out.println("Erreur : " + e);
        }
    }

    public void setAction(char action) {
        this.action = action;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public char getArgument() {
        return argument;
    }

    public void setArgument(char argument) {
        this.argument = argument;
    }

}

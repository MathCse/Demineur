/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;

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

    public void DoAction(Game game) {
        try {
            if (i < 0 || j < 0) {
                throw new Exception("Les coordonnées doivent être positives");
            } else if (i > game.getGrid().getPlate().length - 1 || j > game.getGrid().getPlate()[0].length - 1) {
                throw new Exception("Les coordonnées doivent être inférieur à la taille max du plateau");
            } else {
                switch (action) {

                    case 'd':
                        if(game.getGrid().getPlate()[i][j].getNbNeighboors() == 0){
                            this.unmaskNeighboors(game.getGrid().getPlate(), i, j, game.getGrid().getI(), game.getGrid().getJ());
                        } else {
                            game.getGrid().getPlate()[i][j].setMasked(false);
                        }
                        break;

                    case 'm':
                        switch (argument) {
                            // On marque la case
                            case 'x':
                                game.getGrid().getPlate()[i][j].setMark(Marks.MARKED_MINE);
                                break;

                            case '?':
                                game.getGrid().getPlate()[i][j].setMark(Marks.MARKED_UNKNOWN);
                                break;

                            case '#':
                                game.getGrid().getPlate()[i][j].setMark(Marks.NOT_MARKED);
                                break;

                        }
                        break;

                    case 'q':
                        game.setQuit(true);
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

    public void unmaskNeighboors(Cell[][] plate, int i, int j, int maxi, int maxj){
        /*if(i-1 >= 0){
            if(plate[i-1][j].getNbNeighboors() == 0){
                unmaskNeighboors(plate, i-1, j, maxi, maxj);
            }
            if(j-1 >= 0){
                if(plate[i-1][j-1].getNbNeighboors() == 0){
                    unmaskNeighboors(plate, i-1, j-1, maxi, maxj);
                }
            }
            if(j+1 <= maxj-1){
                if(plate[i-1][j+1].getNbNeighboors() == 0){
                    unmaskNeighboors(plate, i-1, j+1, maxi, maxj);
                }
            }
        }
        if(j-1 >= 0){
            if(plate[i][j-1].getNbNeighboors() == 0){
                unmaskNeighboors(plate, i, j-1, maxi, maxj);
            }
        }
        if(i+1 <= maxi-1){
            if(plate[i+1][j].getNbNeighboors() == 0){
                unmaskNeighboors(plate, i+1, j, maxi, maxj);
            }
            if(j-1 >= 0){
                if(plate[i+1][j-1].getNbNeighboors() == 0){
                    unmaskNeighboors(plate, i+1, j-1, maxi, maxj);
                }
            }
            if(j+1 <= maxj-1){
                if(plate[i+1][j+1].getNbNeighboors() == 0){
                    unmaskNeighboors(plate, i+1, j+1, maxi, maxj);
                }
            }
        }
        if(j+1 <= maxj-1){
            if(plate[i][j+1].getNbNeighboors() == 0){
                unmaskNeighboors(plate, i, j+1, maxi, maxj);
            }
        }*/
        
        plate[i][j].setMasked(false);
    }
}

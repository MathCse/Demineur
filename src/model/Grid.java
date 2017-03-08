package model;

import model.Cell;

/**
 *
 * @author pa
 */
public class Grid {
    private final Cell[][] plate;
    private int percent;
    private int i;
    private int j;

    public Grid(int i, int j, int percent) {
        this.i = i;
        this.j = j;
        plate = new Cell[i][j];
        this.percent = percent;
        System.out.println("Nouvelle grille de démineur de " + i + " x " + j + " avec " + percent + "% de mines.");
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
    
    public void print() {
        for(int x = 0 ; x < this.i ; x++){
            for(int y = 0 ; y < this.j ; y++){
                System.out.print("# ");
            }
            System.out.println("");
        }
    }
}

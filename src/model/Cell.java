package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author pa
 */
public class Cell extends Observable {

    private boolean masked;
    private PossibleCell content;
    private int nbNeighboors;
    private Marks mark;
    private Observer obs;
    
    public Cell() {
        this.masked = true;
        this.content = PossibleCell.EMPTY;
        this.nbNeighboors = 0;
        this.mark = Marks.NOT_MARKED;
    }
    

    public boolean isMasked() {
        return masked;
    }

    public void setMasked(boolean masked) {
        this.masked = masked;
        setChanged(); 
        notifyObservers(masked); 
    }

    public PossibleCell getContent() {
        return content;
    }

    public void setContent(PossibleCell content) {  
        this.content = content;
    }

    public int getNbNeighboors() {
        return nbNeighboors;
    }

    public void setNbNeighboors(int nbNeighboors) {
        this.nbNeighboors = nbNeighboors;
    }

    public Marks getMark() {
        return mark;
    }

    public void setMark(Marks mark) {
        if (this.isMasked()) {
            this.mark = mark;
        }
    }

}

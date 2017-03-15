package model;

/**
 *
 * @author pa
 */

public class Cell {
    private boolean masked;
    private PossibleCell content;
    private int nbNeighboors;
    private Marks mark;
    
    public Cell(){
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

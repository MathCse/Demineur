package model;

/**
 *
 * @author pa
 */

public class Cell {
    public boolean masked;
    public PossibleCell content;
    
    public Cell(){
        masked = true;
        content = PossibleCell.EMPTY;
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
    
    
}

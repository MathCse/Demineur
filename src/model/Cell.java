package model;

/**
 *
 * @author pa
 */

public class Cell {
    boolean masked;
    PossibleCell content;
    
    public Cell(){
        masked = true;
        content = PossibleCell.EMPTY;
    }
}

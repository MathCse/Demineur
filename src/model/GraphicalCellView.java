package model;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class GraphicalCellView extends JButton {
    private boolean masked;
    private PossibleCell content;
    private int nbNeighboors;
    private Marks mark;
    
    public GraphicalCellView(){
        this.masked = true;
        this.content = PossibleCell.EMPTY;
        this.nbNeighboors = 0;
        this.mark = Marks.NOT_MARKED;
        
        //bouton.setHorizontalTextPosition(SwingConstants.CENTER);
        //bouton.setVerticalTextPosition(SwingConstants.BOTTOM);
        
        this.addMouseListener(new MouseAdapter(){      
            public void mouseClicked(MouseEvent event){
                if(SwingUtilities.isLeftMouseButton(event)){                
                    revealed();
                }else if(SwingUtilities.isRightMouseButton(event)){
                    //System.out.println("Clic droit");
                }
            }
        });
        
    }
    
    public void revealed(){
        this.setEnabled(false);
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
        this.mark = mark;
    }
}

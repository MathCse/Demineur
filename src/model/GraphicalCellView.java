package model;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GraphicalCellView extends JButton {
    private boolean masked;
    private PossibleCell content;
    private int nbNeighboors;
    private Marks mark;
    private final GraphicalGridView theFrame;
    
    public GraphicalCellView(GraphicalGridView myFrame, int i, int j, int maxi, int maxj){
        this.masked = true;
        this.content = PossibleCell.EMPTY;
        this.nbNeighboors = 0;
        this.mark = Marks.NOT_MARKED;
        this.theFrame = myFrame;
        ImageIcon mine = new ImageIcon("src/imgs/mine.png");
        ImageIcon flag = new ImageIcon("src/imgs/flag.png");
        ImageIcon unknown = new ImageIcon("src/imgs/unknown.png");
        ImageIcon not = new ImageIcon("src/imgs/not.png");

        
        this.addMouseListener(new MouseAdapter(){      
            @Override
            public void mouseClicked(MouseEvent event){
                if(SwingUtilities.isLeftMouseButton(event)){                
                    revealed(mine, theFrame, i, j, maxi, maxj);
                }else if(SwingUtilities.isRightMouseButton(event)){
                    toMark(flag, unknown, not);
                }
            }
        });
        
    }
    
    public void toMark(ImageIcon flag, ImageIcon unknown, ImageIcon not){
        switch(this.mark){
            case NOT_MARKED:    this.setIcon(flag);
                                this.setMark(Marks.MARKED_MINE);
                                theFrame.changeRemainingMines(theFrame.getRemainingMines()-1);
                                break;
            case MARKED_MINE:   this.setIcon(unknown);
                                this.setMark(Marks.MARKED_UNKNOWN);
                                break;
            case MARKED_UNKNOWN:this.setIcon(not);
                                this.setMark(Marks.NOT_MARKED);
                                theFrame.changeRemainingMines(theFrame.getRemainingMines()+1);
                                break;
        }
    }
    
    public void revealed(ImageIcon img, GraphicalGridView myFrame, int i, int j, int maxi, int maxj){
        if(this.mark == Marks.NOT_MARKED){
            if(this.getContent() == PossibleCell.MINE){
                this.setEnabled(false);
                this.setMasked(false);
                this.setIcon(img);
                JOptionPane.showMessageDialog(null, "You Looser", "WARNING !", JOptionPane.ERROR_MESSAGE); 
                NewGameFrame newg = new NewGameFrame();
                myFrame.setVisible(false);
            } else {
                switch(this.getNbNeighboors()){
                    case 0: unmaskNeighboors(myFrame.getPlate(), i, j, maxi, maxj);
                            this.setEnabled(false);
                            break;
                    case 1: this.setEnabled(false);
                            this.setText("1");
                            break;
                    case 2: this.setEnabled(false);
                            this.setText("2");
                            break;
                    case 3: this.setEnabled(false);
                            this.setText("3");
                            break;
                    case 4: this.setEnabled(false);
                            this.setText("4");
                            break;
                    case 5: this.setEnabled(false);
                            this.setText("5");
                            break;
                    case 6: this.setEnabled(false);
                            this.setText("6");
                            break;
                    case 7: this.setEnabled(false);
                            this.setText("7");
                            break;
                    case 8: this.setEnabled(false);
                            this.setText("8");
                            break;
                }
                this.setMasked(false);
                success(myFrame, myFrame.getPlate(), maxi, maxj);
            }
        }
    }
    
    public void success(GraphicalGridView myFrame, GraphicalCellView[][] plate, int maxi, int maxj){
        boolean successful = true;
        
        for(int i = 0 ; i < maxi ; i++){
            for(int j = 0 ; j < maxj ; j++){
                if(plate[i][j].isMasked() && plate[i][j].getContent() == PossibleCell.EMPTY){
                    successful = false;
                }
            }
        }
        
        if(successful){
            JOptionPane.showMessageDialog(null, "You Winner !", "Well Done", JOptionPane.INFORMATION_MESSAGE);
            NewGameFrame newg = new NewGameFrame();
            myFrame.setVisible(false);
        }
    }
    
    public void unmaskNeighboors(GraphicalCellView[][] plate, int i, int j, int maxi, int maxj){
        switch(plate[i][j].getNbNeighboors()){
            case 0: plate[i][j].setEnabled(false);
                    break;
            case 1: plate[i][j].setEnabled(false);
                    plate[i][j].setText("1");
                    break;
            case 2: plate[i][j].setEnabled(false);
                    plate[i][j].setText("2");
                    break;
            case 3: plate[i][j].setEnabled(false);
                    plate[i][j].setText("3");
                    break;
            case 4: plate[i][j].setEnabled(false);
                    plate[i][j].setText("4");
                    break;
            case 5: plate[i][j].setEnabled(false);
                    plate[i][j].setText("5");
                    break;
            case 6: plate[i][j].setEnabled(false);
                    plate[i][j].setText("6");
                    break;
            case 7: plate[i][j].setEnabled(false);
                    plate[i][j].setText("7");
                    break;
            case 8: plate[i][j].setEnabled(false);
                    plate[i][j].setText("8");
                    break;
        }
        plate[i][j].setMasked(false);
        if (plate[i][j].getNbNeighboors() == 0) {
            if (i - 1 >= 0) {

                //if (i - 1 >= 0) {
                if (plate[i - 1][j].getContent() != PossibleCell.MINE && plate[i - 1][j].isMasked() == true) {

                    unmaskNeighboors(plate, i - 1, j, maxi, maxj);
                }
                if (j - 1 >= 0) {
                    if (plate[i - 1][j - 1].getContent() != PossibleCell.MINE && plate[i - 1][j - 1].isMasked() == true) {
                        unmaskNeighboors(plate, i - 1, j - 1, maxi, maxj);
                    }
                }
                if (j + 1 <= maxj - 1) {
                    if (plate[i - 1][j + 1].getContent() != PossibleCell.MINE && plate[i - 1][j + 1].isMasked() == true) {
                        unmaskNeighboors(plate, i - 1, j + 1, maxi, maxj);
                    }
                }
                //}
            }
            if (i >= 0 && i <= maxi - 1) {
                if (j - 1 >= 0) {
                    if (plate[i][j - 1].getContent() != PossibleCell.MINE && plate[i][j - 1].isMasked() == true) {
                        unmaskNeighboors(plate, i, j - 1, maxi, maxj);
                    }
                }
                if (j + 1 <= maxj - 1) {
                    if (plate[i][j + 1].getContent() != PossibleCell.MINE && plate[i][j + 1].isMasked() == true) {
                        unmaskNeighboors(plate, i, j + 1, maxi, maxj);
                    }
                }
            }

            if (i + 1 <= maxi - 1) {
                if (plate[i + 1][j].getContent() != PossibleCell.MINE && plate[i + 1][j].isMasked() == true) {
                    unmaskNeighboors(plate, i + 1, j, maxi, maxj);
                }
                if (j - 1 >= 0) {
                    if (plate[i + 1][j - 1].getContent() != PossibleCell.MINE && plate[i + 1][j - 1].isMasked() == true) {
                        unmaskNeighboors(plate, i + 1, j - 1, maxi, maxj);
                    }
                }
                if (j + 1 <= maxj - 1) {
                    if (plate[i + 1][j + 1].getContent() != PossibleCell.MINE && plate[i + 1][j + 1].isMasked() == true) {
                        unmaskNeighboors(plate, i + 1, j + 1, maxi, maxj);
                    }
                }
            }
        }
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

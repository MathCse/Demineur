package model;

import controller.GraphicalCommandsView;
import controller.GraphicalGameView;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class GraphicalGridView extends JFrame {
    private GraphicalGridView myFrame;
    private final JMenuBar menu;
    private final JMenu gameMenu;
    private final JMenu menuNew;
    private final JMenuItem menuQuit;
    private final JMenuItem newBeginner;
    private final JMenuItem newIntermediate;
    private final JMenuItem newExpert;
    private final JMenuItem newCustom;
    
    private final GraphicalCellView[][] plate;
    private final int i;
    private final int j;
    private int remainingMines = 0;
    
    private final JPanel pan1 = new JPanel();
    private final JPanel pan2 = new JPanel();
    private final JPanel pan3 = new JPanel();
    
    private JLabel mineRemaining = new JLabel();
    
    public GraphicalGridView(int i, int j, int mines) {
        this.i = i;
        this.j = j;
        this.plate = new GraphicalCellView[i][j];
        int surface = this.i * this.j;
        int nbMines = mines;
        GraphicalCommandsView nbMinesMarked = new GraphicalCommandsView();
        int nb_marked_mines = nbMinesMarked.getNbMarkedMines();
        remainingMines = nbMines - nb_marked_mines;
        
        this.setTitle("Démineur");
        this.setSize(700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        menu = new JMenuBar();
        gameMenu = new JMenu("Game");
        menuNew = new JMenu("New");
        menuQuit = new JMenuItem("Quit");
        newBeginner = new JMenuItem("Beginner");
        newIntermediate = new JMenuItem("Intermediate");
        newExpert = new JMenuItem("Expert");
        newCustom = new JMenuItem("Custom");
        
        menuNew.add(newBeginner);
        menuNew.add(newIntermediate);
        menuNew.add(newExpert);
        menuNew.add(newCustom);
        
        gameMenu.add(menuNew);
        gameMenu.add(menuQuit);
        
        menu.add(gameMenu);
        
        this.setJMenuBar(menu);
        
        newBeginner.addActionListener(new ActionBeginner());
        newIntermediate.addActionListener(new ActionIntermediate());
        newExpert.addActionListener(new ActionExpert());
        newCustom.addActionListener(new ActionCustom());
        menuQuit.addActionListener(new ActionQuit());
        
        newBeginner.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_DOWN_MASK));
        newIntermediate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK));
        newExpert.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        newCustom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        
        gameMenu.setMnemonic('G');
        menuNew.setMnemonic('N');
        menuQuit.setMnemonic('Q');
        newBeginner.setMnemonic('B');
        newIntermediate.setMnemonic('I');
        newExpert.setMnemonic('E');
        newCustom.setMnemonic('C');
        
        setPlate(this.plate);
        setMines(nbMines);
        setNeighboors(this.plate);
        //printDebug();
        
        BorderLayout borderLayout = new BorderLayout(5, 5);
        GridLayout grid = new GridLayout(this.i, this.j, 3, 3);
        GridLayout text = new GridLayout(1, 1);
        
        pan2.setLayout(grid);
        pan1.setLayout(borderLayout);
        pan3.setLayout(text);
                
        pan1.add(pan2, BorderLayout.CENTER);
        pan1.add(pan3, BorderLayout.SOUTH);

        mineRemaining = new JLabel("Remaining mines : " + remainingMines);
        mineRemaining.setHorizontalAlignment(JLabel.CENTER);
        
        pan3.add(mineRemaining);

        System.out.println("Nouvelle grille graphique de démineur de " + this.getI() + " x " + this.getJ() + " avec " + nbMines + " mines.");
    }
    
    public void changeRemainingMines(int newmines){
        this.setRemainingMines(newmines);
        JPanel newpan = new JPanel();
        mineRemaining = new JLabel("Remaining mines : " + newmines);
        mineRemaining.setHorizontalAlignment(JLabel.CENTER);
        newpan.add(mineRemaining);
        pan1.remove(pan3);
        pan1.add(newpan, BorderLayout.SOUTH);
    }
    
    public int getRemainingMines() {
        return remainingMines;
    }

    public void setRemainingMines(int remainingMines) {
        this.remainingMines = remainingMines;
    }

    public JLabel getMineRemaining() {
        return mineRemaining;
    }

    public void setMineRemaining(JLabel mineRemaining) {
        this.mineRemaining = mineRemaining;
    }
    
    public void setPlate(GraphicalCellView[][] plate) {
        for(int x = 0; x < this.i; x++){
            for( int y = 0; y < this.j; y++){
                plate[x][y] = new GraphicalCellView(this, x, y, this.i, this.j);
            }
        }
    }
    
    public int getI() {
        return i;
    }
    
    public int getJ() {
        return j;
    }
    
    public void setMines(int mines){
        this.myFrame = this;
        int surface = this.i * this.j;
        int nbMines = mines;
        int tempx;
        int tempy;
        for(int it = 0 ; it < nbMines ; it++){
            do{
                tempx = 0 + (int)(Math.random() * this.i);
                tempy = 0 + (int)(Math.random() * this.j);
            } while (!this.plate[tempx][tempy].getContent().equals(PossibleCell.EMPTY));
            this.plate[tempx][tempy].setContent(PossibleCell.MINE);
        }
    }
    
    public void setNeighboors(GraphicalCellView[][] plate){
        for(int x = 0 ; x < this.i ; x++){
            for(int y = 0 ; y < this.j ; y++){
                if(x-1 >= 0){
                    if(plate[x-1][y].getContent().equals(PossibleCell.MINE)){
                        plate[x][y].setNbNeighboors(plate[x][y].getNbNeighboors()+1);
                    }
                    if(y-1 >= 0){
                        if(plate[x-1][y-1].getContent().equals(PossibleCell.MINE)){
                            plate[x][y].setNbNeighboors(plate[x][y].getNbNeighboors()+1);
                        }
                    }
                    if(y+1 <= this.j-1){
                        if(plate[x-1][y+1].getContent().equals(PossibleCell.MINE)){
                            plate[x][y].setNbNeighboors(plate[x][y].getNbNeighboors()+1);
                        }
                    }
                }
                if(y-1 >= 0){
                    if(plate[x][y-1].getContent().equals(PossibleCell.MINE)){
                        plate[x][y].setNbNeighboors(plate[x][y].getNbNeighboors()+1);
                    }
                }
                if(x+1 <= this.i-1){
                    if(plate[x+1][y].getContent().equals(PossibleCell.MINE)){
                        plate[x][y].setNbNeighboors(plate[x][y].getNbNeighboors()+1);
                    }
                    if(y-1 >= 0){
                        if(plate[x+1][y-1].getContent().equals(PossibleCell.MINE)){
                            plate[x][y].setNbNeighboors(plate[x][y].getNbNeighboors()+1);
                        }
                    }
                    if(y+1 <= this.j-1){
                        if(plate[x+1][y+1].getContent().equals(PossibleCell.MINE)){
                            plate[x][y].setNbNeighboors(plate[x][y].getNbNeighboors()+1);
                        }
                    }
                }
                if(y+1 <= this.j-1){
                    if(plate[x][y+1].getContent().equals(PossibleCell.MINE)){
                        plate[x][y].setNbNeighboors(plate[x][y].getNbNeighboors()+1);
                    }
                }
            }
        }
    }

    public GraphicalCellView[][] getPlate() {
        return plate;
    }
    
    public void printDebug() {        
        for(int x = 0; x < this.i; x++) {
            for( int y = 0; y < this.j; y++) {
                pan2.add(this.plate[x][y]);
            }
        }
        
        this.setContentPane(pan1);
        this.setVisible(true);
    }
    
    public void print(){
        for(int x = 0; x < this.i; x++) {
            for( int y = 0; y < this.j; y++) {
                pan2.add(this.plate[x][y]);
            }
        }
        
        this.setContentPane(pan1);
        this.setVisible(true);
    }
    
    class ActionBeginner implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            myFrame.setVisible(false);
            GraphicalGameView window = new GraphicalGameView(9, 9, 10);
        }
    }
    
    class ActionIntermediate implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            myFrame.setVisible(false);
            GraphicalGameView window = new GraphicalGameView(16, 16, 40);
        }
    }
    
    class ActionExpert implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            myFrame.setVisible(false);
            GraphicalGameView window = new GraphicalGameView(16, 30, 99);
        }
    }
    
    class ActionCustom implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            myFrame.setVisible(false);
            CustomGameFrame custom = new CustomGameFrame();
        }
    }
    
    class ActionQuit implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            System.exit(0);
        }
    }
}
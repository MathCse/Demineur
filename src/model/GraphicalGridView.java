package model;

import controller.GraphicalCommandsView;
import controller.GraphicalGameView;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
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
    private JFrame myFrame;
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
    private final JPanel empty1 = new JPanel();
    private final JPanel empty2 = new JPanel();
    
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
        
        BorderLayout borderLayout = new BorderLayout(5, 5);
        GridLayout grid = new GridLayout(this.i, this.j, 3, 3);
        GridLayout text = new GridLayout(1, 3);
        
        pan2.setLayout(grid);
        pan1.setLayout(borderLayout);
        pan3.setLayout(text);
                
        pan1.add(pan2, BorderLayout.CENTER);
        pan1.add(pan3, BorderLayout.SOUTH);

        mineRemaining = new JLabel("Remaining mines : " + remainingMines);
        
        pan3.add(empty1);
        pan3.add(mineRemaining);
        pan3.add(empty2);
        
<<<<<<< HEAD
        System.out.println("Nouvelle grille graphique de démineur de " + this.getI() + " x " + this.getJ() + " avec " + percent + " mines.");
=======
        System.out.println("Nouvelle grille graphique de démineur de " + this.getI() + " x " + this.getJ() + " avec " + nbMines + " mines.");
>>>>>>> b98269252fdc2e617e3c16214b736e6d014f25c6
    }
    
    public void setPlate(GraphicalCellView[][] plate) {
        for(int x = 0; x < this.i; x++){
            for( int y = 0; y < this.j; y++){
                plate[x][y] = new GraphicalCellView();
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
                if(this.plate[x][y].getContent() == PossibleCell.MINE){
                    pan2.add(new JButton("X"));
                } else {
                    if(this.plate[x][y].isMasked()){
                        pan2.add(new JButton(" "));
                    } else {
                        switch(this.plate[x][y].getNbNeighboors()){
                            case 0: this.getContentPane().add(new JButton("."));
                                    break;
                            case 1: this.getContentPane().add(new JButton("1"));
                                    break;
                            case 2: this.getContentPane().add(new JButton("2"));
                                    break;
                            case 3: this.getContentPane().add(new JButton("3"));
                                    break;
                            case 4: this.getContentPane().add(new JButton("4"));
                                    break;
                            case 5: this.getContentPane().add(new JButton("5"));
                                    break;
                            case 6: this.getContentPane().add(new JButton("6"));
                                    break;
                            case 7: this.getContentPane().add(new JButton("7"));
                                    break;
                            case 8: this.getContentPane().add(new JButton("8"));
                                    break;
                        }
                    }
                }
            }
        }
        
        this.setContentPane(pan1);
        this.setVisible(true);
    }
    
    public void print(){
       int nbCell = this.getI() * this.getJ();
       
       for(int i = 0; i < nbCell; i++) {
           pan2.add(new JButton(" "));
       }
       
       this.setContentPane(pan1);
        this.setVisible(true);
        
        /*for(int x = 0 ; x < this.i ; x++){
            for(int y = 0 ; y < this.j ; y++){
                if(this.plate[x][y].getMark() == Marks.MARKED_MINE){
                    System.out.print("! ");
                } else if(this.plate[x][y].getMark() == Marks.MARKED_UNKNOWN){
                    System.out.print("? ");
                } else {
                    if(this.plate[x][y].isMasked()){
                        System.out.print("# ");
                    } else {
                        if(this.plate[x][y].getContent() == PossibleCell.MINE){
                            System.out.print("X ");
                        } else {
                            switch(this.plate[x][y].getNbNeighboors()){
                                case 0: System.out.print(". ");
                                        break;
                                case 1: System.out.print("1 ");
                                        break;
                                case 2: System.out.print("2 ");
                                        break;
                                case 3: System.out.print("3 ");
                                        break;
                                case 4: System.out.print("4 ");
                                        break;
                                case 5: System.out.print("5 ");
                                        break;
                                case 6: System.out.print("6 ");
                                        break;
                                case 7: System.out.print("7 ");
                                        break;
                                case 8: System.out.print("8 ");
                                        break;
                            }
                        }
                    }
                }
            }
            System.out.println("");
        }*/
    }
    
    class ActionBeginner implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            myFrame.dispose();
            GraphicalGameView window = new GraphicalGameView(9, 9, 10);
        }
    }
    
    class ActionIntermediate implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            myFrame.dispose();
            GraphicalGameView window = new GraphicalGameView(16, 16, 40);
        }
    }
    
    class ActionExpert implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            myFrame.dispose();
            GraphicalGameView window = new GraphicalGameView(16, 30, 99);
        }
    }
    
    class ActionCustom implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            myFrame.dispose();
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
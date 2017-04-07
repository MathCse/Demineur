package controller;

import java.util.Scanner;
import model.*;

public class GraphicalGameView {
    //private final Init initialisation;
    private final GraphicalGridView grid;
    private final Scanner sc;
    private boolean quit = false;
    private final int lines;
    private final int rows;
    private final int mines;
    
    public GraphicalGameView(int newlines, int newrows, int newmines) {
        //this.initialisation = new Init();
        this.lines = newlines;
        this.rows = newrows;
        this.mines = newmines;
        this.grid = new GraphicalGridView(this.lines, this.rows, this.mines);
        sc = new Scanner(System.in);
        this.grid.print();
        //this.grid.printDebug();
    }
    
    public boolean isSuccessful(){
        boolean successful = true;
        
        for(int i = 0 ; i < this.lines ; i++){
            for(int j = 0 ; j < this.rows ; j++){
                if(this.grid.getPlate()[i][j].isMasked() && this.grid.getPlate()[i][j].getContent() == PossibleCell.EMPTY){
                    successful = false;
                }
            }
        }
        
        if(successful){
            System.out.println("Bravo ! C'est gagné !");
        }
        
        return successful;
    }
    
    public boolean isLost(){
        boolean lost  = false;
        
        for(int i = 0 ; i < this.lines ; i++){
            for(int j = 0 ; j < this.rows ; j++){
                if(!this.grid.getPlate()[i][j].isMasked() && this.grid.getPlate()[i][j].getContent() == PossibleCell.MINE){
                    lost = true;
                }
            }
        }
        
        if(lost){
            System.out.println("PERDU");
        }
        
        return lost;
    }
    
    public boolean isQuit() {
        return quit;
    }

    public void setQuit(boolean quit) {
        this.quit = quit;
    }

    public GraphicalGridView getGrid() {
        return grid;
    }
    
    public void GraphicalRoundView() {
        System.out.println("Enter an action :");
        String str = sc.nextLine();
        String[] parts = str.split(" ");
        char part1 = parts[0].charAt(0);
        int part2 = 0;
        int part3 = 0;
        char part4 = ' ';
        if (parts.length > 1) {
            part2 = Integer.parseInt(parts[1]);
            part3 = Integer.parseInt(parts[2]);
        }
        
        if (parts.length > 3) {
            part4 = parts[3].charAt(0);
        }

        GraphicalCommandsView command = new GraphicalCommandsView(part1, part3, part2, part4);
        command.DoAction(this);
        //grid.print();
        grid.printDebug();
    }
}

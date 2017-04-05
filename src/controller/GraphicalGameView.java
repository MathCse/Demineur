package controller;

import java.util.Scanner;
import model.*;

public class GraphicalGameView {
    private final Init initialisation;
    private final GraphicalGridView grid;
    private final Scanner sc;
    private boolean quit = false;
    
    public GraphicalGameView() {
        this.initialisation = new Init();
        this.grid = new GraphicalGridView(initialisation.getLine(), initialisation.getRow(), initialisation.getPercent());
        sc = new Scanner(System.in);
        //this.grid.print();
        this.grid.printDebug();
    }
    
    public boolean isSuccessful(){
        boolean successful = true;
        
        for(int i = 0 ; i < this.initialisation.getLine() ; i++){
            for(int j = 0 ; j < this.initialisation.getRow() ; j++){
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
        
        for(int i = 0 ; i < this.initialisation.getLine() ; i++){
            for(int j = 0 ; j < this.initialisation.getRow() ; j++){
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

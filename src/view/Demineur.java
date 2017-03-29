package view;

import controller.Game;
import controller.GraphicalGameView;


public class Demineur {

    public static void main(String[] args) {
        //Game newGame = new Game();
        GraphicalGameView newGame = new GraphicalGameView();

            
        do{
            newGame.GraphicalRoundView();
        } while (!newGame.isLost() && !newGame.isSuccessful() && !newGame.isQuit());
    }
    
}
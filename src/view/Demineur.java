package view;

import controller.Game;


public class Demineur {

    public static void main(String[] args) {
        Game newGame = new Game();
        
            
        do{
            newGame.round();
        } while (!newGame.isLost() && !newGame.isSuccessful() || newGame.isQuit());
    }
    
}
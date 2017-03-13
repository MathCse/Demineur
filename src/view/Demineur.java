package view;

import controller.Game;


public class Demineur {

    public static void main(String[] args) {
        Game newGame = new Game();
        
<<<<<<< HEAD
        //grid.printInit();
        //grid.printDebug();
        
        
=======
        do{
            newGame.round();
        } while (!newGame.isLost() || !newGame.isSuccessful() || newGame.isQuit());
>>>>>>> 34bcbf1b776ff2ca035cbc1ea6491d91a86b00b9
    }
    
}
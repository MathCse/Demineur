package view;

import controller.Game;
import model.Grid;
import java.util.Observable;
import java.util.Observer;

import controller.GraphicalGameView;


public class Demineur {

    public static void main(String[] args) {
<<<<<<< HEAD
        GraphicalGameView newGame = new GraphicalGameView();
            
        do{
            newGame.GraphicalRoundView();
=======
        Game newGame = new Game();

        do {

       
            newGame.round();
>>>>>>> 00abca1a00a68c48b07c0f49b78ed3285ca8e0a3
        } while (!newGame.isLost() && !newGame.isSuccessful() && !newGame.isQuit());
    }
 

}

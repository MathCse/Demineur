package view;

import controller.Game;
import model.Grid;
import java.util.Observable;
import java.util.Observer;

import controller.GraphicalGameView;


public class Demineur {

    public static void main(String[] args) {
        GraphicalGameView newGame = new GraphicalGameView();
            
        do{
            newGame.GraphicalRoundView();
        } while (!newGame.isLost() && !newGame.isSuccessful() && !newGame.isQuit());
    }



}

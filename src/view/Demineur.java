package view;

import controller.Game;
import model.*;
import java.util.Observable;
import java.util.Observer;

import controller.GraphicalGameView;


public class Demineur {

    public static void main(String[] args) {
        NewGameFrame newGameGraphics = new NewGameFrame();
        
        Game newGame = new Game();
            
        do{
            newGame.round();
        } while (!newGame.isLost() && !newGame.isSuccessful() && !newGame.isQuit());
    }



}

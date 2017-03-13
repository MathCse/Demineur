/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Game;

/**
 *
 * @author pa
 */
public class Demineur {

    public static void main(String[] args) {
        Game newGame = new Game();
        
        do{
            newGame.round();
        } while (!newGame.isLost() || !newGame.isSuccessful());
    }
    
}
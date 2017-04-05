/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JFrame;

/**
 *
 * @author pa
 */
public class NewGameFrame extends JFrame{
    public NewGameFrame() {
        this.setTitle("NewGameFrame");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        NewGamePanel pan = new NewGamePanel(this);
        
        this.setContentPane(pan);
        this.setVisible(true);
        
    }
    
    public void disposer(){
        this.dispose();
    }
}

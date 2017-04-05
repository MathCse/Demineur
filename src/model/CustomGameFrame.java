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
public class CustomGameFrame extends JFrame{
    public CustomGameFrame() {
        this.setTitle("CustomGameFrame");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        
        CustomGamePanel pan = new CustomGamePanel(this);
        
        this.setContentPane(pan);
        this.setVisible(true);
    }
}

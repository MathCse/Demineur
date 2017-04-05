package model;

import javax.swing.JFrame;

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

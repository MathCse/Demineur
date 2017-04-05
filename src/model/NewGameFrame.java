package model;

import javax.swing.JFrame;

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

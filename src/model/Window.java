package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;

public class Window extends JFrame{
    private final JFrame window;
    private final JMenuBar menu;
    private final JMenu gameMenu;
    private final JMenu menuNew;
    private final JMenuItem menuQuit;
    private final JMenuItem newBeginner;
    private final JMenuItem newIntermediate;
    private final JMenuItem newExpert;
    private final JMenuItem newCustom;
    
    public Window(){
        window = new JFrame();
        window.setTitle("Démineur");
        window.setSize(400, 400);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        
        menu = new JMenuBar();
        gameMenu = new JMenu("Game");
        menuNew = new JMenu("New");
        menuQuit = new JMenuItem("Quit");
        newBeginner = new JMenuItem("Beginner");
        newIntermediate = new JMenuItem("Intermediate");
        newExpert = new JMenuItem("Expert");
        newCustom = new JMenuItem("Custom");
        
        menuNew.add(newBeginner);
        menuNew.add(newIntermediate);
        menuNew.add(newExpert);
        menuNew.add(newCustom);
        
        gameMenu.add(menuNew);
        gameMenu.add(menuQuit);
        
        menu.add(gameMenu);
        
        window.setJMenuBar(menu);
        
        menuNew.addActionListener(new ActionNew());
        newBeginner.addActionListener(new ActionBeginner());
        newIntermediate.addActionListener(new ActionIntermediate());
        newExpert.addActionListener(new ActionExpert());
        newCustom.addActionListener(new ActionCustom());
        menuQuit.addActionListener(new ActionQuit());
        
        newBeginner.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_DOWN_MASK));
        newIntermediate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK));
        newExpert.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        newCustom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        
        gameMenu.setMnemonic('G');
        menuNew.setMnemonic('N');
        menuQuit.setMnemonic('Q');
        newBeginner.setMnemonic('B');
        newIntermediate.setMnemonic('I');
        newExpert.setMnemonic('E');
        newCustom.setMnemonic('C');
    }
    
    class ActionNew implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            NewGameFrame custom = new NewGameFrame();
        }
    }
    
    class ActionBeginner implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            System.out.println("Game(9, 9, 10)");
        }
    }
    
    class ActionIntermediate implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            System.out.println("Game(16, 16, 40)");
        }
    }
    
    class ActionExpert implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            System.out.println("Game(16, 30, 99)");
        }
    }
    
    class ActionCustom implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            CustomGameFrame custom = new CustomGameFrame();
            //NewGameFrame newg = new NewGameFrame();
        }
    }
    
    class ActionQuit implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            System.exit(0);
        }
    }
    
}
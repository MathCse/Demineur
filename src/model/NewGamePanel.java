package model;

import controller.GraphicalGameView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGamePanel extends JPanel{
    private int rows;
    private int columns;
    private int mines;
    private final JPanel pan0 = new JPanel();
    private final JPanel pan1 = new JPanel();
    private final JPanel pan2 = new JPanel();
    private final JPanel pan3 = new JPanel();
    private final JButton but = new JButton("Start");
    private final ButtonGroup custombg = new ButtonGroup();
    
    public NewGamePanel(NewGameFrame myFrame){
        this.rows = 9;
        this.columns = 19;
        this.mines = 76;
        
        this.setLayout(new BorderLayout(5, 5));
        
        pan0.setLayout(new GridLayout(5, 1));
        pan1.setLayout(new GridLayout(3, 1));
        pan2.setLayout(new GridLayout(3, 1));
        pan3.setLayout(new GridLayout(3, 1));
        
        JLabel lab0 = new JLabel("Select a level :");
        JRadioButton but1 = new JRadioButton("Beginner: 10 mines in a 9 x 9 field");
        JRadioButton but2 = new JRadioButton("Intermediate: 40 mines in a 16 x 16 field");
        JRadioButton but3 = new JRadioButton("Expert: 99 mines in a 16 x 30 field");
        JRadioButton but4 = new JRadioButton("Custom:", true);
        
        custombg.add(but1);
        custombg.add(but2);
        custombg.add(but3);
        custombg.add(but4);
        
        JPanel pan31 = new JPanel();
        pan31.setLayout(new GridLayout(3, 1));
        JPanel pan32 = new JPanel();
        pan32.setLayout(new GridLayout(3, 1));
        JPanel pan33 = new JPanel();
        pan33.setLayout(new GridLayout(3, 1));
        
        JLabel lab1 = new JLabel("Rows");
        JLabel lab2 = new JLabel("Columns");
        JLabel lab3 = new JLabel("Mines");
        
        JSlider slide1 = new JSlider();
        slide1.setMaximum(24);
        slide1.setMinimum(9);
        slide1.setValue(this.rows);
        slide1.setPaintLabels(true);
        slide1.setPaintTicks(true);
        slide1.setPaintTrack(true);
        slide1.setMinorTickSpacing(1);
        slide1.setMajorTickSpacing(2);
        
        JSlider slide2 = new JSlider();
        slide2.setMaximum(30);
        slide2.setMinimum(9);
        slide2.setValue(this.columns);
        slide2.setPaintLabels(true);
        slide2.setPaintTicks(true);
        slide2.setPaintTrack(true);
        slide2.setMinorTickSpacing(2);
        slide2.setMajorTickSpacing(4);
        
        JSlider slide3 = new JSlider();
        slide3.setMaximum((int)(0.85 * rows * columns));
        slide3.setMinimum(9);
        slide3.setValue(this.mines);
        slide3.setPaintLabels(true);
        slide3.setPaintTicks(true);
        slide3.setPaintTrack(true);
        slide3.setMinorTickSpacing(13);
        slide3.setMajorTickSpacing(26);
        
        JPanel pan01 = new JPanel();
        JPanel pan02 = new JPanel();
        JPanel pan03 = new JPanel();
        JTextField txt1 = new JTextField("" + slide1.getValue());
        txt1.setPreferredSize(new Dimension(60, 1));
        JTextField txt2 = new JTextField("" + slide2.getValue());
        txt2.setPreferredSize(new Dimension(60, 1));
        JTextField txt3 = new JTextField("" + slide3.getValue());
        txt3.setPreferredSize(new Dimension(60, 1));
        
        slide1.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent event){
                txt1.setText(String.valueOf(slide1.getValue()));
                slide3.setMaximum((int)(0.85*slide1.getValue()*slide2.getValue()));
                slide3.setMinorTickSpacing((int)(slide3.getMaximum()/10));
                slide3.setMajorTickSpacing(slide3.getMinorTickSpacing()*2);
                slide3.setLabelTable(slide3.createStandardLabels(slide3.getMajorTickSpacing()));
            }
        }); 
        txt1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String typed = txt1.getText();
                slide1.setValue(0);
                if(!typed.matches("\\d+") || typed.length() > 3) {
                    return;
                }
                int value = Integer.parseInt(typed);
                if(value >= slide1.getMinimum()){
                    slide1.setValue(value);
                } else {
                    txt1.setText(String.valueOf(slide1.getMinimum()));
                }
                slide3.setMaximum((int)(0.85*slide1.getValue()*slide2.getValue()));
                slide3.setMinorTickSpacing((int)(slide3.getMaximum()/10));
                slide3.setMajorTickSpacing(slide3.getMinorTickSpacing()*2);
                slide3.setLabelTable(slide3.createStandardLabels(slide3.getMajorTickSpacing()));
            }
        });
        
        slide2.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent event){
                txt2.setText("" + slide2.getValue());
                slide3.setMaximum((int)(0.85*slide1.getValue()*slide2.getValue()));
                slide3.setMinorTickSpacing((int)(slide3.getMaximum()/10));
                slide3.setMajorTickSpacing(slide3.getMinorTickSpacing()*2);
                slide3.setLabelTable(slide3.createStandardLabels(slide3.getMajorTickSpacing()));
            }
        });
        txt2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String typed = txt2.getText();
                slide2.setValue(0);
                if(!typed.matches("\\d+") || typed.length() > 3) {
                    return;
                }
                int value = Integer.parseInt(typed);
                if(value >= slide2.getMinimum()){
                    slide2.setValue(value);
                } else {
                    txt2.setText(String.valueOf(slide2.getMinimum()));
                }
                slide3.setMaximum((int)(0.85*slide1.getValue()*slide2.getValue()));
                slide3.setMinorTickSpacing((int)(slide3.getMaximum()/10));
                slide3.setMajorTickSpacing(slide3.getMinorTickSpacing()*2);
                slide3.setLabelTable(slide3.createStandardLabels(slide3.getMajorTickSpacing()));
            }
        });
        
        slide3.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent event){
                txt3.setText("" + slide3.getValue());
            }
        });
        txt3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String typed = txt3.getText();
                slide3.setValue(0);
                if(!typed.matches("\\d+") || typed.length() > 3) {
                    return;
                }
                int value = Integer.parseInt(typed);
                if(value >= slide3.getMinimum()){
                    slide3.setValue(value);
                } else {
                    txt3.setText(String.valueOf(slide3.getMinimum()));
                }
            }
        });
        
        but.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(but1.isSelected()){
                    GraphicalGameView window = new GraphicalGameView(9, 9, 10);
                } else if(but2.isSelected()){
                    GraphicalGameView window = new GraphicalGameView(16, 16, 40);
                } else if(but3.isSelected()){
                    GraphicalGameView window = new GraphicalGameView(16, 30, 99);
                } else if(but4.isSelected()){
                    GraphicalGameView window = new GraphicalGameView(slide1.getValue(), slide2.getValue(), slide3.getValue());
                }
                myFrame.dispose();
            }
        });
        
        pan31.add(pan01);
        pan31.add(txt1);
        pan32.add(pan02);
        pan32.add(txt2);
        pan33.add(pan03);
        pan33.add(txt3);
        
        pan0.add(lab0);
        pan0.add(but1);
        pan0.add(but2);
        pan0.add(but3);
        pan0.add(but4);
        pan1.add(lab1);
        pan1.add(lab2);
        pan1.add(lab3);
        pan2.add(slide1);
        pan2.add(slide2);
        pan2.add(slide3);
        pan3.add(pan31);
        pan3.add(pan32);
        pan3.add(pan33);
        
        this.add(pan0, BorderLayout.NORTH);
        this.add(pan1, BorderLayout.WEST);
        this.add(pan2, BorderLayout.CENTER);
        this.add(pan3, BorderLayout.EAST);
        this.add(but, BorderLayout.SOUTH);
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getMines() {
        return mines;
    }

    public void setMines(int mines) {
        this.mines = mines;
    }
}

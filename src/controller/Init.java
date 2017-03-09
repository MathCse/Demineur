package controller;

import java.util.Scanner;

public class Init {
    
    private int row;
    private int line;
    private int percent;
    
    public Init() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of row : ");
        try {
            if(row > 0) {
                row = sc.nextInt();
                setRow(row);
            }
            else {
                throw new Exception("row must be > 0");
            }
        }
        catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}

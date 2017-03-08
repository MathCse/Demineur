/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.lang.System;
import java.util.Scanner;

import model.Grid;

/**
 *
 * @author pa
 */
public class Demineur {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row;
        int line;
        int per;
        
        System.out.println("Veuillez saisir le nombre de colonnes:");
        row = sc.nextInt();
        if(row < 0){
            do{
                System.out.println("Le nombre doit être positif ! Veuillez saisir le nombre de rowonnes:");
                row = sc.nextInt();
            } while(row < 0);
        }
        
        System.out.println("Veuillez saisir le nombre de lignes:");
        line = sc.nextInt();
        if(line < 0){
            do{
                System.out.println("Le nombre doit être positif ! Veuillez saisir le nombre de lignes:");
                line = sc.nextInt();
            } while(line < 0);
        }
        
        System.out.println("Veuillez saisir le pourcentage de mines sur la grille:");
        per = sc.nextInt();
        if(per < 0 || per > 100){
            do{
                System.out.println("Le nombre doit être entre 0 et 100 ! Veuillez saisir le pourcentage de mines sur la grille:");
                per = sc.nextInt();
            } while(per < 0 || per > 100);
        }
        
        Grid grid = new Grid(line, row, per);
        
        grid.print();
    }
    
}

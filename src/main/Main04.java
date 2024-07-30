package main;

import java.util.Scanner;

import entities.Robo;
import entities.RoboInteligente;

public class Main04 {

	public static void main(String[] args) {
		Robo rNSebo = new Robo("branco");
        Robo rEuSabo = new RoboInteligente("preto");
        Scanner sc = new Scanner(System.in);
        char[][] mat = new char[4][4];
        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                mat[i][j] = '-';
            }
        }
        printarMatriz(mat);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.nextLine();
        mat[x-1][y-1] = 'F';
        int[] food = {x, y};
        printarMatriz(mat);
        
        
	}
	
	private static void printarMatriz(char[][] mat){
        for(int i = 0; i<4; i++){
            System.out.print("[");
            for(int j = 0; j<4; j++){
                System.out.print(" " + mat[i][j] + " ");
            }
            System.out.print("]\n");
        }
    }

}

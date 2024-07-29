package main;

import entities.Robo;
import entities.Robo02;
import entities.RoboInteligente;
import exception.MovimentoInvalidoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.Scanner;

public class Main03 {
    public static void main(String[] args){
        Robo rNSebo = new Robo02("branco");
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
        moveLoop(rNSebo, rEuSabo, food, mat);
        sc.close();
    }

    public static void printarMatriz(char[][] mat){
        for(int i = 0; i<4; i++){
            System.out.print("[");
            for(int j = 0; j<4; j++){
                System.out.print(" " + mat[i][j] + " ");
            }
            System.out.print("]\n");
        }
    }

    public static void moveLoop(Robo r1, Robo r2, int[] food, char[][] mat){
        int move = 0, mv1 = 0, mv2 = 0, v1 = 0, v2 = 0, v = 1, i= 0;
        Random rd = new Random();
        List<Integer> BlackList = new ArrayList<>();
        while(v1 == 0 || v2 == 0){
            try{
                if(v1 != 0){
                    v = 2;
                }
                else if(v2 != 0){
                    v = 1;
                }
                if(v1 == 0 && v == 1){
                    System.out.printf("Vez do robo %s\n", r1.getColor());
                    mat[r1.getCoord()[0]][r1.getCoord()[1]] = 'B';
                    printarMatriz(mat);
                    mat[r1.getCoord()[0]][r1.getCoord()[1]] = '-';
                    move = rd.nextInt(4);
                    ((Robo02) r1).Mover2(move + 1);
                    mat[r1.getCoord()[0]][r1.getCoord()[1]] = 'B';
                    mv1++;
                    if(r1.isFoodFound(food)) {
                        System.out.println(12345);
                        v1++;
                        if(v2 == 1){
                            System.out.printf("Número de movimentos do robo %s: %d\n", r1.getColor(), mv1);
                            System.out.printf("Número de movimentos do robo %s: %d\n", r2.getColor(), mv2);
                        }
                    }
                    if(v1 == 0 && v2 == 0){
                        v++;
                    }
                }
                if(v2 == 0 && v == 2){
                    System.out.printf("Vez do robo %s\n", r2.getColor());
                    mat[r2.getCoord()[0]][r2.getCoord()[1]] = 'P';
                    printarMatriz(mat);
                    mat[r2.getCoord()[0]][r2.getCoord()[1]] = '-';
                    if(i == 0){
                        i++;
                        move = rd.nextInt(4);
                    }
                    while(BlackList.contains(move)){
                        move = rd.nextInt(4);
                    }
                    r2.Mover(move + 1);
                    BlackList.clear();
                    i = 0;
                    mat[r2.getCoord()[0]][r2.getCoord()[1]] = 'P';
                    mv2++;
                    if(r2.isFoodFound(food)) {
                        System.out.println(12345);
                        v2++;
                        if(v1 == 1){
                            System.out.printf("Número de movimentos do robo %s: %d\n", r1.getColor(), mv1);
                            System.out.printf("Número de movimentos do robo %s: %d\n", r2.getColor(), mv2);
                        }
                    }
                    if(v1 == 0 && v2 == 0){
                        v--;
                    }
                }
         
            }
            catch(MovimentoInvalidoException mie){
                System.out.println(mie.getMessage());
                if(v == 1){
                    mv1++;
                }
                else{
                    BlackList.add(move);
                    mv2++;
                }
            } 
        }
    }
}

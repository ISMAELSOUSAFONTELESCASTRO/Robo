package main;

import entities.Robo;
import exception.MovimentoInvalidoException;

import java.util.Random;

import java.util.Scanner;
public class Main02 {
    public static void main(String[] args){
        Robo robo01 = new Robo("branco");
        Robo robo02 = new Robo("preto");
        Scanner teclado = new Scanner(System.in);
        int[] food = new int[2];
		food[0] = teclado.nextInt();
		food[1] = teclado.nextInt();
		teclado.nextLine();
        int z = 0, mv1 = 0, mi1 = 0, mv2 = 0, mi2 = 0, v  = 1;
        MoveLoop(robo01, robo02, food, z, mv1, mi1, mv2, mi2, v);
        teclado.close();
    }

    public static void MoveLoop(Robo r1, Robo r2, int[] food, int z, int mv1, int mi1, int mv2, int mi2, int v){
        int move;
        Random rd = new Random();
        while(z == 0){
            try{
                if(v == 1){
                    System.out.printf("Vez do robo %s\n", r1.getColor());
                    System.out.printf("(%d,%d)\n", r1.getCoord()[0], r1.getCoord()[1]);
                    move = rd.nextInt(4);
                    r1.Mover(Integer.toString(move + 1));
                    mv1++;
                    if(r1.isFoodFound(food)) {
                        System.out.printf("(%d,%d)", r1.getCoord()[0], r1.getCoord()[1]);
                        System.out.printf("O robo %s achou primeiro a comida primerio!\n", r1.getColor());
                        System.out.printf("Número de movimentos inválidos do robo %s: %d\n", r1.getColor(), mi1);
                        System.out.printf("Número de movimentos válidos do robo %s: %d\n", r1.getColor(), mv1);
                        System.out.printf("Número de movimentos inválidos do robo %s: %d\n", r2.getColor(), mi2);
                        System.out.printf("Número de movimentos válidos do robo %s: %d\n", r2.getColor(), mv2);
                        z++;
                    }
                    v++;
                }
                if(z == 0 && v == 2){
                    System.out.printf("Vez do robo %s\n", r2.getColor());
                    System.out.printf("(%d,%d)\n", r2.getCoord()[0], r2.getCoord()[1]);
                    move = rd.nextInt(4);
                    r2.Mover(Integer.toString(move + 1));
                    mv2++;
                    if(r2.isFoodFound(food)) {
        	            System.out.printf("(%d,%d)", r2.getCoord()[0], r2.getCoord()[1]);
        	            System.out.printf("O robo %s achou primeiro a comida primerio!\n", r2.getColor());
                        System.out.printf("Número de movimentos inválidos do robo %s: %d\n", r1.getColor(), mi1);
                        System.out.printf("Número de movimentos válidos do robo %s: %d\n", r1.getColor(), mv1);
                        System.out.printf("Número de movimentos inválidos do robo %s: %d\n", r2.getColor(), mi2);
                        System.out.printf("Número de movimentos válidos do robo %s: %d\n", r2.getColor(), mv2);
                        z++;
                    }
                    v--;
                }
            }
            catch(MovimentoInvalidoException mie){
                System.out.println(mie.getMessage());
                if(v == 1){
                    mi1++;
                }
                else{
                    mi2++;
                }
            }
            
        }
    }
}

package main;

import entities.Robo;
import exception.MovimentoInvalidoException;

import java.util.Scanner;
public class Main01 {
/**Só fechei os scanners */
	public static void main(String[] args) {
		Robo robo = new Robo("branco");
		Scanner teclado = new Scanner(System.in);
		int[] food = new int[2];
		food[0] = teclado.nextInt();
		food[1] = teclado.nextInt();
		teclado.nextLine();
		MoveLoop(robo, food);
        teclado.close();

	}
	
	private static void MoveLoop(Robo robo, int[] food) {
		String move;
		Scanner scn = new Scanner(System.in);
		System.out.printf("(%d,%d)", robo.getCoord()[0], robo.getCoord()[1]);
		try {
			move = scn.nextLine();
            /**Esses if e elif é para caso o usuário digitar um número em vez de String */
            if(move.charAt(0) == '1'){
                robo.Mover("1");
            }
            else if(move.charAt(0) == '2'){
                robo.Mover("2");
            }
            else if(move.charAt(0) == '3'){
                robo.Mover("2");
            }
            else if(move.charAt(0) == '4'){
                robo.Mover("4");
            }
            else{
                robo.Mover(move);
            }
			if(!robo.isFoodFound(food)) {
				MoveLoop(robo, food);
			}
			else {
				System.out.printf("(%d,%d)", robo.getCoord()[0], robo.getCoord()[1]);
				System.out.println("comeu!");
			}
		}
		catch(MovimentoInvalidoException mie) {
			System.out.println(mie.getMessage());
			MoveLoop(robo, food);
		}
		scn.close();
	}

}

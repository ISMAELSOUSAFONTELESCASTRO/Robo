package entities;

import exception.MovimentoInvalidoException;

public class RoboInteligente extends Robo{
    public RoboInteligente(String color){
        super(color);
    }

    @Override
    public void Mover(int mov) throws MovimentoInvalidoException{
		if(mov == 1) {
			if(coord[0] > 0 && coord[0] <= 3) {
				coord[0] -= 1;
			}
			else {
				throw new MovimentoInvalidoException("up");
			}
		}
		else if(mov == 2) {
			if(coord[0] >= 0 && coord[0] < 3) {
				coord[0] += 1;
			}
			else {
				throw new MovimentoInvalidoException("down");
			}
		}
		else if(mov == 3) {
			if(coord[1] >= 0 && coord[1] < 3) {
				coord[1] += 1;
			}
			else {
				throw new MovimentoInvalidoException("right");
			}
		}
		else{
			if(coord[1] > 0 && coord[1] <= 3) {
				coord[1] -= 1;
			}
			else {
				throw new MovimentoInvalidoException("left");
			}
		}
	}

    @Override
    public boolean isFoodFound(int[] food){
        if(coord[0] == food[1] - 1 && coord[1] == food[0] - 1) {
			return true;
		}
		else {
			return false;
		}
    }
}

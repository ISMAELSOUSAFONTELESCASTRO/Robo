package entities;

import exception.MovimentoInvalidoException;

public class Robo02 extends Robo{
    public Robo02(String color){
        super(color);
    }
	@Override
    public void Mover(int mov) throws MovimentoInvalidoException{
		if(mov == 1) {
			if(coord[1] >= 0 && coord[1] < 10) {
				coord[1] += 1;
			}
			else {
				throw new MovimentoInvalidoException("up");
			}
		}
		else if(mov == 2) {
			if(coord[1] > 0 && coord[1] <= 10) {
				coord[1] -= 1;
			}
			else {
				throw new MovimentoInvalidoException("down");
			}
		}
		else if(mov == 3) {
			if(coord[0] >= 0 && coord[0] < 10) {
				coord[0] += 1;
			}
			else {
				throw new MovimentoInvalidoException("right");
			}
		}
		else{
			if(coord[0] > 0 && coord[1] <= 10) {
				coord[0] -= 1;
			}
			else {
				throw new MovimentoInvalidoException("left");
			}
		}
	}
}
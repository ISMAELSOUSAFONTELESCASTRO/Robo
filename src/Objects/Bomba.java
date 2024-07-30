package Objects;
import entities.*;

public class Bomba extends Obstaculo{
	 public boolean isAtiva;
	
	public Bomba(int [] coord) {
		isAtiva = true;
		this.coord = coord;
	}
	
	public void bater(Robo r) {
		if(r.getCoord() == coord) {
			r.isAlive = false;
			isAtiva = false;
		}
	}
	
}

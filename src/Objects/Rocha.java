package Objects;

import entities.Robo;
import exception.*;

public class Rocha extends Obstaculo {
	
	public Rocha(int[] Coord) {
		this.coord = Coord;
	}
	
	@Override
	public void bater(Robo r) {
		/* *
		 	essa função só vai ser chamada quando ele de fato bater...	 
		/* */
			if(r.getCoord() == coord) {
				r.setCoord(r.precoord);
			}
		
	}

}

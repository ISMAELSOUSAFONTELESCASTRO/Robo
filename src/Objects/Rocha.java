package objects;
import entities.Robo;
import exception.*;
import visual.*;

import java.util.Arrays;

public class Rocha extends Obstaculo {

    public Rocha(int[] Coord) {
        this.coord = Coord;
    }

    @Override
    public void bater(Robo r, int i) {
		// essa função só vai ser chamada quando ele de fato bater
        if(Arrays.equals(r.getCoord(), coord)) {
            Visual.removerRobo(r.getCoord(0), r.getCoord(1), r.getColor());
            r.setCoord(r.precoord);
            Visual.addRobo(r.getCoord(0), r.getCoord(1), r.getColor());
            Visual.bateuPedra(r.getColor());
        }
    }
}

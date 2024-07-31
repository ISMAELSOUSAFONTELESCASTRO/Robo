package Objects;
import entities.*;
import visual.Visual;

import java.util.Arrays;

public class Bomba extends Obstaculo{
    public boolean isAtiva;

    public Bomba(int [] coord) {
        isAtiva = true;
        this.coord = coord;
    }

    public void bater(Robo r, int i) {
        if(isAtiva){
            if(Arrays.equals(r.getCoord(), coord)) {
                Visual.removerRobo(r.getCoord(0), r.getCoord(1), r.getColor());
                r.isAlive = false;
                isAtiva = false;
                Visual.removerBomba(coord[0], coord[1], i);
                coord = null;
                Visual.morreu(r.getColor());
            }
        }
    }
}

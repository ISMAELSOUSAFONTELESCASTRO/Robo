package entities;

import visual.*;
import exception.MovimentoInvalidoException;

public class Robo {

    public boolean isAlive;

    protected String color;
    protected int [] coord = new int[2];
    public int [] precoord = new int[2];
    protected int miRobo=0, mvRobo=0;

    public Robo(String color) {
        isAlive = true;
        setColor(color);
        int[] inicio = {0,0};
        setCoord(inicio);
        Visual.addRobo(0,0, color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCoord(int i){
        if(i == 0){
            return coord[0];
        } else {
            return coord[1];
        }
    }

    public int[] getCoord() {
        return coord;
    }

    public void setCoord(int[] coord) {
        this.coord = coord;
    }

    public int getMiRobo() {
        return miRobo;
    }

    public int getMvRobo() {
        return mvRobo;
    }

    public void Mover(String mov) throws MovimentoInvalidoException{
        precoord = coord;
        if(mov.equals("up") || mov.equals("1")) {
            if(isAlive) {
                if (coord[0] > 0 && coord[0] < 3) {
                    Visual.removerRobo(coord[0], coord[1], color);
                    coord[0] -= 1;
                    Visual.addRobo(coord[0], coord[1], color);
                    mvRobo++;
                } else {
                    miRobo++;
                    throw new MovimentoInvalidoException("up");
                }
            }
        }
        else if(mov.equals("down") || mov.equals("2")) {
            if(isAlive) {
                if (coord[0] >= 0 && coord[0] < 2) {
                    Visual.removerRobo(coord[0], coord[1], color);
                    coord[0] += 1;
                    Visual.addRobo(coord[0], coord[1], color);
                    mvRobo++;
                } else {
                    miRobo++;
                    throw new MovimentoInvalidoException("down");
                }
            }
        }
        else if(mov.equals("right") || mov.equals("3")) {
            if(isAlive) {
                if (coord[1] >= 0 && coord[1] < 2) {
                    Visual.removerRobo(coord[0], coord[1], color);
                    coord[1] += 1;
                    Visual.addRobo(coord[0], coord[1], color);
                    mvRobo++;
                } else {
                    miRobo++;
                    throw new MovimentoInvalidoException("right");
                }
            }
        }
        else if(mov.equals("left") || mov.equals("4")) {
            if(isAlive) {
                if (coord[1] > 0 && coord[1] < 3) {
                    Visual.removerRobo(coord[0], coord[1], color);
                    coord[1] -= 1;
                    Visual.addRobo(coord[0], coord[1], color);
                    mvRobo++;
                } else {
                    miRobo++;
                    throw new MovimentoInvalidoException("left");
                }
            }
        }
        else{//Para quando o usuario não utilizar nenhuma das opções
            throw new MovimentoInvalidoException();
        }
    }

    public boolean isFoodFound(int[] food) {
        if(coord[0] == food[0] && coord[1] == food[1]){
            return true;
        }
        else{
            return false;
        }
    }
}

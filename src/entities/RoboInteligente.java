package entities;
import exception.MovimentoInvalidoException;
import visual.Visual;
import java.util.ArrayList;

public class RoboInteligente extends Robo{

    private ArrayList<String> invalido = new ArrayList<>();

    public RoboInteligente(String color){
        super(color);
    }

    @Override
    public void Mover(String mov) throws MovimentoInvalidoException{
        precoord = coord;
        boolean movInvalido = true;
        while(movInvalido) {
            if (mov.equals("up") || mov.equals("1")) {
                if(isAlive) {
                    if (coord[0] > 0 && coord[0] < 3 && !invalido.contains("up")) {
                        Visual.removerRobo(coord[0], coord[1], color);
                        coord[0] -= 1;
                        Visual.addRobo(coord[0], coord[1], color);
                        invalido.clear();
                        mvRobo++;
                        movInvalido = false;
                    } else {
                        if (!invalido.contains("up")) {
                            invalido.add("up");
                            miRobo++;
                            throw new MovimentoInvalidoException("up");
                        } else {
                            throw new MovimentoInvalidoException();
                        }
                    }
                }
            } else if (mov.equals("down") || mov.equals("2")) {
                if(isAlive) {
                    if (coord[0] >= 0 && coord[0] < 2 && !invalido.contains("down")) {
                        Visual.removerRobo(coord[0], coord[1], color);
                        coord[0] += 1;
                        Visual.addRobo(coord[0], coord[1], color);
                        invalido.clear();
                        mvRobo++;
                        movInvalido = false;
                    } else {
                        if (!invalido.contains("down")) {
                            invalido.add("down");
                            miRobo++;
                            throw new MovimentoInvalidoException("down");
                        } else {
                            throw new MovimentoInvalidoException();
                        }
                    }
                }
            } else if (mov.equals("right") || mov.equals("3")) {
                if(isAlive) {
                    if (coord[1] >= 0 && coord[1] < 2 && !invalido.contains("right")) {
                        Visual.removerRobo(coord[0], coord[1], color);
                        coord[1] += 1;
                        Visual.addRobo(coord[0], coord[1], color);
                        invalido.clear();
                        mvRobo++;
                        movInvalido = false;
                    } else {
                        if (!invalido.contains("right")) {
                            invalido.add("right");
                            miRobo++;
                            throw new MovimentoInvalidoException("right");
                        } else {
                            throw new MovimentoInvalidoException();
                        }
                    }
                }
            } else if (mov.equals("left") || mov.equals("4")) {
                if(isAlive) {
                    if (coord[1] > 0 && coord[1] < 3 && !invalido.contains("left")) {
                        Visual.removerRobo(coord[0], coord[1], color);
                        coord[1] -= 1;
                        Visual.addRobo(coord[0], coord[1], color);
                        invalido.clear();
                        mvRobo++;
                        movInvalido = false;
                    } else {
                        if (!invalido.contains("left")) {
                            invalido.add("left");
                            miRobo++;
                            throw new MovimentoInvalidoException("left");
                        } else {
                            throw new MovimentoInvalidoException();
                        }
                    }
                }
            } else {
                throw new MovimentoInvalidoException();
            }
        }
    }
}

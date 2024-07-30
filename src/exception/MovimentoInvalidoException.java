package exception;
import visual.*;

public class MovimentoInvalidoException extends Exception{
    public MovimentoInvalidoException() {
        super("Movimento Invalido");
        Visual.excessao();
    }

    public MovimentoInvalidoException(String message) {
        super("Movimento Invalido: " + message);
        Visual.excessao(message);
    }
}
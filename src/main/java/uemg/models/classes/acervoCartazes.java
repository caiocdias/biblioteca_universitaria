package uemg.models.classes;
import uemg.models.enums.cartazesTipo;

public class acervoCartazes extends Acervo {
    private cartazesTipo cartazesTipo;

    public acervoCartazes() {
    }

    public acervoCartazes(cartazesTipo cartazesTipo, int acervoId, String acervoAutores, String acervoTitulo, int acervoAno, String acervoPalavrasChave, boolean acervoFlagEmprestado, String acervoCDU) {
        super(acervoId, acervoAutores, acervoTitulo, acervoAno, acervoPalavrasChave, acervoFlagEmprestado, acervoCDU);
        this.setCartazesTipo(cartazesTipo);
    }

    //Sets
    public cartazesTipo getCartazesTipo() {
        return cartazesTipo;
    }
    
    //Gets
    public void setCartazesTipo(cartazesTipo cartazesTipo) {
        this.cartazesTipo = cartazesTipo;
    }
}

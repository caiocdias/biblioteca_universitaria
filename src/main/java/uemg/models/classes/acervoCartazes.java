package uemg.models.classes;
import uemg.models.enums.cartazesTipo;

public class acervoCartazes extends Acervo {
    private cartazesTipo cartazesTipo;

    public acervoCartazes() {
    }

    public acervoCartazes(cartazesTipo cartazesTipo, int acervoId, String[] acervoAutores, String acervoTitulo, int acervoAno, String[] acervoPalavrasChave, boolean acervoFlagEmprestado, String acervoCDU) {
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
    
    @Override
    public String toString() {
        String res = ""; 
        for (String autor: super.getAcervoAutores()) {
            res += autor + ". ";
        }
        
        res += super.getAcervoId() + ".";
        res += "\n\n";
        res += super.getAcervoTitulo() + " - " + this.getCartazesTipo() + " - " + super.getAcervoAno() + ".";
        
        res += "\n\n";
        for (String palavra: super.getAcervoPalavrasChave()) {
            res += palavra + ". ";
        }
        
        res += "\n\n";
        if (super.isAcervoFlagEmprestado()) {
            res += "Emprestado";
        } else {
            res += "Disponivel";
        }
        
        res += "           CDU: " + super.getAcervoCDU();
        
        return res;
    }
    
}

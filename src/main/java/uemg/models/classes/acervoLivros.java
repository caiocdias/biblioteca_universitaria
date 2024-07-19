/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uemg.models.classes;

public class acervoLivros extends Acervo {

    private int livrosQtdPaginas;
    private int livrosEdicao;
    private String livrosEditora;
    private String livrosCidade;
    private String livrosISBN;

    public acervoLivros() {
    }

    public acervoLivros(int livrosQtdPaginas, int livrosEdicao, String livrosEditora, String livrosCidade, String livrosISBN, int acervoId, String[] acervoAutores, String acervoTitulo, int acervoAno, String[] acervoPalavrasChave, boolean acervoFlagEmprestado, String acervoCDU) {
        super(acervoId, acervoAutores, acervoTitulo, acervoAno, acervoPalavrasChave, acervoFlagEmprestado, acervoCDU);
        this.setLivrosQtdPaginas(livrosQtdPaginas);
        this.setLivrosEdicao(livrosEdicao);
        this.setLivrosEditora(livrosEditora);
        this.setLivrosCidade(livrosCidade);
        this.setLivrosISBN(livrosISBN);
    }

    
    //Gets
    public int getLivrosQtdPaginas() {
        return livrosQtdPaginas;
    }
    public int getLivrosEdicao() {
        return livrosEdicao;
    }
    public String getLivrosEditora() {
        return livrosEditora;
    }
    public String getLivrosCidade() {
        return livrosCidade;
    }
    public String getLivrosISBN() {
        return livrosISBN;
    }

    //Sets
    public void setLivrosQtdPaginas(int livrosQtdPaginas) {
        this.livrosQtdPaginas = livrosQtdPaginas;
    }
    public void setLivrosEdicao(int livrosEdicao) {
        this.livrosEdicao = livrosEdicao;
    }
    public void setLivrosEditora(String livrosEditora) {
        this.livrosEditora = livrosEditora;
    }
    public void setLivrosCidade(String livrosCidade) {
        this.livrosCidade = livrosCidade;
    }
    public void setLivrosISBN(String livrosISBN) {
        this.livrosISBN = livrosISBN;
    }

    @Override
    public String toString() {
        String res = ""; 
        for (String autor: super.getAcervoAutores()) {
            res += autor + ". ";
        }
        
        res += super.getAcervoId() + ".";
        res += "\n\n";
        res += super.getAcervoTitulo() + " - " + this.getLivrosEdicao() + " - " + this.getLivrosCidade() + " - " + this.getLivrosEditora() + " - " + super.getAcervoAno();
        res += "\n";
        
        res += this.getLivrosQtdPaginas();
        
        
        res += "\n\n";
        
        res += this.getLivrosISBN();
        
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

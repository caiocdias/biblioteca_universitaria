/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uemg.models.classes;
import uemg.models.enums.periodicosTipo;

public class acervoPeriodicos extends Acervo {

    private int periodicosQtdPaginas;
    private periodicosTipo periodicosTipo;
    private int periodicosEdicao;
    private String periodicosEditora;
    private String periodicosCidade;
    private String periodicosISBN;

    public acervoPeriodicos() {
    }

    public acervoPeriodicos(int periodicosQtdPaginas, periodicosTipo periodicosTipo, int periodicosEdicao, String periodicosEditora, String periodicosCidade, String periodicosISBN, int acervoId, String[] acervoAutores, String acervoTitulo, int acervoAno, String[] acervoPalavrasChave, boolean acervoFlagEmprestado, String acervoCDU) {
        super(acervoId, acervoAutores, acervoTitulo, acervoAno, acervoPalavrasChave, acervoFlagEmprestado, acervoCDU);
        this.setPeriodicosQtdPaginas(periodicosQtdPaginas);
        this.setPeriodicosTipo(periodicosTipo);
        this.setPeriodicosEdicao(periodicosEdicao);
        this.setPeriodicosEditora(periodicosEditora);
        this.setPeriodicosCidade(periodicosCidade);
        this.setPeriodicosISBN(periodicosISBN);
    }
    
    //Gets
    public int getPeriodicosQtdPaginas() {
        return periodicosQtdPaginas;
    }
    public periodicosTipo getPeriodicosTipo() {
        return periodicosTipo;
    }
    public int getPeriodicosEdicao() {
        return periodicosEdicao;
    }
    public String getPeriodicosEditora() {
        return periodicosEditora;
    }
    public String getPeriodicosCidade() {
        return periodicosCidade;
    }
    public String getPeriodicosISBN() {
        return periodicosISBN;
    }

    //Sets
    public void setPeriodicosQtdPaginas(int periodicosQtdPaginas) {
        this.periodicosQtdPaginas = periodicosQtdPaginas;
    }
    public void setPeriodicosTipo(periodicosTipo periodicosTipo) {
        this.periodicosTipo = periodicosTipo;
    }
    public void setPeriodicosEdicao(int periodicosEdicao) {
        this.periodicosEdicao = periodicosEdicao;
    }
    public void setPeriodicosEditora(String periodicosEditora) {
        this.periodicosEditora = periodicosEditora;
    }
    public void setPeriodicosCidade(String periodicosCidade) {
        this.periodicosCidade = periodicosCidade;
    }
    public void setPeriodicosISBN(String periodicosISBN) {
        this.periodicosISBN = periodicosISBN;
    }
    
    @Override
    public String toString() {
        String res = ""; 
        for (String autor: super.getAcervoAutores()) {
            res += autor + ". ";
        }
        
        res += super.getAcervoId() + ".";
        res += "\n\n";
        res += super.getAcervoTitulo() + " - " + this.getPeriodicosTipo() + " - " + this.getPeriodicosEdicao() + " - " + this.getPeriodicosEditora() + " - " + this.getPeriodicosCidade() + " - " + super.getAcervoAno() + ".";
        res += "\n";
        
        res += this.getPeriodicosQtdPaginas();
        
        res += "\n\n";
        
        res += this.getPeriodicosISBN();
        
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

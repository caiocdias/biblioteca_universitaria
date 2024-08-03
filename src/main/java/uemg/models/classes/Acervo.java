/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uemg.models.classes;
import java.util.Objects;

public class Acervo {

    private int acervoId;
    private String acervoAutores;
    private String acervoTitulo;
    private int acervoAno;
    private String acervoPalavrasChave;
    private boolean acervoFlagEmprestado;
    private String acervoCDU;
    
    //Gets
    public int getAcervoId() {
        return acervoId;
    }
    public String getAcervoAutores() {
        return acervoAutores;
    }
    public String getAcervoTitulo() {
        return acervoTitulo;
    }
    public int getAcervoAno() {
        return acervoAno;
    }
    public String getAcervoPalavrasChave() {
        return acervoPalavrasChave;
    }
    public boolean isAcervoFlagEmprestado() {
        return acervoFlagEmprestado;
    }
    public String getAcervoCDU() {
        return acervoCDU;
    }
    
    //Sets
    public void setAcervoId(int acervoId) {
        this.acervoId = acervoId;
    }
    public void setAcervoAutores(String acervoAutores) {
        this.acervoAutores = acervoAutores;
    }
    public void setAcervoTitulo(String acervoTitulo) {
        this.acervoTitulo = acervoTitulo;
    }
    public void setAcervoAno(int acervoAno) {
        this.acervoAno = acervoAno;
    }
    public void setAcervoPalavrasChave(String acervoPalavrasChave) {
        this.acervoPalavrasChave = acervoPalavrasChave;
    }
    public void setAcervoFlagEmprestado(boolean acervoFlagEmprestado) {
        this.acervoFlagEmprestado = acervoFlagEmprestado;
    }
    public void setAcervoCDU(String acervoCDU) {
        this.acervoCDU = acervoCDU;
    }

    public Acervo() {
    }

    public Acervo(int acervoId, String acervoAutores, String acervoTitulo, int acervoAno, String acervoPalavrasChave, boolean acervoFlagEmprestado, String acervoCDU) {
        this.setAcervoId(acervoId);
        this.setAcervoAutores(acervoAutores);
        this.setAcervoTitulo(acervoTitulo);
        this.setAcervoAno(acervoAno);
        this.setAcervoPalavrasChave(acervoPalavrasChave);
        this.setAcervoFlagEmprestado(acervoFlagEmprestado);
        this.setAcervoCDU(acervoCDU);
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == hashCode();

    }

    @Override
    public int hashCode() {
        return Objects.hash(acervoId);
    }
}

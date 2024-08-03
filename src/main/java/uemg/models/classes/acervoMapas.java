/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uemg.models.classes;

public class acervoMapas extends Acervo {
    private String mapalocal;
    private int mapaEdicao;

    public acervoMapas() {
    }

    public acervoMapas(String mapalocal, int mapaEdicao, int acervoId, String acervoAutores, String acervoTitulo, int acervoAno, String acervoPalavrasChave, boolean acervoFlagEmprestado, String acervoCDU) {
        super(acervoId, acervoAutores, acervoTitulo, acervoAno, acervoPalavrasChave, acervoFlagEmprestado, acervoCDU);
        this.setMapalocal(mapalocal);
        this.setMapaEdicao(mapaEdicao);
    }

    //Gets
    public String getMapalocal() {
        return mapalocal;
    }
    public int getMapaEdicao() {
        return mapaEdicao;
    }
 
    //Sets
    public void setMapalocal(String mapalocal) {
        this.mapalocal = mapalocal;
    }

    public void setMapaEdicao(int mapaEdicao) {
        this.mapaEdicao = mapaEdicao;
    }
}

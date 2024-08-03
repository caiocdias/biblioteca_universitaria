/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uemg.models.classes;

public class acervoRelatorios extends Acervo {

    private int relatoriosQtdPaginas;
    private String relatoriosEditora;
    private String relatoriosCidade;

    public acervoRelatorios() {
    }

    public acervoRelatorios(int relatoriosQtdPaginas, String relatoriosEditora, String relatoriosCidade, int acervoId, String acervoAutores, String acervoTitulo, int acervoAno, String acervoPalavrasChave, boolean acervoFlagEmprestado, String acervoCDU) {
        super(acervoId, acervoAutores, acervoTitulo, acervoAno, acervoPalavrasChave, acervoFlagEmprestado, acervoCDU);
        this.setRelatoriosQtdPaginas(relatoriosQtdPaginas);
        this.setRelatoriosEditora(relatoriosEditora);
        this.setRelatoriosCidade(relatoriosCidade);
    }

    //Gets
    public int getRelatoriosQtdPaginas() {
        return relatoriosQtdPaginas;
    }
    public String getRelatoriosEditora() {
        return relatoriosEditora;
    }
    public String getRelatoriosCidade() {
        return relatoriosCidade;
    }

    //Sets
    public void setRelatoriosQtdPaginas(int relatoriosQtdPaginas) {
        this.relatoriosQtdPaginas = relatoriosQtdPaginas;
    }
    public void setRelatoriosEditora(String relatoriosEditora) {
        this.relatoriosEditora = relatoriosEditora;
    }
    public void setRelatoriosCidade(String relatoriosCidade) {
        this.relatoriosCidade = relatoriosCidade;
    }
}

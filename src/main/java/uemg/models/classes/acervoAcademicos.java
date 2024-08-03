/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uemg.models.classes;
import uemg.models.enums.academicosTipo;

public class acervoAcademicos extends Acervo {

    private int academicosQtdPaginas;
    private academicosTipo academicosTipo;
    private String academicosEditora;
    private String academicosCidade;
    private String academicosDOI;

    public acervoAcademicos() {
    }

    public acervoAcademicos(int academicosQtdPaginas, academicosTipo academicosTipo, String academicosEditora, String academicosCidade, String academicosDOI, int acervoId, String acervoAutores, String acervoTitulo, int acervoAno, String acervoPalavrasChave, boolean acervoFlagEmprestado, String acervoCDU) {
        super(acervoId, acervoAutores, acervoTitulo, acervoAno, acervoPalavrasChave, acervoFlagEmprestado, acervoCDU);
        this.setAcademicosQtdPaginas(academicosQtdPaginas);
        this.setAcademicosTipo(academicosTipo);
        this.setAcademicosEditora(academicosEditora);
        this.setAcademicosCidade(academicosCidade);
        this.setAcademicosDOI(academicosDOI);
    }

    //Gets
    public int getAcademicosQtdPaginas() {
        return academicosQtdPaginas;
    }
    public academicosTipo getAcademicosTipo() {
        return academicosTipo;
    }
    public String getAcademicosEditora() {
        return academicosEditora;
    }
    public String getAcademicosCidade() {
        return academicosCidade;
    }
    public String getAcademicosDOI() {
        return academicosDOI;
    }

    //Sets
    public void setAcademicosQtdPaginas(int academicosQtdPaginas) {
        this.academicosQtdPaginas = academicosQtdPaginas;
    }
    public void setAcademicosTipo(academicosTipo academicosTipo) {
        this.academicosTipo = academicosTipo;
    }
    public void setAcademicosEditora(String academicosEditora) {
        this.academicosEditora = academicosEditora;
    }
    public void setAcademicosCidade(String academicosCidade) {
        this.academicosCidade = academicosCidade;
    }
    public void setAcademicosDOI(String academicosDOI) {
        this.academicosDOI = academicosDOI;
    }
}

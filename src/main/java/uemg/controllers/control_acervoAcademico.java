package uemg.controllers;

import uemg.dao.dao_acervoAcademicos;
import uemg.models.classes.Acervo;
import uemg.models.classes.acervoAcademicos;
import uemg.models.enums.academicosTipo;
import uemg.views.views_cadastro.view_cadastro_acervoAcademicos;

import javax.swing.*;
import java.util.ArrayList;

public class control_acervoAcademico {
    private view_cadastro_acervoAcademicos view;
    private ArrayList<Acervo> listAcervo;

    public control_acervoAcademico(view_cadastro_acervoAcademicos view) {
        this.view = view;
        this.listAcervo = new ArrayList<>();
    }

    public void cadastrarAcervo() {
        try {
            String titulo = view.getTxtTitulo().getText();
            int ano = Integer.parseInt(view.getTxtAno().getText());
            String cdu = view.getTxtCDU().getText();
            String palavrasChave = view.getTxtPChave().getText();
            String autor = view.getTxtAutor().getText();
            academicosTipo tipo = (academicosTipo) view.getCbTipo().getSelectedItem();
            String editora = view.getTxtEditora().getText();
            String cidade = view.getTxtCidade().getText();
            String doi = view.getTxtDOI().getText();
            int qtdPaginas = Integer.parseInt(view.getTxtQtdPag().getText());

            acervoAcademicos novoAcervo = new acervoAcademicos();
            novoAcervo.setAcervoTitulo(titulo);
            novoAcervo.setAcervoAno(ano);
            novoAcervo.setAcervoFlagEmprestado(false); //Errado por agora, vou corrigir depois
            novoAcervo.setAcervoCDU(cdu);
            novoAcervo.setAcervoPalavrasChave(palavrasChave);
            novoAcervo.setAcervoAutores(autor);
            novoAcervo.setAcademicosTipo(tipo);
            novoAcervo.setAcademicosEditora(editora);
            novoAcervo.setAcademicosCidade(cidade);
            novoAcervo.setAcademicosDOI(doi);
            novoAcervo.setAcademicosQtdPaginas(qtdPaginas);

            // Inserir no banco de dados
            boolean inserido = dao_acervoAcademicos.inserirAcervoAcademicosDB(novoAcervo);
            if (inserido) {
                JOptionPane.showMessageDialog(null, "Acervo inserido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao inserir o acervo.", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

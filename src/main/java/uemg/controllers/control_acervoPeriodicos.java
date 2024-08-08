package uemg.controllers;


import uemg.dao.dao_acervoPeriodicos;
import uemg.models.classes.acervoPeriodicos;
import uemg.models.enums.periodicosTipo;
import uemg.views.views_cadastro.view_cadastro_acervoPeriodicos;

import javax.swing.*;

public class control_acervoPeriodicos {
    private view_cadastro_acervoPeriodicos view = new view_cadastro_acervoPeriodicos();

    public control_acervoPeriodicos(view_cadastro_acervoPeriodicos view) {
        this.view = view;
    }

    public void cadastrarAcervoPeriodicos() {
        try {
            String titulo = view.getTxtTitulo().getText();
            int ano = Integer.parseInt(view.getTxtAno().getText());
            String cdu = view.getTxtCDU().getText();
            String palavrasChave = view.getTxtPChave().getText();
            String autor = view.getTxtAutor().getText();

            periodicosTipo tipo = (periodicosTipo) view.getComboTipo().getSelectedItem();
            String editora = view.getTxtEditora().getText();
            String cidade = view.getTxtCidade().getText();
            String ISBN = view.getTxtISBN().getText();
            int qtdPaginas = Integer.parseInt(view.getTxtQtdPag().getText());
            int edicao = Integer.parseInt(view.getTxtEdicao().getText());

            acervoPeriodicos novoAcervo = new acervoPeriodicos();
            novoAcervo.setAcervoTitulo(titulo);
            novoAcervo.setAcervoAno(ano);
            novoAcervo.setAcervoFlagEmprestado(false); //Errado por agora, vou corrigir depois
            novoAcervo.setAcervoCDU(cdu);
            novoAcervo.setAcervoPalavrasChave(palavrasChave);
            novoAcervo.setAcervoAutores(autor);
            novoAcervo.setPeriodicosTipo(tipo);
            novoAcervo.setPeriodicosEditora(editora);
            novoAcervo.setPeriodicosCidade(cidade);
            novoAcervo.setPeriodicosQtdPaginas(qtdPaginas);
            novoAcervo.setPeriodicosEdicao(edicao);
            novoAcervo.setPeriodicosISBN(ISBN);

            // Inserir no banco de dados
            boolean inserido = dao_acervoPeriodicos.inserirAcervoPeriodicosDB(novoAcervo);
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

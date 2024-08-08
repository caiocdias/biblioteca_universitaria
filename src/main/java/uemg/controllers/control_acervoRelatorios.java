package uemg.controllers;

import uemg.dao.dao_acervoRelatorios;
import uemg.models.classes.acervoRelatorios;
import uemg.views.views_cadastro.view_cadastro_acervoRelatorios;

import javax.swing.*;

public class control_acervoRelatorios {
    private view_cadastro_acervoRelatorios view;

    public control_acervoRelatorios(view_cadastro_acervoRelatorios view) {
        this.view = view;
    }

    public void cadastrarAcervoRelatorios() {
        try {
            String titulo = view.getTxtTitulo().getText();
            int ano = Integer.parseInt(view.getTxtAno().getText());
            String cdu = view.getTxtCDU().getText();
            String palavrasChave = view.getTxtPChave().getText();
            String autor = view.getTxtAutor().getText();


            String editora = view.getTxtEditora().getText();
            String cidade = view.getTxtCidade().getText();
            int qtdPaginas = Integer.parseInt(view.getTxtQtdPag().getText());

            acervoRelatorios novoAcervo = new acervoRelatorios();
            novoAcervo.setAcervoTitulo(titulo);
            novoAcervo.setAcervoAno(ano);
            novoAcervo.setAcervoFlagEmprestado(false); //Errado por agora, vou corrigir depois
            novoAcervo.setAcervoCDU(cdu);
            novoAcervo.setAcervoPalavrasChave(palavrasChave);
            novoAcervo.setAcervoAutores(autor);
            novoAcervo.setRelatoriosEditora(editora);
            novoAcervo.setRelatoriosCidade(cidade);
            novoAcervo.setRelatoriosQtdPaginas(qtdPaginas);


            // Inserir no banco de dados
            boolean inserido = dao_acervoRelatorios.inserirAcervoRelatoriosDB(novoAcervo);
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

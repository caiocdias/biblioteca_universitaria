package uemg.controllers;

import uemg.dao.dao_acervoMapas;
import uemg.models.classes.acervoMapas;
import uemg.views.views_cadastro.view_cadastro_acervoMapas;

import javax.swing.*;

public class control_acervoMapas {
    private view_cadastro_acervoMapas view;

    public control_acervoMapas(view_cadastro_acervoMapas view) {
        this.view = view;
    }

    public void cadastrarAcervoMapas() {
        try {
            String titulo = view.getTxtTitulo().getText();
            int ano = Integer.parseInt(view.getTxtAno().getText());
            String cdu = view.getTxtCDU().getText();
            String palavrasChave = view.getTxtPChave().getText();
            String autor = view.getTxtAutor().getText();

            String local = view.getTxtCidade().getText();
            int edicao = Integer.parseInt(view.getTxtEdicao().getText());

            acervoMapas novoAcervo = new acervoMapas();
            novoAcervo.setAcervoTitulo(titulo);
            novoAcervo.setAcervoAno(ano);
            novoAcervo.setAcervoFlagEmprestado(false); //Errado por agora, vou corrigir depois
            novoAcervo.setAcervoCDU(cdu);
            novoAcervo.setAcervoPalavrasChave(palavrasChave);
            novoAcervo.setAcervoAutores(autor);
            novoAcervo.setMapalocal(local);
            novoAcervo.setMapaEdicao(edicao);

            // Inserir no banco de dados
            boolean inserido = dao_acervoMapas.inserirAcervoMapasDB(novoAcervo);
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

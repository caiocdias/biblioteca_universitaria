package uemg.controllers;


import uemg.dao.dao_acervoMidias;
import uemg.models.classes.acervoMidias;
import uemg.models.enums.midiaTipo;
import uemg.views.views_cadastro.view_cadastro_acervoMidias;

import javax.swing.*;

public class control_acervoMidias {
    private view_cadastro_acervoMidias view;

    public control_acervoMidias(view_cadastro_acervoMidias view) {
        this.view = view;
    }

    public void cadastrarAcervoMidias() {
        try {
            String titulo = view.getTxtTitulo().getText();
            int ano = Integer.parseInt(view.getTxtAno().getText());
            String cdu = view.getTxtCDU().getText();
            String palavrasChave = view.getTxtPChave().getText();
            String autor = view.getTxtAutor().getText();

            midiaTipo tipo = (midiaTipo) view.getComboTipo().getSelectedItem();
            String produtora = view.getTxtProdutora().getText();
            String ISMN = view.getTxtISMN().getText();


            acervoMidias novoAcervo = new acervoMidias();
            novoAcervo.setAcervoTitulo(titulo);
            novoAcervo.setAcervoAno(ano);
            novoAcervo.setAcervoFlagEmprestado(false); //Errado por agora, vou corrigir depois
            novoAcervo.setAcervoCDU(cdu);
            novoAcervo.setAcervoPalavrasChave(palavrasChave);
            novoAcervo.setAcervoAutores(autor);
            novoAcervo.setMidiaTipo(tipo);
            novoAcervo.setMidiaProdutora(produtora);
            novoAcervo.setMidiaISMN(ISMN);

            // Inserir no banco de dados
            boolean inserido = dao_acervoMidias.inserirAcervoMidiasDB(novoAcervo);
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

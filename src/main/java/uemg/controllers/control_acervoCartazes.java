package uemg.controllers;

import uemg.models.classes.acervoCartazes;
import uemg.models.enums.cartazesTipo;
import uemg.views.views_cadastro.view_cadastro_acervoCartazes;
import uemg.dao.dao_acervoCartazes;
import javax.swing.*;

public class control_acervoCartazes {
    private view_cadastro_acervoCartazes view;

    public control_acervoCartazes(view_cadastro_acervoCartazes view){
        this.view = view;
    }

    public void cadastrarAcervoCartazes(){
        try {
            String titulo = view.getTxtTitulo().getText();
            int ano = Integer.parseInt(view.getTxtAno().getText());
            String cdu = view.getTxtCDU().getText();
            String palavrasChave = view.getTxtPChave().getText();
            String autor = view.getTxtAutor().getText();

            cartazesTipo tipo = (cartazesTipo) view.getComboTipo().getSelectedItem();

            acervoCartazes novoAcervo = new acervoCartazes();
            novoAcervo.setAcervoTitulo(titulo);
            novoAcervo.setAcervoAno(ano);
            novoAcervo.setAcervoFlagEmprestado(false); //Errado por agora, vou corrigir depois
            novoAcervo.setAcervoCDU(cdu);
            novoAcervo.setAcervoPalavrasChave(palavrasChave);
            novoAcervo.setAcervoAutores(autor);
            novoAcervo.setCartazesTipo(tipo);

            // Inserir no banco de dados
            boolean inserido = dao_acervoCartazes.inserirAcervoCartazesDB(novoAcervo);
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

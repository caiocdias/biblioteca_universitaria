package uemg.controllers;
import uemg.dao.dao_acervoLivros;
import uemg.models.classes.acervoLivros;
import uemg.views.views_cadastro.view_cadastro_acervoLivros;

import javax.swing.*;

public class control_acervoLivros {
    private view_cadastro_acervoLivros view;

    public control_acervoLivros(view_cadastro_acervoLivros view) {
        this.view = view;
    }

    public void cadastrarAcervoLivro() {
        try {
            String titulo = view.getTxtTitulo().getText();
            int ano = Integer.parseInt(view.getTxtAno().getText());
            String cdu = view.getTxtCDU().getText();
            String palavrasChave = view.getTxtPChave().getText();
            String autor = view.getTxtAutor().getText();


            String editora = view.getTxtEditora().getText();
            String cidade = view.getTxtCidade().getText();
            int qtdPaginas = Integer.parseInt(view.getTxtQtdPag().getText());
            String ISBN = view.getTxtISBN().getText();
            int edicao = Integer.parseInt(view.getTxtEdicao().getText());

            acervoLivros novoAcervo = new acervoLivros();
            novoAcervo.setAcervoTitulo(titulo);
            novoAcervo.setAcervoAno(ano);
            novoAcervo.setAcervoFlagEmprestado(false); //Errado por agora, vou corrigir depois
            novoAcervo.setAcervoCDU(cdu);
            novoAcervo.setAcervoPalavrasChave(palavrasChave);
            novoAcervo.setAcervoAutores(autor);
            novoAcervo.setLivrosEditora(editora);
            novoAcervo.setLivrosCidade(cidade);
            novoAcervo.setLivrosQtdPaginas(qtdPaginas);
            novoAcervo.setLivrosISBN(ISBN);
            novoAcervo.setLivrosEdicao(edicao);

            // Inserir no banco de dados
            boolean inserido = dao_acervoLivros.inserirAcervoLivrosDB(novoAcervo);
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

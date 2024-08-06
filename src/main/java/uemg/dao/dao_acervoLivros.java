package uemg.dao;

import uemg.models.classes.Acervo;
import uemg.models.classes.acervoLivros;
import uemg.singleton.MySqlConnectionSingleton;

import java.sql.*;
import java.util.ArrayList;

public class dao_acervoLivros {
    public static boolean inserirAcervoLivrosDB(acervoLivros acervoLivro) {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        try {
            connection.setAutoCommit(false);

            String insertAcervoSQL = "INSERT INTO TB_ACERVO (TITULO, ANO, FLAG_EMPRESTADO, CDU, PALAVRA_CHAVE, AUTOR) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement acervoStatement = connection.prepareStatement(insertAcervoSQL, Statement.RETURN_GENERATED_KEYS)) {
                acervoStatement.setString(1, acervoLivro.getAcervoTitulo());
                acervoStatement.setInt(2, acervoLivro.getAcervoAno());
                acervoStatement.setBoolean(3, acervoLivro.isAcervoFlagEmprestado());
                acervoStatement.setString(4, acervoLivro.getAcervoCDU());
                acervoStatement.setString(5, acervoLivro.getAcervoPalavrasChave());
                acervoStatement.setString(6, acervoLivro.getAcervoAutores());
                acervoStatement.executeUpdate();

                try (ResultSet generatedKeys = acervoStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int acervoId = generatedKeys.getInt(1);

                        String insertLivrosSQL = "INSERT INTO TB_ACERVO_LIVROS (QTD_PAGINAS, EDICAO, EDITORA, CIDADE, ISBN, ACERVO_ID) VALUES (?, ?, ?, ?, ?, ?)";
                        try (PreparedStatement livrosStatement = connection.prepareStatement(insertLivrosSQL)) {
                            livrosStatement.setInt(1, acervoLivro.getLivrosQtdPaginas());
                            livrosStatement.setInt(2, acervoLivro.getLivrosEdicao());
                            livrosStatement.setString(3, acervoLivro.getLivrosEditora());
                            livrosStatement.setString(4, acervoLivro.getLivrosCidade());
                            livrosStatement.setString(5, acervoLivro.getLivrosISBN());
                            livrosStatement.setInt(6, acervoId);
                            livrosStatement.executeUpdate();
                        }
                    }
                }
            }
            connection.commit();
            flag = true;
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return flag;
    }

    public static boolean alterarAcervoLivros(acervoLivros acervoLivro) {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        try {
            connection.setAutoCommit(false);

            // Atualizar TB_ACERVO
            String updateAcervoSQL =
                    "UPDATE TB_ACERVO SET TITULO = ?, ANO = ?, FLAG_EMPRESTADO = ?, CDU = ?, PALAVRA_CHAVE = ?, AUTOR = ? WHERE ACERVO_ID = ?";
            try (PreparedStatement acervoStatement = connection.prepareStatement(updateAcervoSQL)) {
                acervoStatement.setString(1, acervoLivro.getAcervoTitulo());
                acervoStatement.setInt(2, acervoLivro.getAcervoAno());
                acervoStatement.setBoolean(3, acervoLivro.isAcervoFlagEmprestado());
                acervoStatement.setString(4, acervoLivro.getAcervoCDU());
                acervoStatement.setString(5, acervoLivro.getAcervoPalavrasChave());
                acervoStatement.setString(6, acervoLivro.getAcervoAutores());
                acervoStatement.setInt(7, acervoLivro.getAcervoId());
                acervoStatement.executeUpdate();
            }

            // Atualizar TB_ACERVO_LIVROS
            String updateLivrosSQL =
                    "UPDATE TB_ACERVO_LIVROS SET QTD_PAGINAS = ?, EDICAO = ?, EDITORA = ?, CIDADE = ?, ISBN = ? WHERE ACERVO_ID = ?";
            try (PreparedStatement livrosStatement = connection.prepareStatement(updateLivrosSQL)) {
                livrosStatement.setInt(1, acervoLivro.getLivrosQtdPaginas());
                livrosStatement.setInt(2, acervoLivro.getLivrosEdicao());
                livrosStatement.setString(3, acervoLivro.getLivrosEditora());
                livrosStatement.setString(4, acervoLivro.getLivrosCidade());
                livrosStatement.setString(5, acervoLivro.getLivrosISBN());
                livrosStatement.setInt(6, acervoLivro.getAcervoId());
                livrosStatement.executeUpdate();
            }

            connection.commit();
            flag = true;
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return flag;
    }

    public static boolean excluirAcervoLivros(acervoLivros acervoLivro) {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        try {
            connection.setAutoCommit(false);

            String deleteFromAcervoSQL = "DELETE FROM TB_ACERVO WHERE ACERVO_ID = ?";
            try (PreparedStatement acervoStatement = connection.prepareStatement(deleteFromAcervoSQL)) {
                acervoStatement.setInt(1, acervoLivro.getAcervoId());
                int affectedRows = acervoStatement.executeUpdate();
                if (affectedRows > 0) {
                    flag = true;
                }
            }

            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return flag;
    }

    public static boolean getAllAcervoLivros(ArrayList<Acervo> listAcervo) {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        String selectFromAcervoSQL =
                "SELECT * FROM TB_ACERVO INNER JOIN TB_ACERVO_LIVROS TAL ON TB_ACERVO.ACERVO_ID = TAL.ACERVO_ID";

        try (PreparedStatement acervoStatement = connection.prepareStatement(selectFromAcervoSQL);
             ResultSet resultSet = acervoStatement.executeQuery()) {

            while (resultSet.next()) {
                //Especifico
                int livrosQtdPaginas  = resultSet.getInt("QTD_PAGINAS");
                int livrosEdicao = resultSet.getInt("EDICAO");
                String livrosEditora = resultSet.getString("EDITORA");
                String livrosCidade = resultSet.getString("CIDADE");
                String livrosISBN = resultSet.getString("ISBN");

                //Geral
                int acervoId = resultSet.getInt("ACERVO_ID");
                String acervoAutores = resultSet.getString("AUTOR");
                String acervoTitulo = resultSet.getString("TITULO");
                int acervoAno = resultSet.getInt("ANO");
                String acervoPalavrasChave = resultSet.getString("PALAVRA_CHAVE");
                boolean acervoFlagEmprestado = resultSet.getBoolean("FLAG_EMPRESTADO");
                String acervoCDU = resultSet.getString("CDU");

                acervoLivros acervoLivro = new acervoLivros(livrosQtdPaginas, livrosEdicao, livrosEditora, livrosCidade, livrosISBN, acervoId, acervoAutores, acervoTitulo, acervoAno, acervoPalavrasChave, acervoFlagEmprestado, acervoCDU);
                listAcervo.add(acervoLivro);
            }
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }
}

package uemg.dao;

import uemg.models.classes.Acervo;
import uemg.models.classes.acervoRelatorios;
import uemg.singleton.MySqlConnectionSingleton;

import java.sql.*;
import java.util.ArrayList;

public class dao_acervoRelatorios {
    public static boolean inserirAcervoRelatoriosDB(acervoRelatorios acervoRelatorios) throws SQLException {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        try {
            connection.setAutoCommit(false);

            String insertAcervoSQL = "INSERT INTO TB_ACERVO (TITULO, ANO, FLAG_EMPRESTADO, CDU, PALAVRA_CHAVE, AUTOR) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement acervoStatement = connection.prepareStatement(insertAcervoSQL, Statement.RETURN_GENERATED_KEYS)) {
                acervoStatement.setString(1, acervoRelatorios.getAcervoTitulo());
                acervoStatement.setInt(2, acervoRelatorios.getAcervoAno());
                acervoStatement.setBoolean(3, acervoRelatorios.isAcervoFlagEmprestado());
                acervoStatement.setString(4, acervoRelatorios.getAcervoCDU());
                acervoStatement.setString(5, acervoRelatorios.getAcervoPalavrasChave());
                acervoStatement.setString(6, acervoRelatorios.getAcervoAutores());
                acervoStatement.executeUpdate();

                try (ResultSet generatedKeys = acervoStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int acervoId = generatedKeys.getInt(1);

                        String insertRelatoriosSQL = "INSERT INTO TB_ACERVO_RELATORIOS (QTD_PAGINAS, EDITORA, CIDADE, ACERVO_ID) VALUES (?, ?, ?, ?)";
                        try (PreparedStatement relatoriosStatement = connection.prepareStatement(insertRelatoriosSQL)) {
                            relatoriosStatement.setInt(1, acervoRelatorios.getRelatoriosQtdPaginas());
                            relatoriosStatement.setString(2, acervoRelatorios.getRelatoriosEditora());
                            relatoriosStatement.setString(3, acervoRelatorios.getRelatoriosCidade());
                            relatoriosStatement.setInt(4, acervoId);
                            relatoriosStatement.executeUpdate();
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

    public static boolean alterarAcervoRelatoriosDB(acervoRelatorios acervoRelatorios) throws SQLException {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        try {
            connection.setAutoCommit(false);

            // Atualizar TB_ACERVO
            String updateAcervoSQL =
                    "UPDATE TB_ACERVO SET TITULO = ?, ANO = ?, FLAG_EMPRESTADO = ?, CDU = ?, PALAVRA_CHAVE = ?, AUTOR = ? WHERE ACERVO_ID = ?";
            try (PreparedStatement acervoStatement = connection.prepareStatement(updateAcervoSQL)) {
                acervoStatement.setString(1, acervoRelatorios.getAcervoTitulo());
                acervoStatement.setInt(2, acervoRelatorios.getAcervoAno());
                acervoStatement.setBoolean(3, acervoRelatorios.isAcervoFlagEmprestado());
                acervoStatement.setString(4, acervoRelatorios.getAcervoCDU());
                acervoStatement.setString(5, acervoRelatorios.getAcervoPalavrasChave());
                acervoStatement.setString(6, acervoRelatorios.getAcervoAutores());
                acervoStatement.setInt(7, acervoRelatorios.getAcervoId());
                acervoStatement.executeUpdate();
            }

            // Atualizar TB_ACERVO_RELATORIOS
            String updatePeriodicosSQL =
                    "UPDATE TB_ACERVO_RELATORIOS SET QTD_PAGINAS = ?, EDITORA = ?, CIDADE = ? WHERE ACERVO_ID = ?";
            try (PreparedStatement relatoriosStatement = connection.prepareStatement(updatePeriodicosSQL)) {
                relatoriosStatement.setInt(1, acervoRelatorios.getRelatoriosQtdPaginas());
                relatoriosStatement.setString(2, acervoRelatorios.getRelatoriosEditora());
                relatoriosStatement.setString(3, acervoRelatorios.getRelatoriosCidade());
                relatoriosStatement.setInt(4, acervoRelatorios.getAcervoId());
                relatoriosStatement.executeUpdate();
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

    public static boolean excluirAcervoRelatoriosDB(acervoRelatorios acervoRelatorios) throws SQLException {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        try {
            connection.setAutoCommit(false);

            String deleteFromAcervoSQL = "DELETE FROM TB_ACERVO WHERE ACERVO_ID = ?";
            try (PreparedStatement acervoStatement = connection.prepareStatement(deleteFromAcervoSQL)) {
                acervoStatement.setInt(1, acervoRelatorios.getAcervoId());
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

    public static boolean getAllAcervoRelatoriosDB(ArrayList<Acervo> listAcervo) throws SQLException {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        String selectFromAcervoSQL =
                "SELECT * FROM TB_ACERVO INNER JOIN TB_ACERVO_RELATORIOS tar ON TB_ACERVO.ACERVO_ID = tar.ACERVO_ID";

        try (PreparedStatement acervoStatement = connection.prepareStatement(selectFromAcervoSQL);
             ResultSet resultSet = acervoStatement.executeQuery()) {

            while (resultSet.next()) {
                //Especifico
                int relatoriosQtdPaginas = resultSet.getInt("QTD_PAGINAS");
                String relatoriosEditora = resultSet.getString("EDITORA");
                String relatoriosCidade = resultSet.getString("CIDADE");

                //Geral
                int acervoId = resultSet.getInt("ACERVO_ID");
                String acervoAutores = resultSet.getString("AUTOR");
                String acervoTitulo = resultSet.getString("TITULO");
                int acervoAno = resultSet.getInt("ANO");
                String acervoPalavrasChave = resultSet.getString("PALAVRA_CHAVE");
                boolean acervoFlagEmprestado = resultSet.getBoolean("FLAG_EMPRESTADO");
                String acervoCDU = resultSet.getString("CDU");

                acervoRelatorios acervoRelatorio = new acervoRelatorios(
                        relatoriosQtdPaginas, relatoriosEditora, relatoriosCidade,
                        acervoId, acervoAutores, acervoTitulo, acervoAno, acervoPalavrasChave, acervoFlagEmprestado, acervoCDU);
                listAcervo.add(acervoRelatorio);
            }
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }
}

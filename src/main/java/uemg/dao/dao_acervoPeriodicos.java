package uemg.dao;

import uemg.models.classes.Acervo;
import uemg.models.classes.acervoPeriodicos;
import uemg.models.enums.periodicosTipo;
import uemg.singleton.MySqlConnectionSingleton;

import java.sql.*;
import java.util.ArrayList;

public class dao_acervoPeriodicos {
    public static boolean inserirAcervoPeriodicosDB(acervoPeriodicos acervoPeriodicos) {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        try {
            connection.setAutoCommit(false);

            String insertAcervoSQL = "INSERT INTO TB_ACERVO (TITULO, ANO, FLAG_EMPRESTADO, CDU, PALAVRA_CHAVE, AUTOR) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement acervoStatement = connection.prepareStatement(insertAcervoSQL, Statement.RETURN_GENERATED_KEYS)) {
                acervoStatement.setString(1, acervoPeriodicos.getAcervoTitulo());
                acervoStatement.setInt(2, acervoPeriodicos.getAcervoAno());
                acervoStatement.setBoolean(3, acervoPeriodicos.isAcervoFlagEmprestado());
                acervoStatement.setString(4, acervoPeriodicos.getAcervoCDU());
                acervoStatement.setString(5, acervoPeriodicos.getAcervoPalavrasChave());
                acervoStatement.setString(6, acervoPeriodicos.getAcervoAutores());
                acervoStatement.executeUpdate();

                try (ResultSet generatedKeys = acervoStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int acervoId = generatedKeys.getInt(1);

                        String insertPeriodicosSQL = "INSERT INTO TB_ACERVO_PERIODICOS (QTD_PAGINAS, TIPO, EDICAO, EDITORA, CIDADE, ISBN, ACERVO_ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
                        try (PreparedStatement periodicosStatement = connection.prepareStatement(insertPeriodicosSQL)) {
                            periodicosStatement.setInt(1, acervoPeriodicos.getPeriodicosQtdPaginas());
                            periodicosStatement.setString(2, acervoPeriodicos.getPeriodicosTipo().toString());
                            periodicosStatement.setInt(3, acervoPeriodicos.getPeriodicosEdicao());
                            periodicosStatement.setString(4, acervoPeriodicos.getPeriodicosEditora());
                            periodicosStatement.setString(5, acervoPeriodicos.getPeriodicosCidade());
                            periodicosStatement.setString(6, acervoPeriodicos.getPeriodicosISBN());
                            periodicosStatement.setInt(7, acervoId);
                            periodicosStatement.executeUpdate();
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

    public static boolean alterarAcervoPeriodicosDB(acervoPeriodicos acervoPeriodicos) {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        try {
            connection.setAutoCommit(false);

            // Atualizar TB_ACERVO
            String updateAcervoSQL =
                    "UPDATE TB_ACERVO SET TITULO = ?, ANO = ?, FLAG_EMPRESTADO = ?, CDU = ?, PALAVRA_CHAVE = ?, AUTOR = ? WHERE ACERVO_ID = ?";
            try (PreparedStatement acervoStatement = connection.prepareStatement(updateAcervoSQL)) {
                acervoStatement.setString(1, acervoPeriodicos.getAcervoTitulo());
                acervoStatement.setInt(2, acervoPeriodicos.getAcervoAno());
                acervoStatement.setBoolean(3, acervoPeriodicos.isAcervoFlagEmprestado());
                acervoStatement.setString(4, acervoPeriodicos.getAcervoCDU());
                acervoStatement.setString(5, acervoPeriodicos.getAcervoPalavrasChave());
                acervoStatement.setString(6, acervoPeriodicos.getAcervoAutores());
                acervoStatement.setInt(7, acervoPeriodicos.getAcervoId());
                acervoStatement.executeUpdate();
            }

            // Atualizar TB_ACERVO_PERIODICOS
            String updatePeriodicosSQL =
                    "UPDATE TB_ACERVO_PERIODICOS SET QTD_PAGINAS = ?, TIPO = ?, EDICAO = ?, EDITORA = ?, CIDADE = ?, ISBN = ? WHERE ACERVO_ID = ?";
            try (PreparedStatement periodicosStatement = connection.prepareStatement(updatePeriodicosSQL)) {
                periodicosStatement.setInt(1, acervoPeriodicos.getPeriodicosQtdPaginas());
                periodicosStatement.setString(2, acervoPeriodicos.getPeriodicosTipo().toString());
                periodicosStatement.setInt(3, acervoPeriodicos.getPeriodicosEdicao());
                periodicosStatement.setString(4, acervoPeriodicos.getPeriodicosEditora());
                periodicosStatement.setString(5, acervoPeriodicos.getPeriodicosCidade());
                periodicosStatement.setString(6, acervoPeriodicos.getPeriodicosISBN());
                periodicosStatement.setInt(7, acervoPeriodicos.getAcervoId());
                periodicosStatement.executeUpdate();
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

    public static boolean excluirAcervoPeriodicosDB(acervoPeriodicos acervoPeriodicos) {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        try {
            connection.setAutoCommit(false);

            String deleteFromAcervoSQL = "DELETE FROM TB_ACERVO WHERE CDU = ?";
            try (PreparedStatement acervoStatement = connection.prepareStatement(deleteFromAcervoSQL)) {
                acervoStatement.setString(1, acervoPeriodicos.getAcervoCDU());
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

    public static boolean getAllAcervoPeriodicos(ArrayList<Acervo> listAcervo) {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        String selectFromAcervoSQL =
                "SELECT * FROM TB_ACERVO INNER JOIN TB_ACERVO_PERIODICOS tap ON TB_ACERVO.ACERVO_ID = tap.ACERVO_ID";

        try (PreparedStatement acervoStatement = connection.prepareStatement(selectFromAcervoSQL);
             ResultSet resultSet = acervoStatement.executeQuery()) {

            while (resultSet.next()) {
                //Especifico
                int periodicosQtdPaginas = resultSet.getInt("QTD_PAGINAS");
                periodicosTipo tipo;
                switch (resultSet.getString("TIPO")) {
                    case "REVISTAS":
                        tipo = periodicosTipo.REVISTAS;
                        break;
                    case "JORNAIS":
                        tipo = periodicosTipo.JORNAIS;
                        break;
                    default:
                        tipo = null;
                        break;
                }
                int periodicosEdicao = resultSet.getInt("EDICAO");
                String periodicosEditora = resultSet.getString("EDITORA");
                String periodicosCidade = resultSet.getString("CIDADE");
                String periodicosISBN = resultSet.getString("ISBN");

                //Geral
                int acervoId = resultSet.getInt("ACERVO_ID");
                String acervoAutores = resultSet.getString("AUTOR");
                String acervoTitulo = resultSet.getString("TITULO");
                int acervoAno = resultSet.getInt("ANO");
                String acervoPalavrasChave = resultSet.getString("PALAVRA_CHAVE");
                boolean acervoFlagEmprestado = resultSet.getBoolean("FLAG_EMPRESTADO");
                String acervoCDU = resultSet.getString("CDU");

                acervoPeriodicos acervoPeriodico = new acervoPeriodicos(
                        periodicosQtdPaginas, tipo, periodicosEdicao, periodicosEditora, periodicosCidade, periodicosISBN,
                        acervoId, acervoAutores, acervoTitulo, acervoAno, acervoPalavrasChave, acervoFlagEmprestado, acervoCDU);
                listAcervo.add(acervoPeriodico);
            }
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }
}

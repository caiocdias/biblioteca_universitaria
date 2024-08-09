package uemg.dao;

import uemg.models.classes.Acervo;
import uemg.models.classes.acervoCartazes;
import uemg.singleton.MySqlConnectionSingleton;
import uemg.models.enums.cartazesTipo;
import java.sql.*;
import java.util.ArrayList;

public class dao_acervoCartazes {
    public static boolean inserirAcervoCartazesDB(acervoCartazes acervoCartazes) throws SQLException {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        try {
            connection.setAutoCommit(false);

            String insertAcervoSQL = "INSERT INTO TB_ACERVO (TITULO, ANO, FLAG_EMPRESTADO, CDU, PALAVRA_CHAVE, AUTOR) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement acervoStatement = connection.prepareStatement(insertAcervoSQL, Statement.RETURN_GENERATED_KEYS)) {
                acervoStatement.setString(1, acervoCartazes.getAcervoTitulo());
                acervoStatement.setInt(2, acervoCartazes.getAcervoAno());
                acervoStatement.setBoolean(3, acervoCartazes.isAcervoFlagEmprestado());
                acervoStatement.setString(4, acervoCartazes.getAcervoCDU());
                acervoStatement.setString(5, acervoCartazes.getAcervoPalavrasChave());
                acervoStatement.setString(6, acervoCartazes.getAcervoAutores());
                acervoStatement.executeUpdate();

                try (ResultSet generatedKeys = acervoStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int acervoId = generatedKeys.getInt(1);

                        String insertCartazesSQL = "INSERT INTO TB_ACERVO_CARTAZES (TIPO, ACERVO_ID) VALUES (?, ?)";
                        try (PreparedStatement cartazesStatement = connection.prepareStatement(insertCartazesSQL)) {
                            cartazesStatement.setString(1, acervoCartazes.getCartazesTipo().toString());
                            cartazesStatement.setInt(2, acervoId);
                            cartazesStatement.executeUpdate();
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

    public static boolean alterarAcervoCartazesDB(acervoCartazes acervoCartazes) throws SQLException {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        try {
            connection.setAutoCommit(false);

            // Atualizar TB_ACERVO
            String updateAcervoSQL =
                    "UPDATE TB_ACERVO SET TITULO = ?, ANO = ?, FLAG_EMPRESTADO = ?, CDU = ?, PALAVRA_CHAVE = ?, AUTOR = ? WHERE ACERVO_ID = ?";
            try (PreparedStatement acervoStatement = connection.prepareStatement(updateAcervoSQL)) {
                acervoStatement.setString(1, acervoCartazes.getAcervoTitulo());
                acervoStatement.setInt(2, acervoCartazes.getAcervoAno());
                acervoStatement.setBoolean(3, acervoCartazes.isAcervoFlagEmprestado());
                acervoStatement.setString(4, acervoCartazes.getAcervoCDU());
                acervoStatement.setString(5, acervoCartazes.getAcervoPalavrasChave());
                acervoStatement.setString(6, acervoCartazes.getAcervoAutores());
                acervoStatement.setInt(7, acervoCartazes.getAcervoId());
                acervoStatement.executeUpdate();
            }

            // Atualizar TB_ACERVO_CARTAZES
            String updateCartazesSQL =
                    "UPDATE TB_ACERVO_CARTAZES SET TIPO = ? WHERE ACERVO_ID = ?";
            try (PreparedStatement cartazesStatement = connection.prepareStatement(updateCartazesSQL)) {
                cartazesStatement.setString(1, acervoCartazes.getCartazesTipo().toString());
                cartazesStatement.setInt(2, acervoCartazes.getAcervoId());
                cartazesStatement.executeUpdate();
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

    public static boolean excluirAcervoCartazesDB(acervoCartazes acervoCartazes) throws SQLException {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        try {
            connection.setAutoCommit(false);
            String deleteFromAcervoSQL = "DELETE FROM TB_ACERVO WHERE ACERVO_ID = ?";
            try (PreparedStatement acervoStatement = connection.prepareStatement(deleteFromAcervoSQL)) {
                acervoStatement.setInt(1, acervoCartazes.getAcervoId());
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

    public static boolean getAllAcervoCartazesDB(ArrayList<Acervo> listAcervo) throws SQLException {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        String selectFromAcervoSQL =
                "SELECT * FROM TB_ACERVO INNER JOIN TB_ACERVO_CARTAZES tac ON TB_ACERVO.ACERVO_ID = tac.ACERVO_ID";

        try (PreparedStatement acervoStatement = connection.prepareStatement(selectFromAcervoSQL);
             ResultSet resultSet = acervoStatement.executeQuery()) {

            while (resultSet.next()) {
                //Especifico
                cartazesTipo tipo;
                switch (resultSet.getString("TIPO")) {
                    case "FILME":
                        tipo = cartazesTipo.FILME;
                        break;
                    case "ESPORTE":
                        tipo = cartazesTipo.ESPORTE;
                        break;
                    case "PECA":
                        tipo = cartazesTipo.PECA;
                        break;
                    case "SERIE":
                        tipo = cartazesTipo.SERIE;
                        break;
                    case "POLITICO":
                        tipo = cartazesTipo.POLITICO;
                        break;
                    case "OUTRO":
                        tipo = cartazesTipo.OUTRO;
                        break;
                    default:
                        tipo = null;
                        break;
                }

                //Geral
                int acervoId = resultSet.getInt("ACERVO_ID");
                String acervoAutores = resultSet.getString("AUTOR");
                String acervoTitulo = resultSet.getString("TITULO");
                int acervoAno = resultSet.getInt("ANO");
                String acervoPalavrasChave = resultSet.getString("PALAVRA_CHAVE");
                boolean acervoFlagEmprestado = resultSet.getBoolean("FLAG_EMPRESTADO");
                String acervoCDU = resultSet.getString("CDU");

                acervoCartazes acervoCartazes = new acervoCartazes(
                        tipo, acervoId, acervoAutores, acervoTitulo, acervoAno, acervoPalavrasChave, acervoFlagEmprestado, acervoCDU
                );
                listAcervo.add(acervoCartazes);
            }
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }
}

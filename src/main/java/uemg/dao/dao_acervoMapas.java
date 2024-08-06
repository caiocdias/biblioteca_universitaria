package uemg.dao;

import uemg.models.classes.Acervo;
import uemg.models.classes.acervoMapas;
import uemg.singleton.MySqlConnectionSingleton;

import java.sql.*;
import java.util.ArrayList;

public class dao_acervoMapas {
    public static boolean inserirAcervoMapasDB(acervoMapas acervoMapas) {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        try {
            connection.setAutoCommit(false);

            String insertAcervoSQL = "INSERT INTO TB_ACERVO (TITULO, ANO, FLAG_EMPRESTADO, CDU, PALAVRA_CHAVE, AUTOR) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement acervoStatement = connection.prepareStatement(insertAcervoSQL, Statement.RETURN_GENERATED_KEYS)) {
                acervoStatement.setString(1, acervoMapas.getAcervoTitulo());
                acervoStatement.setInt(2, acervoMapas.getAcervoAno());
                acervoStatement.setBoolean(3, acervoMapas.isAcervoFlagEmprestado());
                acervoStatement.setString(4, acervoMapas.getAcervoCDU());
                acervoStatement.setString(5, acervoMapas.getAcervoPalavrasChave());
                acervoStatement.setString(6, acervoMapas.getAcervoAutores());
                acervoStatement.executeUpdate();

                try (ResultSet generatedKeys = acervoStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int acervoId = generatedKeys.getInt(1);

                        String insertMapasSQL = "INSERT INTO TB_ACERVO_MAPAS (LOCALIZACAO, EDICAO, ACERVO_ID) VALUES (?, ?, ?)";
                        try (PreparedStatement mapasStatement = connection.prepareStatement(insertMapasSQL)) {
                            mapasStatement.setString(1, acervoMapas.getMapalocal());
                            mapasStatement.setInt(2, acervoMapas.getMapaEdicao());
                            mapasStatement.setInt(3, acervoId);
                            mapasStatement.executeUpdate();
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

    public static boolean alterarAcervoMapasDB(acervoMapas acervoMapas) {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        try {
            connection.setAutoCommit(false);

            // Atualizar TB_ACERVO
            String updateAcervoSQL =
                    "UPDATE TB_ACERVO SET TITULO = ?, ANO = ?, FLAG_EMPRESTADO = ?, CDU = ?, PALAVRA_CHAVE = ?, AUTOR = ? WHERE ACERVO_ID = ?";
            try (PreparedStatement acervoStatement = connection.prepareStatement(updateAcervoSQL)) {
                acervoStatement.setString(1, acervoMapas.getAcervoTitulo());
                acervoStatement.setInt(2, acervoMapas.getAcervoAno());
                acervoStatement.setBoolean(3, acervoMapas.isAcervoFlagEmprestado());
                acervoStatement.setString(4, acervoMapas.getAcervoCDU());
                acervoStatement.setString(5, acervoMapas.getAcervoPalavrasChave());
                acervoStatement.setString(6, acervoMapas.getAcervoAutores());
                acervoStatement.setInt(7, acervoMapas.getAcervoId());
                acervoStatement.executeUpdate();
            }

            // Atualizar TB_ACERVO_MAPAS
            String updateMapasSQL =
                    "UPDATE TB_ACERVO_MAPAS SET LOCALIZACAO = ?, EDICAO = ? WHERE ACERVO_ID = ?";
            try (PreparedStatement mapasStatement = connection.prepareStatement(updateMapasSQL)) {
                mapasStatement.setString(1, acervoMapas.getMapalocal());
                mapasStatement.setInt(2, acervoMapas.getMapaEdicao());
                mapasStatement.setInt(3, acervoMapas.getAcervoId());
                mapasStatement.executeUpdate();
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

    public static boolean excluirAcervoMapasDB(acervoMapas acervoMapas) {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        try {
            connection.setAutoCommit(false);

            String deleteFromAcervoSQL = "DELETE FROM TB_ACERVO WHERE ACERVO_ID = ?";
            try (PreparedStatement acervoStatement = connection.prepareStatement(deleteFromAcervoSQL)) {
                acervoStatement.setInt(1, acervoMapas.getAcervoId());
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

    public static boolean getAllAcervoMapasDB(ArrayList<Acervo> listAcervo) {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        String selectFromAcervoSQL =
                "SELECT * FROM TB_ACERVO INNER JOIN TB_ACERVO_MAPAS tam ON TB_ACERVO.ACERVO_ID = tam.ACERVO_ID";

        try (PreparedStatement acervoStatement = connection.prepareStatement(selectFromAcervoSQL);
             ResultSet resultSet = acervoStatement.executeQuery()) {

            while (resultSet.next()) {
                //Especifico
                String mapalocal = resultSet.getString("LOCALIZACAO");
                int mapaEdicao = resultSet.getInt("EDICAO");

                //Geral
                int acervoId = resultSet.getInt("ACERVO_ID");
                String acervoAutores = resultSet.getString("AUTOR");
                String acervoTitulo = resultSet.getString("TITULO");
                int acervoAno = resultSet.getInt("ANO");
                String acervoPalavrasChave = resultSet.getString("PALAVRA_CHAVE");
                boolean acervoFlagEmprestado = resultSet.getBoolean("FLAG_EMPRESTADO");
                String acervoCDU = resultSet.getString("CDU");

                acervoMapas acervoMapa = new acervoMapas(mapalocal, mapaEdicao, acervoId, acervoAutores, acervoTitulo, acervoAno, acervoPalavrasChave, acervoFlagEmprestado, acervoCDU);
                listAcervo.add(acervoMapa);
            }
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

}

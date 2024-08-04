package uemg.dao;

import uemg.models.classes.Acervo;
import uemg.models.classes.acervoMidias;
import uemg.models.enums.midiaTipo;
import uemg.singleton.MySqlConnectionSingleton;

import java.sql.*;
import java.util.ArrayList;

public class dao_acervoMidias {
    public static boolean inserirAcervoMidiasDB(acervoMidias acervoMidia) {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        try {
            connection.setAutoCommit(false);

            String insertAcervoSQL = "INSERT INTO TB_ACERVO (TITULO, ANO, FLAG_EMPRESTADO, CDU, PALAVRA_CHAVE, AUTOR) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement acervoStatement = connection.prepareStatement(insertAcervoSQL, Statement.RETURN_GENERATED_KEYS)) {
                acervoStatement.setString(1, acervoMidia.getAcervoTitulo());
                acervoStatement.setInt(2, acervoMidia.getAcervoAno());
                acervoStatement.setBoolean(3, acervoMidia.isAcervoFlagEmprestado());
                acervoStatement.setString(4, acervoMidia.getAcervoCDU());
                acervoStatement.setString(5, acervoMidia.getAcervoPalavrasChave());
                acervoStatement.setString(6, acervoMidia.getAcervoAutores());
                acervoStatement.executeUpdate();

                try (ResultSet generatedKeys = acervoStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int acervoId = generatedKeys.getInt(1);

                        String insertMidiasSQL = "INSERT INTO TB_ACERVO_MIDIAS (TIPO, PRODUTORA, ISMN, ACERVO_ID) VALUES (?, ?, ?, ?)";
                        try (PreparedStatement midiasStatement = connection.prepareStatement(insertMidiasSQL)) {
                            midiasStatement.setString(1, acervoMidia.getMidiaTipo().toString());
                            midiasStatement.setString(2, acervoMidia.getMidiaProdutora());
                            midiasStatement.setString(3, acervoMidia.getMidiaISMN());
                            midiasStatement.setInt(4, acervoId);
                            midiasStatement.executeUpdate();
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

    public static boolean alterarAcervoMidiasDB(acervoMidias acervoMidia) {
        return true;
    }

    public static boolean excluirAcervoMidiasDB(acervoMidias acervoMidia) {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean success = false;

        try {
            connection.setAutoCommit(false);

            String deleteFromAcervoSQL = "DELETE FROM TB_ACERVO WHERE CDU = ?";
            try (PreparedStatement acervoStatement = connection.prepareStatement(deleteFromAcervoSQL)) {
                acervoStatement.setString(1, acervoMidia.getAcervoCDU());
                int affectedRows = acervoStatement.executeUpdate();
                if (affectedRows > 0) {
                    success = true;
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
        return success;
    }

    public static boolean getAllAcervoMidiasDB(ArrayList<Acervo> listAcervo) {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean success = false;

        String selectFromAcervoSQL =
                "SELECT * FROM TB_ACERVO INNER JOIN TB_ACERVO_MIDIAS tam ON TB_ACERVO.ACERVO_ID = tam.ACERVO_ID";

        try (PreparedStatement acervoStatement = connection.prepareStatement(selectFromAcervoSQL);
             ResultSet resultSet = acervoStatement.executeQuery()) {

            while (resultSet.next()) {
                //Especifico
                midiaTipo tipo;
                switch (resultSet.getString("TIPO")) {
                    case "VHS":
                        tipo = midiaTipo.VHS;
                        break;
                    case "CD":
                        tipo = midiaTipo.CDS;
                        break;
                    case "DVD":
                        tipo = midiaTipo.DVD;
                        break;
                    default:
                        tipo = null;
                        break;
                }
                String midiaProdutora = resultSet.getString("PRODUTORA");
                String midiaISMN = resultSet.getString("ISMN");

                //Geral
                int acervoId = resultSet.getInt("ACERVO_ID");
                String acervoAutores = resultSet.getString("AUTOR");
                String acervoTitulo = resultSet.getString("TITULO");
                int acervoAno = resultSet.getInt("ANO");
                String acervoPalavrasChave = resultSet.getString("PALAVRA_CHAVE");
                boolean acervoFlagEmprestado = resultSet.getBoolean("FLAG_EMPRESTADO");
                String acervoCDU = resultSet.getString("CDU");

                acervoMidias acervoMidia = new acervoMidias(tipo, midiaProdutora, midiaISMN, acervoId, acervoAutores, acervoTitulo, acervoAno, acervoPalavrasChave, acervoFlagEmprestado, acervoCDU);
                listAcervo.add(acervoMidia);
            }
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

}
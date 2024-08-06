package uemg.dao;

import uemg.models.classes.Acervo;
import uemg.models.classes.acervoAcademicos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import uemg.models.enums.academicosTipo;
import uemg.singleton.MySqlConnectionSingleton;

public class dao_acervoAcademicos {

    public static boolean inserirAcervoAcademicosDB(acervoAcademicos acervoAcademico) throws SQLException {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        try {
            connection.setAutoCommit(false);

            String insertAcervoSQL = "INSERT INTO TB_ACERVO (TITULO, ANO, FLAG_EMPRESTADO, CDU, PALAVRA_CHAVE, AUTOR) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement acervoStatement = connection.prepareStatement(insertAcervoSQL, Statement.RETURN_GENERATED_KEYS)) {
                acervoStatement.setString(1, acervoAcademico.getAcervoTitulo());
                acervoStatement.setInt(2, acervoAcademico.getAcervoAno());
                acervoStatement.setBoolean(3, acervoAcademico.isAcervoFlagEmprestado());
                acervoStatement.setString(4, acervoAcademico.getAcervoCDU());
                acervoStatement.setString(5, acervoAcademico.getAcervoPalavrasChave());
                acervoStatement.setString(6, acervoAcademico.getAcervoAutores());
                acervoStatement.executeUpdate();

                // Obter o ACERVO_ID gerado
                try (ResultSet generatedKeys = acervoStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int acervoId = generatedKeys.getInt(1);

                        String insertAcademicosSQL = "INSERT INTO TB_ACERVO_ACADEMICOS (QTD_PAGINAS, TIPO, EDITORA, CIDADE, DOI, ACERVO_ID) VALUES (?, ?, ?, ?, ?, ?)";
                        try (PreparedStatement academicosStatement = connection.prepareStatement(insertAcademicosSQL)) {
                            academicosStatement.setInt(1, acervoAcademico.getAcademicosQtdPaginas());
                            academicosStatement.setString(2, acervoAcademico.getAcademicosTipo().toString());
                            academicosStatement.setString(3, acervoAcademico.getAcademicosEditora());
                            academicosStatement.setString(4, acervoAcademico.getAcademicosCidade());
                            academicosStatement.setString(5, acervoAcademico.getAcademicosDOI());
                            academicosStatement.setInt(6, acervoId);
                            academicosStatement.executeUpdate();
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

    public static boolean alterarAcervoAcademicosDB(acervoAcademicos acervoAcademico) throws SQLException {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        try {
            connection.setAutoCommit(false);

            // Atualizar TB_ACERVO
            String updateAcervoSQL =
                    "UPDATE TB_ACERVO SET TITULO = ?, ANO = ?, FLAG_EMPRESTADO = ?, CDU = ?, PALAVRA_CHAVE = ?, AUTOR = ? WHERE ACERVO_ID = ?";
            try (PreparedStatement acervoStatement = connection.prepareStatement(updateAcervoSQL)) {
                acervoStatement.setString(1, acervoAcademico.getAcervoTitulo());
                acervoStatement.setInt(2, acervoAcademico.getAcervoAno());
                acervoStatement.setBoolean(3, acervoAcademico.isAcervoFlagEmprestado());
                acervoStatement.setString(4, acervoAcademico.getAcervoCDU());
                acervoStatement.setString(5, acervoAcademico.getAcervoPalavrasChave());
                acervoStatement.setString(6, acervoAcademico.getAcervoAutores());
                acervoStatement.setInt(7, acervoAcademico.getAcervoId());
                acervoStatement.executeUpdate();
            }

            // Atualizar TB_ACERVO_ACADEMICOS
            String updateAcademicosSQL =
                    "UPDATE TB_ACERVO_ACADEMICOS SET TIPO = ?, EDITORA = ?, CIDADE = ?, DOI = ? WHERE ACERVO_ID = ?";
            try (PreparedStatement academicosStatement = connection.prepareStatement(updateAcademicosSQL)) {
                academicosStatement.setString(1, acervoAcademico.getAcademicosTipo().toString());
                academicosStatement.setString(2, acervoAcademico.getAcademicosEditora());
                academicosStatement.setString(3, acervoAcademico.getAcademicosCidade());
                academicosStatement.setString(4, acervoAcademico.getAcademicosDOI());
                academicosStatement.setInt(5, acervoAcademico.getAcervoId());
                academicosStatement.executeUpdate();
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

    public static boolean excluirAcervoAcademicosDB(acervoAcademicos acervoAcademico) throws SQLException {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        try {
            connection.setAutoCommit(false);

            String deleteFromAcervoSQL = "DELETE FROM TB_ACERVO WHERE ACERVO_ID = ?";
            try (PreparedStatement acervoStatement = connection.prepareStatement(deleteFromAcervoSQL)) {
                acervoStatement.setInt(1, acervoAcademico.getAcervoId());
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

    public static boolean getAllAcervoAcademicosDB(ArrayList<Acervo> listAcervo) throws SQLException {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean flag = false;

        String selectFromAcervoSQL =
                "SELECT * FROM TB_ACERVO INNER JOIN TB_ACERVO_ACADEMICOS taa ON TB_ACERVO.ACERVO_ID = taa.ACERVO_ID";

        try (PreparedStatement acervoStatement = connection.prepareStatement(selectFromAcervoSQL);
             ResultSet resultSet = acervoStatement.executeQuery()) {

            while (resultSet.next()) {
                //Especifico
                int academicosQtdPaginas = resultSet.getInt("QTD_PAGINAS");

                academicosTipo tipo;
                switch (resultSet.getString("TIPO")) {
                    case "TESE":
                        tipo = academicosTipo.TESE;
                        break;
                    case "MONOGRAFIA":
                        tipo = academicosTipo.MONOGRAFIA;
                        break;
                    case "DISSERTACAO":
                        tipo = academicosTipo.DISSERTACAO;
                        break;
                    default:
                        tipo = null;
                        break;
                }

                String academicosEditora = resultSet.getString("EDITORA");
                String academicosCidade = resultSet.getString("CIDADE");
                String academicosDOI = resultSet.getString("DOI");

                //Geral
                int acervoId = resultSet.getInt("ACERVO_ID");
                String acervoAutores = resultSet.getString("AUTOR");
                String acervoTitulo = resultSet.getString("TITULO");
                int acervoAno = resultSet.getInt("ANO");
                String acervoPalavrasChave = resultSet.getString("PALAVRA_CHAVE");
                boolean acervoFlagEmprestado = resultSet.getBoolean("FLAG_EMPRESTADO");
                String acervoCDU = resultSet.getString("CDU");

                acervoAcademicos acervoAcademico = new acervoAcademicos(
                        academicosQtdPaginas, tipo, academicosEditora, academicosCidade, academicosDOI,
                        acervoId, acervoAutores, acervoTitulo, acervoAno, acervoPalavrasChave, acervoFlagEmprestado, acervoCDU
                );
                listAcervo.add(acervoAcademico);
            }
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

}

package uemg.dao;

import uemg.models.classes.Acervo;
import uemg.models.classes.acervoAcademicos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import uemg.singleton.MySqlConnectionSingleton;

public class dao_acervoAcademicos {

    public static boolean inserirAcervoAcademicoDB(acervoAcademicos acervoAcademico) throws SQLException {
        Connection connection = MySqlConnectionSingleton.getInstance().getConnection();
        boolean success = false;

        try {
            connection.setAutoCommit(false); // Iniciar transação

            // Inserir no TB_ACERVO
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

                        // Inserir no TB_ACERVO_ACADEMICOS
                        String insertAcademicosSQL = "INSERT INTO TB_ACERVO_ACADEMICOS (TIPO, EDITORA, CIDADE, DOI, ACERVO_ID) VALUES (?, ?, ?, ?, ?)";
                        try (PreparedStatement academicosStatement = connection.prepareStatement(insertAcademicosSQL)) {
                            academicosStatement.setString(1, acervoAcademico.getAcademicosTipo().toString());
                            academicosStatement.setString(2, acervoAcademico.getAcademicosEditora());
                            academicosStatement.setString(3, acervoAcademico.getAcademicosCidade());
                            academicosStatement.setString(4, acervoAcademico.getAcademicosDOI());
                            academicosStatement.setInt(5, acervoId);
                            academicosStatement.executeUpdate();
                        }
                    }
                }
            }
            connection.commit(); // Confirmar transação
            success = true;
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(); // Reverter transação em caso de erro
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true); // Restaurar comportamento padrão de auto-commit
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return success;
    }

    public static boolean alterarAcervoAcademicoDB(acervoAcademicos acervoAcademico) throws SQLException {
        // Implementar lógica de atualização aqui
        return true;
    }

    public static boolean excluirAcervoAcademicoDB(acervoAcademicos acervoAcademico) throws SQLException {
        // Implementar lógica de exclusão aqui
        return true;
    }

    public static boolean getAllAcervoAcademicoDB(ArrayList<Acervo> listAcervo) throws SQLException {
        // Implementar lógica para obter todos os registros aqui
        return true;
    }
}
